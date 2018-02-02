package com.dhruba.controllers;

import java.io.BufferedOutputStream;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dhruba.image.AdminImage;
import com.dhruba.image.Image;

import com.dhruba.image.ImageService;
import com.dhruba.page.Page;
import com.dhruba.reminder.Reminder;
import com.dhruba.reminder.ReminderService;
import com.dhruba.user.User;

@Controller
@Scope("session")
public class ImageController {

	@Autowired
	ImageService imageService;
	@Autowired
	ServletContext context;
	@Autowired
	ReminderService reminderService;
	@Autowired
	User user;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private AdminImage adminImage;

	@RequestMapping(value = "/createimageform/{division}/{title}")
	public String callImageForm(Model model, @PathVariable int division, @PathVariable String title,
			HttpSession session) {
		session.setAttribute("division", division);
		model.addAttribute("image", new Image());
		model.addAttribute("imagelst", imageService.getImageList());
		model.addAttribute("title", title);
		session.setAttribute("imagename", "");
		return "form_uploadimage";
		// return "redirect:content";
	}

	@RequestMapping(value = "/uploadselectedimage")
	public String callUploadImage(Model model, @RequestParam("name") String name, HttpSession session) {
		session.setAttribute("imagename", name);
		model.addAttribute("imagename", name);
		model.addAttribute("imagelst", imageService.getImageList());
		return "form_uploadimage";
	}

	@RequestMapping(value = "/calladminform")
	public String callImageFormByAdmin(Model model) {
		List<AdminImage> imagelst = imageService.getImageListForAdmin();
		List<AdminImage> parentimagelst = imageService.getImageList();
		model.addAttribute("imagebyadmin", new AdminImage());
		model.addAttribute("parentimagelst", parentimagelst);
		model.addAttribute("imagelst", imagelst);
		return "form_uploadimagebyadmin";
		// return "form_uploadimage";
	}

