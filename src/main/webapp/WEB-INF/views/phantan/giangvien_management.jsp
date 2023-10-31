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

      <h1 class="mt-4">Thêm giảng viên</h1>
      <p>
        <sf:form modelAttribute="lecturer" action="${base}/admin/lecturer/management" method="post" enctype="multipart/form-data">
          <c:if test="${error}">
            <div class="alert alert-danger" role="alert">
              Username hoặc mã giảng viên đã tồn tại
          </div>
          </c:if>
          <c:if test="${lecturer.id != null}">
            <div class="form-group mb-2">
              <label for="id">Lecturer Id</label>
              <sf:input path="id" id="id" class="form-control"></sf:input>
            </div>
          </c:if>

      <div class="input-form">
        <sf:input type="text" path="username" id="username" class="form-control" placeholder="Username"></sf:input>
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
      <div class="form-group mb-2">
        <label for="khuvuc">Category (required)</label>
        <sf:select path="locations.id" class="form-control" id="khuvuc">
          <sf:options items="${locations }" itemValue="id" itemLabel="ten_khu_vuc" />
        </sf:select>
      </div>
      <div class="form-group mb-2">
        <label for="khoa">Category (required)</label>
        <sf:select path="faculties.id" class="form-control" id="khoa">
          <sf:options items="${faculties }" itemValue="id" itemLabel="ten_khoa" />
        </sf:select>
      </div>
      <div class="input-form">
        <sf:input type="text" path="magv" id="magv" class="form-control" placeholder="Mã giảng viên"></sf:input>
      </div>
      <a href="/admin/lecturer/list" class="btn btn-secondary active" role="button" aria-pressed="true">Back to list</a>
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
