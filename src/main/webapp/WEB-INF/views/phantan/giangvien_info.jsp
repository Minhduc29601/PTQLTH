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

            <h1 class="mt-4">Thông tin cá nhân</h1>
            <p>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Tài khoản</label>
                <div class="col-sm-10">
                    <input type="text" path="username" id="username"  class="form-control-plaintext" value="${userLogined.username }" placeholder="Username" readonly="true">
                </div>
                <label class="col-sm-2 col-form-label">Họ Tên</label>
                <div class="col-sm-10">
                    <input type="text" path="ho_ten" id="ho_ten"  class="form-control-plaintext" value="${userLogined.ho_ten }" placeholder="Username" readonly="true">
                </div>
                <label class="col-sm-2 col-form-label">Năm sinh</label>
                <div class="col-sm-10">
                    <input type="text" path="nam_sinh" id="nam_sinh" class="form-control-plaintext" value="${userLogined.nam_sinh }" placeholder="Username" readonly="true">
                </div>
                <label class="col-sm-2 col-form-label">Quê quán</label>
                <div class="col-sm-10">
                    <input type="text" path="que_quan" id="que_quan" class="form-control-plaintext" value="${userLogined.que_quan }" placeholder="Username" readonly="true">
                </div>
                <label class="col-sm-2 col-form-label">Tên khoa</label>
                <div class="col-sm-10">
                    <input type="text" path="khoa" id="khoa" class="form-control-plaintext" value="${userLogined.khoa.ten_khoa }" placeholder="Username" readonly="true">
                </div>
                <label class="col-sm-2 col-form-label">Khu vực</label>
                <div class="col-sm-10">
                    <input type="text" path="khu_vuc" id="khu_vuc" class="form-control-plaintext" value="${userLogined.khuVuc.ten_khu_vuc }" placeholder="Username" readonly="true">
                </div>
            </div>
            </p>

        </div>
    </div>
</div>

<!-- JS -->
<jsp:include page="/WEB-INF/views/administrator/layout/js.jsp"></jsp:include>


</body>
</html>
