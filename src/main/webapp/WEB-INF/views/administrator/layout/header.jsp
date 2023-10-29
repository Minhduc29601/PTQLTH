<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="border-end bg-white" id="sidebar-wrapper">
	<div class="sidebar-heading border-bottom bg-light">Start Bootstrap</div>
	<div class="list-group list-group-flush">
		<c:if test="${userLogined.roles[0].name == 'ADMIN'}">
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="${base }/admin/lecturer/list">Danh sách giảng viên</a>
		</c:if>
		<c:if test="${userLogined.roles[0].name == 'ADMIN' || userLogined.roles[0].name == 'LECTURER' }">
			<a class="list-group-item list-group-item-action list-group-item-light p-3" href="${base }/admin/student/list">Danh sách sinh viên</a>
		</c:if>
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Danh sách môn học</a>
	</div>
</div>