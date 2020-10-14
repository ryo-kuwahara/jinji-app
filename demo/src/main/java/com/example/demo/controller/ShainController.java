package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.ShainForm;
import com.example.demo.service.ShainService;

@Controller
public class ShainController {
	
	@Autowired
	private final ShainService shainService;
	
	public ShainController(ShainService shainService) {
		this.shainService = shainService;
	}

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
			return "index";
		}
	
		String number = shainForm.getNumber();
		String name = shainService.findByNo(number);
		model.addAttribute("name", name);
		model.addAttribute("number", number);
		return "output";
	}

}