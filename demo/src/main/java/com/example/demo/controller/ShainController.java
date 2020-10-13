package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.ShainForm;

@Controller
public class ShainController {

@ModelAttribute
public ShainForm setUpForm() {
return new ShainForm();
}

	@RequestMapping("/")
		public String index() {
		return "index";
	}
	
	@RequestMapping("/output")
		public String result(@Validated ShainForm shainForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {	
			return "index.html";
		}
	
		String number = shainForm.getNumber();
		String name = "コントローラー太郎";
		model.addAttribute("number", number);
		model.addAttribute("name", name);
		return "output";
	}

}