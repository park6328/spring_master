<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> ${msg} </h1>
	
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			
			<td>순번</td>
			<td>ID</td>
			<td>PWD</td>
			<td>NAME</td>
			<td>삭제여부</td>
		</tr>
		<c:forEach items="${memberList}" var="dto" varStatus="status">
			<tr>
				<td>${status.index}</td>
				<td><a href="content_view?id=${dto.id}">${dto.id}</a></td>
				<td>${dto.pwd}</td>
				<td>${dto.name}</td>
				<td><a href="delete?id=${dto.id}">삭제</a></td>
			</tr>
		</c:forEach>
	
	</table>
	<a href="insertMember">회원 등록하기</a>
	
</body>
</html>

<script>
	window.onload = function() {
    	var msg = '${msg}'
		if(msg != ''){
			alert(msg);
				
		}
		
		
		
	}

</script>
