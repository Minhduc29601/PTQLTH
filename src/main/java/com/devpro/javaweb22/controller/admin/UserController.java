package com.devpro.javaweb22.controller.admin;

import com.devpro.javaweb22.controller.BaseController;
import com.devpro.javaweb22.model.BaseEntity;
import com.devpro.javaweb22.model.Role;
import com.devpro.javaweb22.model.User;
import com.devpro.javaweb22.services.RoleService;
import com.devpro.javaweb22.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController extends BaseController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @RequestMapping(value = { "/admin/user/list" }, method = RequestMethod.GET)
    public String adminProductList(final Model model, final HttpServletRequest request,
                                   final HttpServletResponse response) throws IOException {
        List<User> users = userService.findAll();

        model.addAttribute("users", users);

        return "administrator/users_list";

    }

    @RequestMapping(value = { "/admin/user/management" }, method = RequestMethod.GET)
    public String adminProductAdd(final Model model,
                                  final HttpServletRequest request,
                                  final HttpServletResponse response) throws IOException {
        // khởi tạo 1 product(entity) mới
        User newUser = new User();
        model.addAttribute("user", newUser); // đẩy data xuống view

        // trả về view
        return "administrator/user_management";
    }

    @RequestMapping(value = { "/admin/user/management" }, method = RequestMethod.POST)
    public String adminProductAddOrUpdate(final Model model,
                                          final HttpServletRequest request,
                                          final HttpServletResponse response,
                                          @ModelAttribute("user") User user) throws Exception {
        Role role = roleService.getById(2);
        user.addRoles(role);
        user.setPassword(new BCryptPasswordEncoder(4).encode(user.getPassword()));
        userService.saveOrUpdate(user);

        // trở về trang danh sách sản phẩm
        return "redirect:/admin/user/list";
    }
}
