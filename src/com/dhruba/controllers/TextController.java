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
import com.dhruba.text.TextContent;
import com.dhruba.text.TextContentService;


@Controller
@Scope("session")
public class TextController {
	@Autowired
	TextContentService textService;

	@RequestMapping("/createtextcontentform")
	public String getContentPage(Model model) {
		model.addAttribute("textcontent", new TextContent());
		return "form_createtextcontent";
	}

	@RequestMapping("/createtextcontent")
	public String createTextContent(Model model, @Valid TextContent textcontent, BindingResult result,
			ModelMap modelMap, HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("textcontent", textcontent);
			modelMap.put(BindingResult.class.getName() + ".textcontent", result);
			return "form_createtextcontent";

		} else {

			if (textService.getTextContentForDivision(textcontent))
				textService.createTextContent(textcontent);
			else
				textService.updateTextContent(textcontent);

		}
		return "redirect:createtextcontentform";
	}

}
