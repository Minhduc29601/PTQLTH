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

            <h1 class="mt-4">Nhập điểm</h1>
            <p>
                <sf:form modelAttribute="diem" action="${base }/admin/subject/score/update" method="post" enctype="multipart/form-data">
                    <div class="form-group mb-2">
                        <label for="id">Id</label>
                        <sf:input path="id" id="id" class="form-control" readonly="true"></sf:input>
                    </div>
                    <div class="input-form">
                        <label for="id">Mã sinh viên</label>
                        <sf:input type="text" path="sinhVien.masv" class="form-control" readonly="true" ></sf:input>
                    </div>
                    <div class="input-form">
                        <label for="id">Tên sinh viên</label>
                        <sf:input type="text" path="sinhVien.ho_ten" class="form-control"  readonly="true"></sf:input>
                    </div>
                    <div class="input-form">
                        <label for="id">Điểm số</label>
                        <sf:input type="text" path="diem_so" class="form-control" ></sf:input>
                    </div>
                    <a href="/admin/student/info" class="btn btn-secondary active" role="button" aria-pressed="true">Hủy</a>
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
