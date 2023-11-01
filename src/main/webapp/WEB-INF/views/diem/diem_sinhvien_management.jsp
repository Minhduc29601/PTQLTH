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

      <h1 class="mt-4">Đăng ký môn học</h1>
      <c:if test="${error}">
        <div class="alert alert-danger" role="alert">
          Sinh viên đã đăng ký môn học này
        </div>
      </c:if>
      <label>Sinh viên đăng ký</label>
      <input type="text" path="ho_ten" id="ho_ten" class="form-control" value="${userLogined.ho_ten }" placeholder="Username" readonly="true">
      <p>
        <sf:form modelAttribute="diem" action="${base}/admin/subject/register" method="post" enctype="multipart/form-data">
          <div class="form-group mb-2">
            <label for="subject">Chọn môn muốn đăng ký</label>
            <sf:select path="subjects.id" class="form-control" id="subject">
              <sf:options items="${subjects }" itemValue="id" itemLabel="maVaTenMonHoc" />
            </sf:select>
          </div>
      <a href="/admin/student/info" class="btn btn-secondary active" role="button" aria-pressed="true">Hủy đăng ký</a>
      <button type="submit" class="btn btn-primary">Lưu</button>
      </sf:form>

      </p>

    </div>
  </div>
</div>

<!-- JS -->
<jsp:include page="/WEB-INF/views/administrator/layout/js.jsp"></jsp:include>


</body>
</html>
