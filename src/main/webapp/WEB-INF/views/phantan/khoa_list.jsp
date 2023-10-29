<%--
  Created by IntelliJ IDEA.
  User: TUAN ANH
  Date: 10/29/2023
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
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
    <title>Danh sách khoa</title>

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

            <form action="${base }/admin/faculty/list" method="get">

                <!-- tìm kiếm sản phẩm trên danh sách -->
                <div class="d-flex flex-row justify-content-between mt-4">

                </div>

                <!-- danh sách sản phẩm -->
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Mã khoa</th>
                        <th scope="col">Tên khoa</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${faculty}" var="falculty" varStatus="loop">
                        <tr>
                            <th scope="row" width="5%">
                                    ${loop.index + 1}
                            </th>
                            <td>
                                    ${falculty.ma_khoa }
                            </td>
                            <td>
                                    ${falculty.ten_khoa }
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