	@RequestMapping(value = "/getSubImage", method = {
			RequestMethod.POST }, headers = "Accept=*/*", produces = "application/json")
	public @ResponseBody Object getSubImage(@RequestBody String imageid, Model model)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		AdminImage objImage = mapper.readValue(imageid, AdminImage.class);
		List<AdminImage> subImageList = imageService.getSubImagelst(objImage);
		model.addAttribute("subImageList", subImageList);
		// return "redirect:calladminform";
		ObjectMapper objMap = new ObjectMapper();
		String str = new String();
		str = objMap.writeValueAsString(subImageList);
		return str;

	}

	@RequestMapping(value = "/callpopup")
	public String callPopup(Model model) {
		model.addAttribute("imagelst", imageService.getImageList());
		return "form_uploadimagepopup";
		// return "form_uploadimage";
	}

	@RequestMapping(value = "/callimagelist")
	public String callImageList(Model model, HttpSession session) {
		model.addAttribute("imagelst", imageService.getImageList());

		User user = (User) session.getAttribute("user");

		// creates a simple e-mail object
		SimpleMailMessage email = new SimpleMailMessage();
		String recipientAddress = "iechha26@gmail.com";
		String subject = "Data has been collected for the user:" + user.getUsername();
		String message = "Please check the database and make sure of it. Thank you!!";

		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message);

		// sends the e-mail
		mailSender.send(email);
		return "imagegallery";

	}

	@RequestMapping(value = "/uploadimage", method = { RequestMethod.POST })
	public String uploadImage(@Valid Image image, BindingResult result, ModelMap modelMap, HttpSession session,
			Model model) throws IOException {

		if (result.hasErrors()) {
			model.addAttribute("image", image);
			model.addAttribute("imagelst", imageService.getImageList());
			modelMap.put(BindingResult.class.getName() + ".image", result);
			return "form_uploadimage";

		} else {
			// destination folder where image will be uploaded

			image.setUrl((String) session.getAttribute("imagename"));

			Page page = (Page) session.getAttribute("page");
			image.setPage(page);
			int number = (int) session.getAttribute("division");
			image.setDivision(number);
			if (imageService.checkImageExist(image)) {
				imageService.updateImage(image);
			} else {
				imageService.createImage(image);
			}
		}
		return "redirect:/callcontent";
	}

	@RequestMapping(value = "/uploadimagebyadmin", method = { RequestMethod.POST })
	public String uploadImageByAdmin(@Valid AdminImage image, BindingResult result, ModelMap modelMap,

			@RequestParam CommonsMultipartFile file, @RequestParam CommonsMultipartFile randomimagefile,

			@RequestParam CommonsMultipartFile similarimagefile, Model model) throws IOException {
		if (result.hasErrors() || file.isEmpty()) {
			model.addAttribute("imagebyadmin", image);
			List<AdminImage> parentimagelst = imageService.getImageList();
			model.addAttribute("parentimagelst", parentimagelst);
			modelMap.put(BindingResult.class.getName() + ".imagebyadmin", result);
			return "form_uploadimagebyadmin";
		}

		else {

			String webappRoot = context.getRealPath("/");
			String relativeFolder = File.separator + "resources" + File.separator + "galleryimage" + File.separator;

			String img1 = file.getOriginalFilename();
			String img1withoutspace = img1.replaceAll("\\s", "");

			String img2 = randomimagefile.getOriginalFilename();
			String img2withoutspace = img2.replaceAll("\\s", "");

			String img3 = similarimagefile.getOriginalFilename();
			String img3withoutspace = img3.replaceAll("\\s", "");

			String fileName = webappRoot + relativeFolder + img1withoutspace;
			String randomFileName = webappRoot + relativeFolder + img2withoutspace;
			String similarFileName = webappRoot + relativeFolder + img3withoutspace;

			File newFile = new File(fileName);
			File randomFile = new File(randomFileName);
			File similarFile = new File(similarFileName);

			if (image.isHaveSubimage()) {
				if (!newFile.exists() || !randomFile.exists() || !similarFile.exists()) {

					if (!newFile.exists()) {
						newFile.createNewFile();
						BufferedOutputStream fileWriter = new BufferedOutputStream(new FileOutputStream(newFile));
						try {
							byte[] bytes = file.getBytes();
							fileWriter.write(bytes);
						} catch (Exception e) {
							// TODO: handle exception
						} finally {
							fileWriter.close();

						}

					} else if (!randomFile.exists()) {
						randomFile.createNewFile();
						BufferedOutputStream fileWriterforRandomFile = new BufferedOutputStream(
								new FileOutputStream(randomFile));
						try {
							byte[] bytesForRandomImage = randomimagefile.getBytes();
							fileWriterforRandomFile.write(bytesForRandomImage);
						} catch (Exception e) {
							// TODO: handle exception
						} finally {
							fileWriterforRandomFile.close();
						}
					} else {
						similarFile.createNewFile();
						BufferedOutputStream fileWriterforSimilarFile = new BufferedOutputStream(
								new FileOutputStream(similarFile));
						try {
							byte[] bytesForSimilarImage = similarimagefile.getBytes();
							fileWriterforSimilarFile.write(bytesForSimilarImage);
						} catch (Exception e) {
						} finally {
							fileWriterforSimilarFile.close();
						}
					}
				}

				image.setImagename(img1withoutspace);
				image.setRandomimage(img2withoutspace);
				image.setSimilarimage(img3withoutspace);

				imageService.createImageByAdmin(image);
				imageService.createRandomSubImage(image);
				imageService.createSimilarSubImage(image);
			}

			else {
				if (!newFile.exists()) {
					System.out.println("newfile:" + newFile);
					newFile.createNewFile();
					BufferedOutputStream fileWriter = new BufferedOutputStream(new FileOutputStream(newFile));
					try {
						byte[] bytes = file.getBytes();
						fileWriter.write(bytes);

					} catch (Exception e) {

					} finally {
						fileWriter.close();
					}
				}
				image.setImagename(img1withoutspace);
				imageService.createImageByAdmin(image);
			}

		}
		return "redirect:/calladminform";
	}

	@RequestMapping(value = "/setRandomId", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json")
	public @ResponseBody Object setRandomId(@RequestBody String imageString, HttpSession session)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		AdminImage objImage = mapper.readValue(imageString, AdminImage.class);

		session.setAttribute("subimageidforrandom", objImage.getSubimageid());

		String result = new String("true");

		return result;
	}

	@RequestMapping(value = "/updateRandomImg", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json")
	public @ResponseBody String updateRandomImg(MultipartHttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {

		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf = request.getFile(itr.next());

		String webappRoot = context.getRealPath("/");
		String relativeFolder = File.separator + "resources" + File.separator + "galleryimage" + File.separator;

		String randomImageWithSpace = mpf.getOriginalFilename();
		String randomImageWithoutSpace = randomImageWithSpace.replaceAll("\\s", "");

		String fileName = webappRoot + relativeFolder + randomImageWithoutSpace;

		File newFile = new File(fileName);

		if (!newFile.exists()) {
			newFile.createNewFile();
			BufferedOutputStream fileWriter = new BufferedOutputStream(new FileOutputStream(newFile));
			try {
				byte[] bytes = mpf.getBytes();
				fileWriter.write(bytes);
			} catch (Exception e) {

			} finally {
				fileWriter.close();
			}

		}
		adminImage.setImagename(randomImageWithoutSpace);
		int subimageid = (int) session.getAttribute("subimageidforrandom");

		adminImage.setSubimageid(subimageid);
		adminImage.setSubimagename(randomImageWithoutSpace);
		imageService.updateRandomImage(adminImage);
		return "Update successful";

	}

	@RequestMapping(value = "/setSimilarId", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json")
	public @ResponseBody Object setSimilarId(@RequestBody String imageString, HttpSession session)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		AdminImage objImage = mapper.readValue(imageString, AdminImage.class);

		session.setAttribute("subimageidforsimilar", objImage.getSubimageid());

		String result = new String("true");

		return result;
	}

	@RequestMapping(value = "/deleteParentImage", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json")
	public @ResponseBody Object deleteParentImage(@RequestBody String imageString, HttpSession session)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		AdminImage objImage = mapper.readValue(imageString, AdminImage.class);

		imageService.deleteParentImage(objImage);

		String result = new String("true");

		return result;
	}

	@RequestMapping(value = "/updateSimilarImg", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json")
	public @ResponseBody String updateSimilarImg(MultipartHttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {

		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf = request.getFile(itr.next());

		String webappRoot = context.getRealPath("/");
		String relativeFolder = File.separator + "resources" + File.separator + "galleryimage" + File.separator;

		String similarImageWithSpace = mpf.getOriginalFilename();
		String similarImageWithoutSpace = similarImageWithSpace.replaceAll("\\s", "");

		String fileName = webappRoot + relativeFolder + similarImageWithoutSpace;

		File newFile = new File(fileName);

		if (!newFile.exists()) {
			newFile.createNewFile();
			BufferedOutputStream fileWriter = new BufferedOutputStream(new FileOutputStream(newFile));
			try {
				byte[] bytes = mpf.getBytes();
				fileWriter.write(bytes);
			} catch (Exception e) {

			} finally {
				fileWriter.close();
			}

		}
		adminImage.setImagename(similarImageWithoutSpace);
		int subimageid = (int) session.getAttribute("subimageidforsimilar");

		adminImage.setSubimageid(subimageid);
		adminImage.setSubimagename(similarImageWithoutSpace);
		imageService.updateSimilarImage(adminImage);

		return "Update successful";

	}

	@RequestMapping(value = "/getImageHavingRandomSubImg", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json")
	public @ResponseBody Object getImageHavingRandomSubImg()
			throws JsonGenerationException, JsonMappingException, IOException {
		List<AdminImage> lstImage = imageService.getImageWithRandomSubImg();
		String strImg = new String();
		ObjectMapper mapper = new ObjectMapper();
		strImg = mapper.writeValueAsString(lstImage);
		return strImg;
	}

	@RequestMapping(value = "/getImageHavingSimilarSubImg", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json")
	public @ResponseBody Object getImageHavingSimilarSubImg()
			throws JsonGenerationException, JsonMappingException, IOException {
		List<AdminImage> lstImage = imageService.getImageWithSimilarSubImg();
		String strImg = new String();
		ObjectMapper mapper = new ObjectMapper();
		strImg = mapper.writeValueAsString(lstImage);
		return strImg;
	}

	@RequestMapping(value = "/getImageHavingNoSubImg", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json")
	public @ResponseBody Object getImageHavingNoSubImg()
			throws JsonGenerationException, JsonMappingException, IOException {
		List<AdminImage> lstImage = imageService.getImageHavingNoSubImg();
		String strImg = new String();
		ObjectMapper mapper = new ObjectMapper();
		strImg = mapper.writeValueAsString(lstImage);
		return strImg;
	}

	@RequestMapping(value = "/saveImageDescription", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json")
	public @ResponseBody Object saveImageDescription(@RequestBody String strData,HttpSession session)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		AdminImage objImageDescription = mapper.readValue(strData, AdminImage.class);
		imageService.saveImageDescription(objImageDescription,session);

		String result = new String("true");
		return result;
	}
	@RequestMapping(value="/saveEvaluation", method=RequestMethod.POST, headers = "Accept=*/*", produces = "application/json")
	public @ResponseBody Object saveEvaluation(@RequestBody String strEvaluation) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper objMapper=new ObjectMapper();
		AdminImage objEvaluation=objMapper.readValue(strEvaluation,AdminImage.class);
		imageService.saveEvaluation(objEvaluation);
		String result=new String("true");
		return result;
	}
	
	@RequestMapping(value="/callImageDescriptionToEvaluate", method=RequestMethod.POST, headers = "Accept=*/*", produces = "application/json")
	public @ResponseBody Object callImageDescriptionToEvaluate(HttpSession session) throws JsonParseException, JsonMappingException, IOException{
		User user=(User)session.getAttribute("user");
		List<AdminImage>lstEvaluation=imageService.callImageDescriptionToEvaluate(user);
		String result=new String();
		ObjectMapper objMapper=new ObjectMapper();
		result=objMapper.writeValueAsString(lstEvaluation);
		return result;
	}

}
