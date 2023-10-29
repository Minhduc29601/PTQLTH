package com.devpro.javaweb22.controller.admin;

import com.devpro.javaweb22.controller.BaseController;
import com.devpro.javaweb22.model.GiangVien;
import com.devpro.javaweb22.model.MonHoc;
import com.devpro.javaweb22.model.Role;
import com.devpro.javaweb22.model.User;
import com.devpro.javaweb22.services.LecturerService;
import com.devpro.javaweb22.services.RoleService;
import com.devpro.javaweb22.services.SubjectService;
import com.devpro.javaweb22.services.UserService;
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
import java.util.ArrayList;
import java.util.List;

@Controller
public class SubjectController extends BaseController {
    @Autowired
    SubjectService subjectService;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @RequestMapping(value = { "/admin/subject/list" }, method = RequestMethod.GET)
    public String adminSubjectList(final Model model, final HttpServletRequest request,
                                   final HttpServletResponse response) throws IOException {
        List<MonHoc> subjects = subjectService.getEntitiesByNativeSQL("select * from mon_hoc");

        model.addAttribute("subjects", subjects);

        return "monhoc/monhoc_list";

    }

    @RequestMapping(value = { "/admin/subject/management" }, method = RequestMethod.GET)
    public String adminSubjectAdd(final Model model,
                                  final HttpServletRequest request,
                                  final HttpServletResponse response) throws IOException {
        // khởi tạo 1 product(entity) mới
        MonHoc subject = new MonHoc();
        model.addAttribute("subject", subject); // đẩy data xuống view

        // trả về view
        return "monhoc/monhoc_management";
    }

    @RequestMapping(value = { "/admin/subject/management" }, method = RequestMethod.POST)
    public String adminSubjectAdd(final Model model,
                                   final HttpServletRequest request,
                                   final HttpServletResponse response,
                                   @ModelAttribute("subject") MonHoc subject) throws Exception {
//
//        Role role = roleService.getById(3);
//        lecturer.addRoles(role);
//        lecturer.setPassword(new BCryptPasswordEncoder(4).encode(lecturer.getPassword()));
        subjectService.saveOrUpdate(subject);

        // trở về trang danh sách sản phẩm
        return "redirect:/admin/subject/list";
    }

    @RequestMapping(value = { "/admin/subject/management/{id}" }, method = RequestMethod.GET)
    public String adminSubjectDetail(final Model model,
                                      final HttpServletRequest request,
                                      final HttpServletResponse response,
                                      @PathVariable("id") int id) throws IOException {

        // lấy product trong db theo ProductId
        MonHoc monhoc = subjectService.getById(id);
        model.addAttribute("subject", monhoc);

        return "monhoc/monhoc_update";

    }


    @RequestMapping(value = { "/admin/subject/update" }, method = RequestMethod.POST)
    public String adminSubjectUpdate(final Model model,
                                      final HttpServletRequest request,
                                      final HttpServletResponse response,
                                      @ModelAttribute("subject") MonHoc subject) throws Exception {

//        MonHoc existLecturer = lecturerService.getEntityByNativeSQL("select * from tbl_users where id = " + lecturer.getId());
//
//        existLecturer.setHo_ten(lecturer.getHo_ten());
//        existLecturer.setQue_quan(lecturer.getQue_quan());
//        existLecturer.setNam_sinh(lecturer.getNam_sinh());
//        MonHoc monhoc = subjectService.getById(id);
        subjectService.saveOrUpdate(subject);
        // trở về trang danh sách sản phẩm
        return "redirect:/admin/subject/list";
    }

    @RequestMapping(value = { "/admin/subject/delete/{id}" }, method = RequestMethod.GET)
    public String adminSubjectDeleteGET(final Model model,
                                         final HttpServletRequest request,
                                         final HttpServletResponse response,
                                         @PathVariable("id") int id) throws Exception {
        MonHoc subject = subjectService.getById(id);
        model.addAttribute("subject", subject);
        // trở về trang danh sách sản phẩm
        return "monhoc/monhoc_delete";
    }

    @RequestMapping(value = { "/admin/subject/delete/{id}" }, method = RequestMethod.POST)
    public String adminSubjectDelete(final Model model,
                                      final HttpServletRequest request,
                                      final HttpServletResponse response,
                                      @PathVariable("id") int id) throws Exception {
        MonHoc existSubject = subjectService.getEntityByNativeSQL("select * from mon_hoc where id = " + id);

        existSubject.setStatus(false);
        subjectService.saveOrUpdate(existSubject);

        // trở về trang danh sách sản phẩm
        return "redirect:/admin/subject/list";
    }


}
