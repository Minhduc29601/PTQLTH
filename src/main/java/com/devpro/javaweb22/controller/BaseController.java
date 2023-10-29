package com.devpro.javaweb22.controller;

import java.util.List;


import com.devpro.javaweb22.model.Role;
import com.devpro.javaweb22.model.User;
import com.devpro.javaweb22.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;



import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;

public abstract class BaseController {
	@Autowired
	RoleService roleService;

	@ModelAttribute("roles")
	public List<Role> getAllRoles() {
		return roleService.findAll();
	}

	@ModelAttribute("userLogined")
	public User getUserLogined() {
		Object userLogined = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(userLogined instanceof UserDetails)

			return (User) userLogined;

		return new User();
	}
}
