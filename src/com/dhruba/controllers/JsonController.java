package com.dhruba.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.dhruba.image.Image;
import com.dhruba.image.ImageService;
import com.dhruba.page.Page;
import com.dhruba.reminder.Reminder;
import com.dhruba.reminder.ReminderService;
import com.dhruba.user.User;
import com.dhruba.user.UserService;

@Controller
@Scope("session")
public class JsonController {
	@Autowired
	ReminderService reminderService;

	@Autowired
	ServletContext context;
	@Autowired
	ImageService imageService;
	@Autowired
	UserService userService;
	@Autowired
	User user;
	

	//@RequestMapping(value = "/getReminder", method = RequestMethod.GET, headers = "Accept=*", produces = "application/json")
	//public @ResponseBody Object getReminder() throws JsonGenerationException, JsonMappingException, IOException {
		//Reminder ObjReminder = reminderService.getReminder();
		//ObjectMapper objMap = new ObjectMapper();
		//String str = new String();
		//str = objMap.writeValueAsString(ObjReminder);
		//return str;

	//}
	
	@RequestMapping(value = "/getReminder", method = RequestMethod.GET, headers = "Accept=*/*", produces = "application/json")
	public @ResponseBody Object getReminder(HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
		
		
		User user = (User)session.getAttribute("user");
		
		ObjectMapper objMap = new ObjectMapper();
		String str = new String();
		str = objMap.writeValueAsString(user);
		
		
		return str;

	}

	@RequestMapping("/testpage")
	public String getTestPage(Model model) {
		String isReminder = "no";
		Reminder ObjReminder = reminderService.getReminder();
		if (ObjReminder.getCheck())
			isReminder = "yes";
		model.addAttribute("reminderStatus", isReminder);
		return "testpage";
	}

	@RequestMapping(value = "/saveAltText", method = { RequestMethod.GET,
			RequestMethod.POST }, headers = "Accept=*/*", produces = "application/json")
	public @ResponseBody Object saveAltText(@RequestBody String alt)
			throws JsonGenerationException, JsonMappingException, IOException {
		

		ObjectMapper mapper = new ObjectMapper();
		Image imgObj = mapper.readValue(alt, Image.class);
		

		Reminder ObjReminder = reminderService.getReminder();
		ObjectMapper objMap = new ObjectMapper();
		String str = new String();
		str = objMap.writeValueAsString(ObjReminder);
		return str;

	}

	@RequestMapping(value = "/uploadFile", method = { RequestMethod.GET,
			RequestMethod.POST }, headers = "Accept=*/*", produces = "application/json")
	public @ResponseBody Object uploadFile(@RequestParam("file") MultipartFile file, HttpSession session)
			throws JsonGenerationException, JsonMappingException, IOException {

		// destination folder where image will be uploaded
		String webappRoot = context.getRealPath("/");
		String relativeFolder = File.separator + "resources" + File.separator + "image" + File.separator;
		String fileName = webappRoot + relativeFolder + file.getOriginalFilename();

		session.setAttribute("uploadedFile", file.getOriginalFilename());
		
		File newFile = new File(fileName);

		if (!newFile.exists())
			newFile.createNewFile();
		// get file as a byte array
		BufferedOutputStream fileWriter = new BufferedOutputStream(new FileOutputStream(newFile));

		byte[] bytes = file.getBytes();
		// write bytes to the new file
		fileWriter.write(bytes);
		fileWriter.close();

		Reminder ObjReminder = reminderService.getReminder();
		ObjectMapper objMap = new ObjectMapper();
		String str = new String();
		str = objMap.writeValueAsString(ObjReminder);

		return str;

	}

	// @RequestMapping(value = "/saveField", method = {
		//	RequestMethod.POST }, headers = "Accept=*/*", produces = "application/json")
	/* public @ResponseBody Object saveField(@RequestBody String field, HttpSession session)
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Image objImage = mapper.readValue(field, Image.class);
		objImage.setUrl(session.getAttribute("uploadedFile").toString());
		Page page = (Page) session.getAttribute("page");
		
		objImage.setPage(page);
		int number = (int) session.getAttribute("division");
		objImage.setDivision(number);
		if (objImage.getAlttext().length() != 0) {
			
			if (imageService.checkImageExist(objImage)) {
				imageService.updateImage(objImage);
			} else {
				imageService.createImage(objImage);
			}
		} else {
			
			session.setAttribute("sessionImageObj", objImage);
		}

		Reminder ObjReminder = reminderService.getReminder();
		ObjectMapper objMap = new ObjectMapper();
		String str = new String();
		str = objMap.writeValueAsString(ObjReminder);
		return str;
	}*/
			
	@RequestMapping(value = "/saveField", method = {
			RequestMethod.POST }, headers = "Accept=*/*", produces = "application/json")
	
	public @ResponseBody Object saveField(@RequestBody String field, HttpSession session)
			throws JsonGenerationException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		Image objImage = mapper.readValue(field, Image.class);
		objImage.setUrl(session.getAttribute("imagename").toString());
		
		Page page = (Page) session.getAttribute("page");

		objImage.setPage(page);
		int number = (int) session.getAttribute("division");
		
		objImage.setDivision(number);
		if (objImage.getAlttext().length() != 0) {

			if (imageService.checkImageExist(objImage)) {
				imageService.updateImage(objImage);
			} else {
				
				imageService.createImage(objImage);
			}
		} else {

			session.setAttribute("sessionImageObj", objImage);
		}

		Reminder ObjReminder = reminderService.getReminder();
		ObjectMapper objMap = new ObjectMapper();
		String str = new String();
		str = objMap.writeValueAsString(ObjReminder);
		return str;
	}

	@RequestMapping(value = "/saveFieldPopUp", method = {
			RequestMethod.POST, RequestMethod.GET }, headers = "Accept=*/*", produces = "application/json")
	public @ResponseBody Object saveFieldPopUp(@RequestBody String field, HttpSession session)
			throws JsonGenerationException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		Image objImage = mapper.readValue(field, Image.class);
		
		
		
		Image objImageFromSession=(Image)session.getAttribute("sessionImageObj");
		
		objImageFromSession.setAlttext(objImage.getAlttext());
		
				
			
			if (imageService.checkImageExist(objImageFromSession)) {
				imageService.updateImage(objImageFromSession);
			} else {
				imageService.createImage(objImageFromSession);
			}

		Reminder ObjReminder = reminderService.getReminder();
		ObjectMapper objMap = new ObjectMapper();
		String str = new String();
		str = objMap.writeValueAsString(ObjReminder);
		
		return str;
		
	}

	

}
