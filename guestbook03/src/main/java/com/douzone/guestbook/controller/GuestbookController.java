package com.douzone.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.douzone.guestbook.Repository.GuestbookRepository;
import com.douzone.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {

	@Autowired
	private GuestbookRepository guestbookRepository;
	
	
	@RequestMapping("")
	public String index(Model model) {
		
		List<GuestbookVo> list = guestbookRepository.findAll();
		model.addAttribute("list",list);
		return "index";
	}
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public String add(GuestbookVo vo) {
		
		guestbookRepository.insert(vo);
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/delete/{n}",method = RequestMethod.GET)
	public String delete(@PathVariable("n") Long no,Model model) {
		model.addAttribute("n",no);
		
		return "delete";
	}
	
	@RequestMapping(value="/delete/{n}",method = RequestMethod.POST)
	public String delete(@PathVariable("n")Long no,@RequestParam(value="password", required=true, defaultValue ="")String password,Model model) {
		
		
		boolean result = guestbookRepository.delete(no, password);
		
		
		
		if(result) {
			return "redirect:/";
		}else {
			model.addAttribute("result","false");
			model.addAttribute("n",no);
			return "delete";
		}
		
		
	}
	
}
