package com.dhruba.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dhruba.page.Page;
import com.dhruba.page.PageService;
import com.dhruba.reminder.Reminder;
import com.dhruba.user.User;

@Controller
@Scope("session")
public class PageController {

	@Autowired
	PageService service;
	@Autowired
	private User user;
	@Autowired
	private Reminder reminder;

	@RequestMapping("/createpageform")
	public String getCreatePage(Model model) {
		model.addAttribute("page", new Page());
		return "form_createpage";
	}

	@RequestMapping(value="/createpage", method = { RequestMethod.POST} )
	public String createPage(Model model, @Valid Page page, BindingResult result, ModelMap modelMap, HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("page", page);
			modelMap.put(BindingResult.class.getName() + ".page", result);

		} else {
			user=(User)session.getAttribute("user");
			reminder=(Reminder)session.getAttribute("reminder");
			
			page.setReminder(reminder);
			page.setUser(user);

			if (service.createPage(page)){
				page=service.getPageDetailByName(page);
				session.setAttribute("page", page);
				return "redirect:/callcontent";
			}
		}
		return "form_createpage";
	}
	
	/*@RequestMapping("/content")
	public String getContentPage(Model model, HttpSession session ) {
		//get page object from session
		Page pageFromSession=(Page)session.getAttribute("page");
		model.addAttribute("page", pageFromSession);
		return "content";
	}*/

}
