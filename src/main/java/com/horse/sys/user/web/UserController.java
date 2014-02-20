package com.horse.sys.user.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.horse.sys.user.model.User;
import com.horse.sys.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/user/list");
		return mv;
	}
	
	@RequestMapping("/getUserList")
	public List<User> getUserList() {
		return userService.getUserForPage();
	}
}
