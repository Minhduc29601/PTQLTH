package com.devpro.javaweb22.controller.admin;

import com.devpro.javaweb22.controller.BaseController;
import com.devpro.javaweb22.model.*;
import com.devpro.javaweb22.services.ScoreService;
import com.devpro.javaweb22.services.StudentService;
import com.devpro.javaweb22.services.SubjectService;
import com.devpro.javaweb22.services.UserService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ScoreController extends BaseController {
    @Autowired
    ScoreService scoreService;
    @Autowired
    StudentService studentService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    UserService userService;
    @ModelAttribute("subjects")
    public List<MonHoc> getSubject() {
        SinhVien currentStudent = studentService.getEntityByNativeSQL("select * from tbl_users where id = " + getUserLogined().getId());
        List<MonHoc> monHocs = subjectService.getEntitiesByNativeSQL("select * from mon_hoc where khoa_id = " + currentStudent.getKhoa().getId() );
        return monHocs;
    }

    @ModelAttribute("students")
    public List<SinhVien> getStudents() {
        List<SinhVien> sinhViens = studentService.getEntitiesByNativeSQL("select * from tbl_users");
        return sinhViens;
    }


    @ModelAttribute("studentbymon")
    public List<Diem> getListDiemByMonHoc(Integer id) {
        SinhVien currentStudent = studentService.getEntityByNativeSQL("select * from tbl_users where id = " + getUserLogined().getId());
        List<Diem> diemList = scoreService.getEntitiesByNativeSQL("select * from diem where mon_hoc_id = "+id);
        return diemList;
    }
    @RequestMapping(value = { "/admin/subject/register" }, method = RequestMethod.GET)
    public String FormDangKyMonHoc(final Model model,
                                  final HttpServletRequest request,
                                  final HttpServletResponse response) throws IOException {
        // khởi tạo 1 product(entity) mới
        Diem diem = new Diem();
//        List<SinhVien> students = getAllStudents();
        model.addAttribute("diem", diem); // đẩy data xuống view
//        model.addAttribute("students",students);
        // trả về view
        return "diem/diem_sinhvien_management";
    }

    @RequestMapping(value = { "/admin/subject/register" }, method = RequestMethod.POST)
    public String PostDangKyMonHoc(final Model model,
                                          final HttpServletRequest request,
                                          final HttpServletResponse response,
                                          @ModelAttribute("diem") Diem diem) throws Exception {

        Diem existDiem = scoreService.getEntityByNativeSQL("select * from diem where mon_hoc_id = " + diem.getMonHoc().getId() + " and sinh_vien_id = " + getUserLogined().getId());
        if (existDiem != null) {
            model.addAttribute("error", true); // đẩy data xuống view
            return "diem/diem_sinhvien_management";
        }
        SinhVien currentStudent = studentService.getEntityByNativeSQL("select * from tbl_users where id = " + getUserLogined().getId());
        diem.setSinhVien(currentStudent);
        diem.setDiem_so(null);
        scoreService.saveOrUpdate(diem);

        // trở về trang danh sách sản phẩm
        return "redirect:/admin/student/info";
    }

    @RequestMapping(value = { "/admin/score/export" }, method = RequestMethod.GET)
    public void exportDiem(final Model model,
                                   final HttpServletRequest request,
                                   final HttpServletResponse response) throws Exception {

        List<Diem> scores = new ArrayList<Diem>();
        scores = this.scoreService.getEntitiesByNativeSQL("select * from diem where sinh_vien_id = " + getUserLogined().getId());
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=diem_" + System.currentTimeMillis() + ".xlsx";
        response.setHeader(headerKey, headerValue);

        String[] HEADERs = { "Mã môn học", "Tên môn học", "Điểm" };

        try {
            // Tạo workbook và sheet
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Scores");

            // CSS header
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // Tạo header
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
                cell.setCellStyle(headerStyle);
            }

            // Input data
            int rowIdx = 1;
                for (Diem d : scores) {
                    Row row = sheet.createRow(rowIdx);
                    row.createCell(0).setCellValue(d.getMonHoc().getMa_mon_hoc());
                    row.createCell(1).setCellValue(d.getMonHoc().getTen_mon_hoc());
                    row.createCell(2).setCellValue(d.getDiem_so());
                    rowIdx++;
                }

            ServletOutputStream outputStream = response.getOutputStream();
            workbook.write(outputStream);
            workbook.close();

            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("Fail to export excel file: " + e.getMessage());
        }
    }

//    @RequestMapping(value = { "/admin/subject/register" }, method = RequestMethod.GET)
//    public String FormChamDiem1(final Model model,
//                                   final HttpServletRequest request,
//                                   final HttpServletResponse response) throws IOException {
//        List<MonHoc> subjects = subjectService.getEntitiesByNativeSQL("select * from mon_hoc");
//
//        model.addAttribute("subjects", subjects);
//
//        return "monhoc/monhoc_list";
//    }

    @RequestMapping(value = { "/admin/subject/score/{id}" }, method = RequestMethod.GET)
    public String FormDSsinhvien(final Model model,
                                final HttpServletRequest request,
                                final HttpServletResponse response,
                                @PathVariable("id") int id) throws IOException {
        Diem diem = new Diem();
        List<Diem> diems = getListDiemByMonHoc(id);
        model.addAttribute("diems", diems); // đẩy data xuống view
        return "diem/chamdiem_ds_sinhvien";
    }

    @RequestMapping(value = { "/admin/subject/score/update/{id}" }, method = RequestMethod.GET)
    public String FormGVChamDiem(final Model model,
                                 final HttpServletRequest request,
                                 final HttpServletResponse response,
                                 @PathVariable("id") int id) throws IOException {
        Diem diem = scoreService.getById(id);
        model.addAttribute("diem", diem); // đẩy data xuống view
        return "diem/chamdiem_management";
    }

    @RequestMapping(value = { "/admin/subject/score/update" }, method = RequestMethod.POST)
    public String adminLecturerUpdate(final Model model,
                                      final HttpServletRequest request,
                                      final HttpServletResponse response,
                                      @ModelAttribute("diem") Diem diem) throws Exception {

        Diem diemNew = scoreService.getById(diem.getId());
        diemNew.setSinhVien(diemNew.getSinhVien());
        diemNew.setMonHoc(diemNew.getMonHoc());
        diemNew.setDiem_so(diem.getDiem_so());
        try{
            scoreService.saveOrUpdate(diemNew);
        } catch (Exception e){
            model.addAttribute("error", true);
            return "diem/chamdiem_management";
        }

        // trở về trang danh sách sản phẩm
        return "redirect:/admin/subject/list";
    }

}
