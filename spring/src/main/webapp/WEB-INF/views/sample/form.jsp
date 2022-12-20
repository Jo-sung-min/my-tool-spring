<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>form page</h1>
	<form action="/test/pro" method="post">
	id:	<input type="text" name="id"/> <br/>
	pw:	<input type="password" name="pw"/> <br/>
		<input type="submit" name="로그인"/> <br/>
	
	</form>

	<h3>${sampleTv.power }</h3>
	<h3>${sampleTv.ch }</h3>
	<h3>${sampleTv.col }</h3>

</body>
</html>