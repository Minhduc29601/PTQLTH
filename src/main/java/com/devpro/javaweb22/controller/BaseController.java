package com.devpro.javaweb22.controller;

import java.util.List;


import com.devpro.javaweb22.model.*;
import com.devpro.javaweb22.services.FacultyService;
import com.devpro.javaweb22.services.LocationService;
import com.devpro.javaweb22.services.RoleService;
import com.devpro.javaweb22.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;



import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;

public abstract class BaseController {
	@Autowired
	RoleService roleService;

	@Autowired
	LocationService locationService;

	@Autowired
	FacultyService facultyService;

	@Autowired
	StudentService studentService;
	@ModelAttribute("roles")
	public List<Role> getAllRoles() {
		return roleService.findAll();
	}

	@ModelAttribute("locations")
	public List<KhuVuc> getAllLocations() {
		return locationService.findAll();
	}

	@ModelAttribute("faculties")
	public List<Khoa> getAllFaculties() {
		return facultyService.findAll();
	}


	@ModelAttribute("userLogined")
	public User getUserLogined() {
		Object userLogined = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(userLogined instanceof UserDetails)

			return (User) userLogined;

		return new User();
	}
}
