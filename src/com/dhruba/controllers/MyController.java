package com.dhruba.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.validation.Valid;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dhruba.image.AdminImage;
import com.dhruba.image.Image;
import com.dhruba.image.ImageService;
import com.dhruba.image.TestImage;
import com.dhruba.page.Page;
import com.dhruba.page.PageService;
import com.dhruba.reminder.Reminder;
import com.dhruba.text.TextContent;
import com.dhruba.text.TextContentService;
import com.dhruba.user.User;
import com.dhruba.user.UserDetail;
import com.dhruba.user.UserService;
import com.mysql.jdbc.Blob;

@Controller
@Component
@Scope("session")
public class MyController {

	@Autowired
	User user;
	@Autowired
	Page page;
	@Autowired
	PageService service;
	@Autowired
	Image image;
	@Autowired
	ImageService imageService;
	@Autowired
	TextContentService textService;
	@Autowired
	private Reminder reminder;
	@Autowired
	private UserDetail userDetail;
	@Autowired
	private UserService userService;
	@Autowired
    private JavaMailSender mailSender;
	@Autowired
	private TestImage testImage;
	@Autowired
	ServletContext context;
	
	@RequestMapping("/evaluationform")
	public String getEvaluaitonForm(Model model){
		return "form_evaluation";
	}
	
	@RequestMapping("/getdescriptionforhumanjudgement")
	public String getDescriptionForHumanJudgement(Model model){
		AdminImage objDescription=imageService.getDescriptionForHumanJudgement();
		model.addAttribute("descriptionObject", objDescription);
		List<AdminImage>lstGuidelines=imageService.getGuidelines(objDescription);
		model.addAttribute("guidelinelist", lstGuidelines);
		
		return "form_evaluation";
	}
	
	
	@RequestMapping(value = "/saveHumanJudgement", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json")
	public @ResponseBody Object saveHumanJudgement(@RequestBody String strData,HttpSession session)
			throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<AdminImage>> mapType = new TypeReference<List<AdminImage>>() {};
		List<AdminImage> lstDescription = mapper.readValue(strData, mapType);
		imageService.saveHumanJudgement(lstDescription);
		
		String result = new String("true");
		return result;	
	}
	

	@RequestMapping("/getuserdetailform")
	public String getUserDetail(Model model) {
		model.addAttribute("userDetail", new UserDetail());
		return "form_userdetail";
	}
	
	
	
	@RequestMapping("/thankyoupage")
	public String getThankyouPage(){
		return "thankyou";
	}
	
	@RequestMapping("/fileupload")
	public String fileUpload(){
		return "test";
	}
	
	@RequestMapping("/tryMethod")
	public String tryMethod(@RequestParam("file") MultipartFile file, HttpServletResponse response, Model model) throws SerialException, SQLException, IOException{
		
		testImage.setFileStream(file.getInputStream());
		if(imageService.saveTestFile(testImage)){
			List<TestImage>imgList=imageService.selectTestFile();
			
			for(TestImage img: imgList){
				ByteArrayOutputStream baos=new ByteArrayOutputStream();
				byte[]buff=new byte[1024];
				java.sql.Blob blob=img.getImagefile();
				InputStream in=blob.getBinaryStream();
				int n = 0;
			    while ((n=in.read(buff))>=0)
			    {
			        baos.write(buff, 0, n);

			    }
			    in.close();
			    byte[] bytes = baos.toByteArray();
			    byte[] encodeBase64 = Base64.encode(buff);
			    String base64Encoded = new String(encodeBase64, "UTF-8");
			    
			    response.setContentType("image/jpeg");
			    response.getOutputStream().write(bytes);
			    response.getOutputStream().flush();
			    response.getOutputStream().close();
			    model.addAttribute("image",base64Encoded);
			}
					
		}
			
		return "test";
	}


