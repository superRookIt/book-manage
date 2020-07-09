package com.admin.book.Controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.admin.book.Service.BService;

@Controller
public class BController {
	
	@Inject
	BService bserivce;

	@RequestMapping("/list")
	public String list(Model model) {
		
		model.addAttribute("book_list", bserivce.book_list());
		
		return "/list";
	}
	
}
