package com.devpro.javaweb22.controller.admin;

import com.devpro.javaweb22.controller.BaseController;
import com.devpro.javaweb22.model.GiangVien;
import com.devpro.javaweb22.model.Khoa;
import com.devpro.javaweb22.model.Role;
import com.devpro.javaweb22.model.User;
import com.devpro.javaweb22.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class FacultyController extends BaseController {
    @Autowired
    FacultyService facultyService;

    @RequestMapping(value = { "/admin/faculty/list" }, method = RequestMethod.GET)
    public String adminProductList(final Model model, final HttpServletRequest request,
                                   final HttpServletResponse response) throws IOException {
        List<Khoa> faculties = facultyService.findAll();

        model.addAttribute("faculty", faculties);

        return "phantan/khoa_list";

    }
}
