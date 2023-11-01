<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- SPRING FORM -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<html lang="en">
<head>

  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>Quản lý trường học</title>

  <!-- Favicon-->
  <!-- <link rel="icon" type="image/x-icon" href="assets/favicon.ico" /> -->

  <!-- COMMON -->
  <jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>

  <!-- Core theme CSS (includes Bootstrap)-->
  <jsp:include page="/WEB-INF/views/administrator/layout/css.jsp"></jsp:include>

</head>
<body>
<div class="d-flex" id="wrapper">

  <!-- Sidebar-->
  <jsp:include page="/WEB-INF/views/administrator/layout/header.jsp"></jsp:include>

  <!-- Page content wrapper-->
  <div id="page-content-wrapper">

    <!-- Top navigation-->
    <jsp:include page="/WEB-INF/views/administrator/layout/menu.jsp"></jsp:include>

    <!-- Page content-->
    <div class="container-fluid">

      <form action="${base }/admin/subject/score" method="get">



        <!-- danh sách sản phẩm -->
        <table class="table table-striped">
          <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Mã sinh viên</th>
            <th scope="col">Tên sinh viên</th>
            <th scope="col">Tên môn học</th>
            <th scope="col">Điểm số</th>
            <th scope="col">Hành động</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${diems}" var="diem" varStatus="loop">
            <tr>
              <th scope="row" width="5%">
                  ${loop.index + 1}
              </th>
              <td>
                  ${diem.sinhVien.masv }
              </td>
              <td>
                  ${diem.sinhVien.ho_ten }
              </td>
              <td>
                  ${diem.monHoc.maVaTenMonHoc }
              </td>
              <td>
                  ${diem.diem_so }
              </td>
              <td width="15%">
                <div>
                  <a class="btn btn-success" href="${base }/admin/subject/score/update/${diem.id}" role="button" >Chấm điểm</a>
                </div>
              </td>

            </tr>
          </c:forEach>
          </tbody>
        </table>

      </form>

    </div>
  </div>
</div>

<!-- JS -->
<jsp:include page="/WEB-INF/views/administrator/layout/js.jsp"></jsp:include>

</body>
</html>
