<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div>
		<span>
			<c:if test="${message != null}">
				${message}
			</c:if>
		</span>
	</div>

	<span><a href="<c:url value='/admin-Category-create'/>">Add Category</a></span>
	<table border = "1" style="width:1000px">
		<tr>
			<td>${tong}</td>
			<td>ID</td>
			<td>CateName</td>
			<td>Icon</td>
			<td>Action</td>
		</tr>	
	<!-- list (biến danh sách) - phan servlet trả về -->
	<c:forEach var="i" items="${list}">
		<tr>
			<td>${i.categoryID }</td>
			<td>${i.categoryName}</td>
			<td>${i.icon}</td>
			<!-- Lấy ID để đổi -->
			<td><a href="<c:url value='/admin-Category-update?id=${i.categoryID}'/>">Update</a> ||<a href="<c:url value='/admin-Category-delete?id=${i.categoryID}'/>">Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>