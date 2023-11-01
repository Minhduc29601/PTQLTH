package com.devpro.javaweb22.controller.admin;

import com.devpro.javaweb22.controller.BaseController;
import com.devpro.javaweb22.model.GiangVien;
import com.devpro.javaweb22.model.Role;
import com.devpro.javaweb22.model.SinhVien;
import com.devpro.javaweb22.model.User;
import com.devpro.javaweb22.services.RoleService;
import com.devpro.javaweb22.services.StudentService;
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
import java.util.List;

@Controller
public class StudentController extends BaseController {
    @Autowired
    UserService userService;
    @Autowired
    StudentService studentService;
    @Autowired
    RoleService roleService;
    @RequestMapping(value = { "/admin/student/list" }, method = RequestMethod.GET)
    public String adminProductList(final Model model, final HttpServletRequest request,
                                   final HttpServletResponse response) throws IOException {
        List<User> students = userService.getEntitiesByNativeSQL("select * from tbl_users where dtype = 'sinh_vien' and status = 1");

        model.addAttribute("students", students);

        return "phantan/sinhvien_list";

    }

    @RequestMapping(value = { "/admin/student/management" }, method = RequestMethod.GET)
    public String adminStudentAdd(final Model model,
                                  final HttpServletRequest request,
                                  final HttpServletResponse response) throws IOException {
        // khởi tạo 1 product(entity) mới
        SinhVien lecturer = new SinhVien();
        model.addAttribute("student", lecturer); // đẩy data xuống view

        // trả về view
        return "phantan/sinhvien_management";
    }

    @RequestMapping(value = { "/admin/student/management" }, method = RequestMethod.POST)
    public String adminProductAddOrUpdate(final Model model,
                                          final HttpServletRequest request,
                                          final HttpServletResponse response,
                                          @ModelAttribute("student") SinhVien student) throws Exception {
        SinhVien existCodeStudent = studentService.getEntityByNativeSQL("select * from tbl_users where masv = '" + student.getMasv() + "'");
        SinhVien existUsernameStudent = studentService.getEntityByNativeSQL("select * from tbl_users where username = '" + student.getUsername() + "'");
        if (existCodeStudent != null || existUsernameStudent != null || student.getUsername().trim().equalsIgnoreCase("admin")) {
            model.addAttribute("student", student); // đẩy data xuống view
            model.addAttribute("error", true); // đẩy data xuống view
            // trả về view
            return "phantan/sinhvien_management";
        }

        Role role = roleService.getById(2);
        student.addRoles(role);
        student.setPassword(new BCryptPasswordEncoder(4).encode(student.getPassword()));
        studentService.saveOrUpdate(student);

        // trở về trang danh sách sản phẩm
        return "redirect:/admin/student/list";
    }

    @RequestMapping(value = { "/admin/student/management/{id}" }, method = RequestMethod.GET)
    public String adminStudentDetail(final Model model,
                                      final HttpServletRequest request,
                                      final HttpServletResponse response,
                                      @PathVariable("id") int id) throws IOException {

        // lấy product trong db theo ProductId
        SinhVien user = studentService.getById(id);
        model.addAttribute("student", user);

        return "phantan/sinhvien_update";

    }


    @RequestMapping(value = { "/admin/student/update" }, method = RequestMethod.POST)
    public String adminStudentUpdate(final Model model,
                                      final HttpServletRequest request,
                                      final HttpServletResponse response,
                                      @ModelAttribute("student") SinhVien student) throws Exception {

        SinhVien existStudent = studentService.getEntityByNativeSQL("select * from tbl_users where id = " + student.getId());

        existStudent.setHo_ten(student.getHo_ten());
        existStudent.setQue_quan(student.getQue_quan());
        existStudent.setNam_sinh(student.getNam_sinh());
        existStudent.setLocations(student.getLocations());
        existStudent.setFaculties(student.getFaculties());

        studentService.saveOrUpdate(existStudent);
        // trở về trang danh sách sản phẩm
        return "redirect:/admin/student/list";
    }

    @RequestMapping(value = { "/admin/student/delete/{id}" }, method = RequestMethod.GET)
    public String adminStudentDeleteGET(final Model model,
                                         final HttpServletRequest request,
                                         final HttpServletResponse response,
                                         @PathVariable("id") int id) throws Exception {
        SinhVien user = studentService.getById(id);
        model.addAttribute("student", user);
        // trở về trang danh sách sản phẩm
        return "phantan/sinhvien_delete";
    }

    @RequestMapping(value = { "/admin/student/delete/{id}" }, method = RequestMethod.POST)
    public String adminLecturerDelete(final Model model,
                                      final HttpServletRequest request,
                                      final HttpServletResponse response,
                                      @PathVariable("id") int id) throws Exception {
        SinhVien existLecturer = studentService.getEntityByNativeSQL("select * from tbl_users where id = " + id);

        existLecturer.setStatus(false);
        studentService.saveOrUpdate(existLecturer);

        // trở về trang danh sách sản phẩm
        return "redirect:/admin/student/list";
    }
}