package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "/hello";
	}
	
	@RequestMapping("/hello2")
	public String hello2(String name) {
		System.out.println(name);
		return "/hello2";
	}
	
	@RequestMapping("/hello3")
	public ModelAndView hello3(String name) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.setViewName("/hello3");
		
		return mav;
	}
	
	@RequestMapping("/hello4")
	public String hello4(String name, Model model) {
		model.addAttribute("name", name);
		return "/hello4";
	}
	
	
}