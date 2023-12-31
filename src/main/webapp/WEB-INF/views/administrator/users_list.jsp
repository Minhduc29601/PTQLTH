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
        <title>Simple Sidebar - Start Bootstrap Template</title>
        
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
                    
                    <form action="${base }/admin/user/list" method="get">
						
						<!-- tìm kiếm sản phẩm trên danh sách -->
						<div class="d-flex flex-row justify-content-between mt-4">
							<div>
								<a class="btn btn-outline-primary mb-1" href="${base }/admin/user/management/" role="button">
									Add New
								</a>
							</div>
						</div>
						
						<!-- danh sách sản phẩm -->
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">Tài khoản</th>
									<th scope="col">Họ và tên</th>
									<th scope="col">Năm sinh</th>
									<th scope="col">Quê quán</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${users}" var="user" varStatus="loop">
									<tr>
										<th scope="row" width="5%">
											${loop.index + 1}
										</th>
										<td>
												${user.username }
										</td>
										<td>
											    ${user.ho_ten }
										</td>
										<td>
												${user.nam_sinh }
										</td>
										<td>
												${user.que_quan }
										</td>

										<td width="15%">
											<div>
												<a class="btn btn-primary" href="${base }/admin/user/management/${user.id}" role="button">Edit</a>
<%--												<a class="btn btn-danger" role="button" onclick="DeleteProduct(${user.id});">Delete</a>--%>
											</div>
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
