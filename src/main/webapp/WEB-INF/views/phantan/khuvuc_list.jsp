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

            <form action="${base }/admin/location/list" method="get">

                <!-- danh sách sản phẩm -->
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Mã khu vực</th>
                        <th scope="col">Tên khu vực</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${locations}" var="location" varStatus="loop">
                        <tr>
                            <th scope="row" width="5%">
                                    ${loop.index + 1}
                            </th>
                            <td>
                                    ${location.ma_khu_vuc }
                            </td>
                            <td>
                                    ${location.ten_khu_vuc }
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
