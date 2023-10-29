package com.devpro.javaweb22.controller.admin;

import com.devpro.javaweb22.controller.BaseController;
import com.devpro.javaweb22.model.KhuVuc;
import com.devpro.javaweb22.model.User;
import com.devpro.javaweb22.services.LecturerService;
import com.devpro.javaweb22.services.LocationService;
import com.devpro.javaweb22.services.RoleService;
import com.devpro.javaweb22.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class LocationController extends BaseController {
    @Autowired
    LocationService locationService;
    @Autowired
    RoleService roleService;

    @RequestMapping(value = { "/admin/location/list" }, method = RequestMethod.GET)
    public String adminProductList(final Model model, final HttpServletRequest request,
                                   final HttpServletResponse response) throws IOException {
        List<KhuVuc> locations = locationService.findAll();

        model.addAttribute("locations", locations);

        return "phantan/khuvuc_list";
    }
}
