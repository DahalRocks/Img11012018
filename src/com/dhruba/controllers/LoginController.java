package com.dhruba.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.dhruba.reminder.Reminder;
import com.dhruba.reminder.ReminderService;
import com.dhruba.user.User;

import com.dhruba.user.UserService;

@Controller
@Scope("session")
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private ReminderService reminderService;

	@Autowired
	private Reminder reminder;
	
	@Autowired
    private JavaMailSender mailSender;

	@RequestMapping("/createuserform")
	public String createUser(Model model) {
		model.addAttribute("user", new User());
		List<User> lstUser = userService.getUserList();
		model.addAttribute("userlist", lstUser);
		return "form_createuseraccount";
	}

	@RequestMapping("/createuser")
	public String saveUser(Model model, @Valid User user, BindingResult result, ModelMap modelMap) {

		if (result.hasErrors()) {
			model.addAttribute("user", user);
			List<User> lstUser = userService.getUserList();
			model.addAttribute("userlist", lstUser);
			modelMap.put(BindingResult.class.getName() + ".user", result);
			return "form_createuseraccount";
		} else {
			if (userService.exists(user)) {
				String msg = "This user already exists !!";
				model.addAttribute("message", msg);
				return "form_createuseraccount";
			} else {
				userService.saveUser(user);
				
				//send email to the participants
				
				// creates a simple e-mail object
		        SimpleMailMessage email = new SimpleMailMessage();
		        String recipientAddress=user.getEmail();
		        String subject="Upload the most suitable images to the given blog contents (Research purpose)";
		        String message="";
		        message+="Dear"+"  "+ user.getFullname() +",";
		        message+="\r\n";
		        message+="\r\n I would like to thank you for your cooperation in this work.";
		        message+="\r\n";
		        message+="\r\n Please go to the following link and use the username and password given below to get logged in.";
		        message+="\r\n";
		        message+="\r\n http://tomcat-datacollection.193b.starter-ca-central-1.openshiftapps.com";
		        message+="\r\n";
		        message+="USERNAME:"+user.getUsername();
		        message+="\r\n";
		        message+="PASSWORD:"+user.getPassword();
		        message+="\r\n";
		        message+="\r\n";
		        message+="When you get logged in, you will have a blog having 5 different contents.";
		        message+="\r\n";
		        message+="Each of the contents has an image upload button at the bottom. Click that button to get an image upload form.";
		        message+="\r\n";
		        message+="Use this form and upload an image that you think is suitable for the contents.";
		        message+="\r\n";
		        message+="\r\n";
		        message+="When you finish with image upload for all of the contents, please click \'CLICK TO FINISH\' link given at the bottom of the page.";
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
		         
		        // sends the e-mail
		        mailSender.send(email);
			}
			return "redirect:createuser";
		}
	}

	@RequestMapping("/createuserlogin")
	public String createLoginUser(Model model) {
		model.addAttribute("userlogin", new User());
		return "userlogin";
	}

	@RequestMapping("/getuserlist")
	public String getUserList(Model model) {
		List<User> lstUser = userService.getUserList();
		model.addAttribute("userlist", lstUser);
		return "form_createuseraccount";
	}

	@RequestMapping(value = "/updatereminder", method = { RequestMethod.GET,
			RequestMethod.POST }, headers = "Accept=*/*", produces = "application/json")
	public @ResponseBody Object updateReminder(@RequestBody String reminderData)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		User userObj = mapper.readValue(reminderData, User.class);

		boolean result = userService.updateUserReminder(userObj);

		ObjectMapper objMap = new ObjectMapper();
		String str = new String();
		str = objMap.writeValueAsString(result);
		return str;

	}

	@RequestMapping("/loginuser")
	public String loginUser(Model model, @Valid User user, BindingResult result, ModelMap modelMap,
			HttpSession session) {

		String msg = "";
		if (result.hasErrors()) {
			model.addAttribute("userlogin", user);
			modelMap.put(BindingResult.class.getName() + ".userlogin", result);
			return "userlogin";
		} else {
			if (userService.login(user)) {
				user = userService.getUserDetailByName(user);
				session.setAttribute("user", user);
				reminder = reminderService.getReminder();
				session.setAttribute("reminder", reminder);
				return "redirect:callcontentfirsttime";
			} else {
				msg = "User Name or Password is Incorrect!!";
			}
			model.addAttribute("message", msg);
			model.addAttribute("userlogin", user);

			return "userlogin";
		}
	}

	@RequestMapping("/welcome")
	public String getWelcomePage(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		model.addAttribute("user", user);
		return "welcome";
	}

}
