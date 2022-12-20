<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2> pro page </h2>
	<h3> ${id}</h3>
	<h3> ${pw}</h3>
	
	<h3> id:${reqId}</h3>
	<h3> pw:${reqPw}</h3>
	
	<h3> dtoId:${dto.id}</h3>
	<h3> dtoPw:${dto.pw}</h3>
	<h3> ${dto}</h3>
	
	
	<h3> dtoId:${dto.getId()}</h3>
	<h3> dtoPw:${dto.getPw()}</h3>


	

	<h3> sampleDTO(중요 자바Beans규약 이름을 따로 지정안하고 
	변수 따로 보내주는게 아니면 변수 이름 앞자 소문자로 바꿔서 보내줌) 
	 : ${sampleDTO }</h3>
	 
	<h3> sampleDTO(중요) : ${sampleDTO.id }</h3>
	<h3> sampleDTO(중요) : ${sampleDTO.pw }</h3>


</body>
</html>