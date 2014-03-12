package com.horse.sys.user.web;

 
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.horse.common.web.BaseController;
import com.horse.sys.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/user/list");
		return mv;
	}
	
	/**
	 * 
	 * @param userCode 用户编码
	 * @param userName 用户名
	 * @param pageSize 每页多少行
	 * @param currentPage 第几页
	 * @return json字符串
	 */
	@RequestMapping(value="/getUserList",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	public String getUserList(@RequestParam("userCode") String userCode,
			@RequestParam("userName") String userName,
			@RequestParam(value = "pageSize",required=false,defaultValue="10") int pageSize,
			@RequestParam(value = "currentPage",required=false,defaultValue="1") int currentPage) {
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("userCode", userCode);
		parameterMap.put("userName", userName);
		return userService.queryForPage(parameterMap, pageSize,currentPage);
	}
 
}