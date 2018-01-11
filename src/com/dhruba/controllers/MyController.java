package com.dhruba.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dhruba.image.AdminImage;
import com.dhruba.image.Image;
import com.dhruba.image.ImageService;
import com.dhruba.page.Page;
import com.dhruba.page.PageService;
import com.dhruba.reminder.Reminder;
import com.dhruba.text.TextContent;
import com.dhruba.text.TextContentService;
import com.dhruba.user.User;

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
	
	

	@RequestMapping("/")
	public String getUserLogin(Model model) {
		model.addAttribute("userlogin", new User());
		return "userlogin";
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
	public String callContentPageFirstTime(Model model, HttpSession session){
		//get user name and save it as page name in db
				user=(User)session.getAttribute("user");
				reminder=(Reminder)session.getAttribute("reminder");
				page.setReminder(reminder);
				page.setUser(user);
				page.setPagename(user.getUsername());
				if (service.createPage(page)){
					page=service.getPageDetailByName(page);
					
					session.setAttribute("page", page);
				}else{
					page=service.getPageDetailByName(page);
					
					session.setAttribute("page", page);
				}
				return "redirect:/callcontent";
		}

	@RequestMapping(value = "/callcontent")
	public String callContentPage(Model model, HttpSession session) {

		Page page = (Page) session.getAttribute("page");
		java.util.List<Image> lstImageContent = imageService.getImageContentList(page);
		User user = (User)session.getAttribute("user");
		List<TextContent> lstTextContent = textService.getTextContentList(user);
		model.addAttribute("textlst", lstTextContent);
		model.addAttribute("imagelst", lstImageContent);
		model.addAttribute("contentCount", lstTextContent.size());
		return "content";
		
	}
	
	@RequestMapping(value = "/callgallery")
	public String callImageGallery(Model model) {
		List<AdminImage>imagelst=imageService.getImageList();
		model.addAttribute("imagelst", imagelst);
		return "imagegallery";
	}

	

}
