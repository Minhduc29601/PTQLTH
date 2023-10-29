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

      <h1 class="mt-4">Add/Upadte User</h1>
      <p>
        <sf:form modelAttribute="student" action="${base}/admin/student/management" method="post" enctype="multipart/form-data">
      <div class="input-form">
        <sf:input type="text" path="username" id="username" class="form-control" placeholder="Username"></sf:input>
      </div>
      <div class="input-form">
        <sf:input type="text" path="masv" id="masv" class="form-control" placeholder="Ma sinh vien"></sf:input>
      </div>
      <div class="input-form">
        <sf:input type="password" path="password" id="password" class="form-control" placeholder="Password"></sf:input>
      </div>
      <div class="input-form">
        <sf:input type="text" path="ho_ten" id="ho_ten" class="form-control" placeholder="Họ và tên"></sf:input>
      </div>
      <div class="input-form">
        <sf:input type="text" path="nam_sinh" id="nam_sinh" class="form-control" placeholder="Năm sinh"></sf:input>
      </div>
      <div class="input-form">
        <sf:input type="text" path="que_quan" id="que_quan" class="form-control" placeholder="Quê quán"></sf:input>
      </div>
      <a href="/admin/student/list" class="btn btn-secondary active" role="button" aria-pressed="true">Back to list</a>
      <button type="submit" class="btn btn-primary">Lưu sinh viên</button>
      </sf:form>

      </p>

    </div>
  </div>
</div>

<!-- JS -->
<jsp:include page="/WEB-INF/views/administrator/layout/js.jsp"></jsp:include>


</body>
</html>
