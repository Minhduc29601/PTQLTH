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

      <h1 class="mt-4">Add/Update Subject</h1>
      <p>
        <sf:form modelAttribute="subject" action="${base}/admin/subject/management" method="post" enctype="multipart/form-data">
          <c:if test="${subject.id != null}">
            <div class="form-group mb-2">
              <label for="id">Subject Id</label>
              <sf:input path="id" id="id" class="form-control"></sf:input>
            </div>
          </c:if>

      <div class="input-form">
        <sf:input type="text" path="ma_mon_hoc" id="ma_mon_hoc" class="form-control" placeholder="Mã môn học"></sf:input>
      </div>
      <div class="input-form">
        <sf:input type="text" path="ten_mon_hoc" id="ten_mon_hoc" class="form-control" placeholder="Tên môn học"></sf:input>
      </div>
      <div class="input-form">
        <sf:input type="text" path="khoa_id" id="khoa_id" class="form-control" placeholder="Khoa ID"></sf:input>
      </div>
      <a href="/admin/subject/list" class="btn btn-secondary active" role="button" aria-pressed="true">Back to list</a>
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
