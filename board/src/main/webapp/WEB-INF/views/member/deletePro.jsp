<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/resources/css/style.css" rel="stylesheet" type="text/css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<body>
	<%--로그아웃 처리용 form태그 --%>
	<form action="/logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>

	
	<c:if test="${result != 1}">
		<script>
			alert("pw가 일치하지 않습니다.");
			history.go(-1);
		</script>
	</c:if>
	<c:if test="${result == 1}">
		<script>
			// 로그아웃처리 
			$(document).ready(function(){
				let formObj = $("form"); 				
				alert("회원이 탈퇴 되셨습니다.");
				formObj.submit(); // 로그아웃 폼태그 서브밋 실행하여 요청
			}); 
		</script>
	</c:if>
</body>
</html>