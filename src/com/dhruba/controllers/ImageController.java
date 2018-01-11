package com.dhruba.controllers;

import java.io.BufferedOutputStream;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dhruba.image.AdminImage;
import com.dhruba.image.Image;

import com.dhruba.image.ImageService;
import com.dhruba.page.Page;

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

	@RequestMapping(value = "/createimageform/{division}/{title}")
	public String callImageForm(Model model, @PathVariable int division,@PathVariable String title, HttpSession session) {
		session.setAttribute("division", division);
		model.addAttribute("image", new Image());
		model.addAttribute("imagelst", imageService.getImageList());
		model.addAttribute("title", title);
		session.setAttribute("imagename", "");
		return "form_uploadimage";
		//return "redirect:content";
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
		model.addAttribute("imagebyadmin", new Image());
		return "form_uploadimagebyadmin";
		// return "form_uploadimage";
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
		
		User user= (User)session.getAttribute("user");
		
		// creates a simple e-mail object
        SimpleMailMessage email = new SimpleMailMessage();
        String recipientAddress="iechha26@gmail.com";
        String subject="Data has been collected for the user:"+user.getUsername();
        String message="Please check the database and make sure of it. Thank you!!";
        
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
			@RequestParam CommonsMultipartFile file, Model model) throws IOException {
		if (result.hasErrors() || file.isEmpty()) {
			model.addAttribute("imagebyadmin", image);
			modelMap.put(BindingResult.class.getName() + ".imagebyadmin", result);
			return "form_uploadimagebyadmin";

		} else {
			String webappRoot = context.getRealPath("/");
			String relativeFolder = File.separator + "resources" + File.separator + "galleryimage" + File.separator;
			String fileName = webappRoot + relativeFolder + file.getOriginalFilename();
			File newFile = new File(fileName);
			if (!newFile.exists())
				newFile.createNewFile();
			// get file as a byte array
			BufferedOutputStream fileWriter = new BufferedOutputStream(new FileOutputStream(newFile));
			try {
				byte[] bytes = file.getBytes();
				// write bytes to the new file
				fileWriter.write(bytes);
			} catch (Exception e) {

			} finally {
				fileWriter.close();
			}
			image.setImagename(file.getOriginalFilename());
			imageService.createImageByAdmin(image);
		}
		return "redirect:/calladminform";
	}

}