	@RequestMapping("/enteruser")
	public String enterUserDetail(Model model, @Valid UserDetail userDetail, BindingResult result, ModelMap modelMap,
			HttpSession session) {

		if (result.hasErrors()) {
			model.addAttribute("userDetail", userDetail);
			modelMap.put(BindingResult.class.getName() + ".userDetail", result);
			return "form_userdetail";
		} else {
			if (!userService.checkIfUserExist(userDetail)) {
				SimpleMailMessage email = new SimpleMailMessage();
		        String recipientAddress=userDetail.getEmail();
		        String subject="Online Experiment for Image Description";
		        String message="";
		        message+="Dear Participant,";
		        message+="\r\n";
		        message+="\r\n I would like to thank you for your cooperation in this work.";
		        message+="\r\n";
		        message+="\r\n If you are interested in this topic, you can contact me in the future to know about the result of this research.";
		        message+="\r\n";
		        message+="User Name:";
		        message+="\r\n";
		        message+=userDetail.getEmail();
		        message+="\r\n";
		        message+="Password:";
		        message+="\r\n";
		        message+="password123";
		        message+="\r\n";
		        message+="\r\n";
		        message+=" Pleas go to this link :http://localhost:8080/SimpleWebPage/createuserlogin";
		        message+="\r\n";
		        message+="\r\n";
		        message+="Thank you!!";
		        message+="\r\n";
		        message+="Dhruba Dahal";
		        message+="\r\n";
		        message+="Student, HiOA, Norway";
		        email.setTo(recipientAddress);
		        email.setSubject(subject);
		        email.setText(message);
		             
		        try {
		        	mailSender.send(email);
		        	int saveresult = userService.enterUserDetail(userDetail);
					if (saveresult > 0){
						userDetail = userService.getUserDetailId(userDetail);
						session.setAttribute("userDetail", userDetail);
						user.setFullname(userDetail.getEmail());
						user.setUsername(userDetail.getEmail());
						user.setPassword("password123");
						user.setEmail(userDetail.getEmail());
						user.setAwareof(false);
						userService.saveUser(user);
						
					}
						
		         } catch (Exception e) {
					model.addAttribute("message", "There is some problem in sending email.");
					return "form_userdetail";
				} 
		    } else {
				model.addAttribute("message", "This email address has already been registered.");
				return "form_userdetail";
			}

		}
		return "emailverification";
	}
	
	@RequestMapping("/experimentpage")
	public String getExperimentpage(Model model){
		model.addAttribute("experiment", new Image());
		return "experimentpage";
	}

	@RequestMapping("/userlogin")
	public String getUserLogin(Model model) {
		model.addAttribute("userlogin", new User());
		return "userlogin";
	}
	@RequestMapping("/")
	public String getOverview() {
		return "overview";
	}


	@RequestMapping("/adminpage")
	public String getAdminPage() {
		return "adminpage";
	}

	@RequestMapping("/uploadimage")
	public String getUploadImage() {
		return "uploadimage";
	}

	@RequestMapping("/linkedin")
	public String getLinkedinPage() {
		return "redirect:" + "http://www.linkedin.com/in/dhruba-dahal";
	}

	@RequestMapping("/login")
	public String getLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/callcontentfirsttime")
	public String callContentPageFirstTime(Model model, HttpSession session) {
		// get user name and save it as page name in db
		user = (User) session.getAttribute("user");
		reminder = (Reminder) session.getAttribute("reminder");
		page.setReminder(reminder);
		page.setUser(user);
		page.setPagename(user.getUsername());
		if (service.createPage(page)) {
			page = service.getPageDetailByName(page);

			session.setAttribute("page", page);
		} else {
			page = service.getPageDetailByName(page);

			session.setAttribute("page", page);
		}
		return "redirect:callcontent";
	}

	@RequestMapping(value = "/callcontent")
	public String callContentPage(Model model, HttpSession session) {

		Page page = (Page) session.getAttribute("page");
		java.util.List<Image> lstImageContent = imageService.getImageContentList(page);
		User user = (User) session.getAttribute("user");
		List<TextContent> lstTextContent = textService.getTextContentList(user);
		model.addAttribute("textlst", lstTextContent);
		model.addAttribute("imagelst", lstImageContent);
		model.addAttribute("contentCount", lstTextContent.size());
		return "content";

	}

	@RequestMapping(value = "/checkreminder", method = { RequestMethod.GET,
			RequestMethod.POST }, headers = "Accept=*/*", produces = "application/json")
	public @ResponseBody Object getReminder(HttpSession session)
			throws JsonGenerationException, JsonMappingException, IOException {
		Reminder reminder = (Reminder) session.getAttribute("reminder");
		ObjectMapper objMap = new ObjectMapper();
		String str = new String();
		str = objMap.writeValueAsString(reminder);
		return str;
	}

	@RequestMapping(value = "/callgallery")
	public String callImageGallery(Model model) {
		List<AdminImage> imagelst = imageService.getImageList();
		model.addAttribute("imagelst", imagelst);
		return "imagegallery";
	}

}
