package com.horse.sys.role.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.horse.common.web.BaseController;
import com.horse.sys.role.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {
	@Resource
	private RoleService roleService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/role/list");
		return mv;
	}
	
	/**
	 * 
	 * @param roleCode 用户编码
	 * @param roleName 用户名
	 * @param pageSize 每页多少行
	 * @param currentPage 第几页
	 * @return json字符串
	 */
	@RequestMapping(value="/getRoleList",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	public String getroleList(@RequestParam("roleCode") String roleCode,
			@RequestParam("roleName") String roleName,
			@RequestParam(value = "pageSize",required=false,defaultValue="10") int pageSize,
			@RequestParam(value = "currentPage",required=false,defaultValue="1") int currentPage) {
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("roleCode", roleCode);
		parameterMap.put("roleName", roleName);
		return roleService.queryForPage(parameterMap,pageSize,currentPage);
	}
}