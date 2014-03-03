package com.horse.sys.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

 

@Controller
public class IndexController {
	/**
	 * 首页。
	 * 
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView getIndexPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}
}
