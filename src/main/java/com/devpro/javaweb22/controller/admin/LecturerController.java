package com.devpro.javaweb22.controller.admin;

import com.devpro.javaweb22.controller.BaseController;
import com.devpro.javaweb22.model.Diem;
import com.devpro.javaweb22.model.GiangVien;
import com.devpro.javaweb22.model.Role;
import com.devpro.javaweb22.model.User;
import com.devpro.javaweb22.services.LecturerService;
import com.devpro.javaweb22.services.RoleService;
import com.devpro.javaweb22.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
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
import java.util.ArrayList;
import java.util.List;

@Controller
public class LecturerController extends BaseController {
    @Autowired
    LecturerService lecturerService;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @RequestMapping(value = { "/admin/lecturer/list" }, method = RequestMethod.GET)
    public String adminProductList(final Model model, final HttpServletRequest request,
                                   final HttpServletResponse response) throws IOException {
        List<User> lecturers = userService.getEntitiesByNativeSQL("select * from tbl_users where dtype = 'giang_vien' and status = 1");

        model.addAttribute("lecturers", lecturers);

        return "phantan/giangvien_list";

    }

    @RequestMapping(value = { "/admin/lecturer/info" }, method = RequestMethod.GET)
    public String adminStudentDetailInfo(final Model model,
                                         final HttpServletRequest request,
                                         final HttpServletResponse response
    ) throws IOException {

        return "phantan/giangvien_info";

    }

    @RequestMapping(value = { "/admin/lecturer/management" }, method = RequestMethod.GET)
    public String adminProductAdd(final Model model,
                                  final HttpServletRequest request,
                                  final HttpServletResponse response) throws IOException {
        // khởi tạo 1 product(entity) mới
        GiangVien lecturer = new GiangVien();
        model.addAttribute("lecturer", lecturer); // đẩy data xuống view

        // trả về view
        return "phantan/giangvien_management";
    }

    @RequestMapping(value = { "/admin/lecturer/management" }, method = RequestMethod.POST)
    public String adminLecturerAdd(final Model model,
                                   final HttpServletRequest request,
                                   final HttpServletResponse response,
                                   @ModelAttribute("lecturer") GiangVien lecturer) throws Exception {

        GiangVien existCodeLecturer = lecturerService.getEntityByNativeSQL("select * from tbl_users where magv = '" + lecturer.getMagv() + "'");
        GiangVien existUsernameLecturer = lecturerService.getEntityByNativeSQL("select * from tbl_users where username = '" + lecturer.getUsername() + "'");
        if (existCodeLecturer != null || existUsernameLecturer != null || lecturer.getUsername().trim().equalsIgnoreCase("admin")) {
            model.addAttribute("lecturer", lecturer); // đẩy data xuống view
            model.addAttribute("error", true); // đẩy data xuống view
            // trả về view
            return "phantan/giangvien_management";
        }

        Role role = roleService.getById(3);
        lecturer.addRoles(role);
        lecturer.setPassword(new BCryptPasswordEncoder(4).encode(lecturer.getPassword()));
        try {
            lecturerService.saveOrUpdate(lecturer);
        } catch (Exception ex) {
            model.addAttribute("error", true);
            return "phantan/giangvien_management";
        }

        // trở về trang danh sách sản phẩm
        return "redirect:/admin/lecturer/list";
    }

    @RequestMapping(value = { "/admin/lecturer/management/{id}" }, method = RequestMethod.GET)
    public String adminLecturerDetail(final Model model,
                                     final HttpServletRequest request,
                                     final HttpServletResponse response,
                                     @PathVariable("id") int id) throws IOException {

        // lấy product trong db theo ProductId
        GiangVien user = lecturerService.getById(id);
        model.addAttribute("lecturer", user);

        return "phantan/giangvien_update";

    }


    @RequestMapping(value = { "/admin/lecturer/update" }, method = RequestMethod.POST)
    public String adminLecturerUpdate(final Model model,
                                  final HttpServletRequest request,
                                  final HttpServletResponse response,
                                  @ModelAttribute("lecturer") GiangVien lecturer) throws Exception {

        GiangVien existLecturer = lecturerService.getEntityByNativeSQL("select * from tbl_users where id = " + lecturer.getId());

        existLecturer.setHo_ten(lecturer.getHo_ten());
        existLecturer.setQue_quan(lecturer.getQue_quan());
        existLecturer.setNam_sinh(lecturer.getNam_sinh());
        existLecturer.setFaculties((lecturer.getFaculties()));
        lecturerService.saveOrUpdate(existLecturer);

        // trở về trang danh sách sản phẩm
        return "redirect:/admin/lecturer/list";
    }

    @RequestMapping(value = { "/admin/lecturer/delete/{id}" }, method = RequestMethod.GET)
    public String adminLecturerDeleteGET(final Model model,
                                         final HttpServletRequest request,
                                         final HttpServletResponse response,
                                         @PathVariable("id") int id) throws Exception {
        GiangVien user = lecturerService.getById(id);
        model.addAttribute("lecturer", user);
        // trở về trang danh sách sản phẩm
        return "phantan/giangvien_delete";
    }

    @RequestMapping(value = { "/admin/lecturer/delete/{id}" }, method = RequestMethod.POST)
    public String adminLecturerDelete(final Model model,
                                      final HttpServletRequest request,
                                      final HttpServletResponse response,
                                      @PathVariable("id") int id) throws Exception {
        GiangVien existLecturer = lecturerService.getEntityByNativeSQL("select * from tbl_users where id = " + id);

        existLecturer.setStatus(false);
        lecturerService.saveOrUpdate(existLecturer);

        // trở về trang danh sách sản phẩm
        return "redirect:/admin/lecturer/list";
    }


}
