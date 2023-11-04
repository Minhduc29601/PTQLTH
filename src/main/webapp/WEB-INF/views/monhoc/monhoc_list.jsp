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

      <form action="${base }/admin/subject/list" method="get">



        <!-- danh sách sản phẩm -->
        <table class="table table-striped">
          <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Mã môn học</th>
            <th scope="col">Tên môn học</th>
            <th scope="col">Khoa</th>
            <c:if test="${userLogined.roles[0].name == 'LECTURER'}">
              <th scope="col">Hành động</th>
            </c:if>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${subjects}" var="subject" varStatus="loop">
            <tr>
              <th scope="row" width="5%">
                  ${loop.index + 1}
              </th>
              <td>
                  ${subject.ma_mon_hoc }
              </td>
              <td>
                  ${subject.ten_mon_hoc }
              </td>
              <td>
                  ${subject.khoa.ten_khoa }
              </td>
              <c:if test="${userLogined.roles[0].name == 'LECTURER'}">
                <td width="15%">
                  <c:if test="${userLogined.khoa.id == subject.khoa.id}">
                    <div>
                      <a class="btn btn-danger" href="${base }/admin/subject/score/${subject.id}" role="button" >Danh sách sinh viên</a>
                    </div>
                  </c:if>
                  <c:if test="${userLogined.khoa.id != subject.khoa.id}">
                    <div>
                      <a class="btn btn-secondary" href="#?" role="button" disabled="true" >Danh sách sinh viên</a>
                    </div>
                  </c:if>
                </td>
              </c:if>

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
