<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="border-end bg-white" id="sidebar-wrapper">
  <div class="sidebar-heading border-bottom bg-light">Quản lý giảng viên</div>
  <div class="list-group list-group-flush">
    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="${base }/admin/student/list">Danh sách sinh viên</a>
    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Danh sách môn học</a>

<%--    <c:if test="${isAdminSaleOrder }">--%>
<%--      <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Đơn hàng</a>--%>
<%--    </c:if>--%>

<%--    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Profile</a>--%>
<%--    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="${base }/admin/contact">Contact</a>--%>
<%--    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="${base }/admin/saleoder">Sale oder</a>--%>
  </div>
</div>