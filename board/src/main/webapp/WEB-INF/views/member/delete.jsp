<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<br />
	<h1 align="center"> 회원 탈퇴 </h1>
	<form action="/member/delete" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<table>
			<tr>
				<td> 탈퇴를 원하시면 비밀 번호를 입력하세요. <br /> 
					<input type="password" name="pw" /> 
				</td>
			</tr>
			<tr>
				<td> 
					<input type="submit" value="탈퇴" />
					<input type="button" value="MyPage" onclick="window.location='/member/mypage'" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>