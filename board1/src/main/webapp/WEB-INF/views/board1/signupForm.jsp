<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		<h2>회원 가입 하는곳</h2>
		
		<!-- header 복붙 -->
	<%@ include file="../includes/header.jsp" %>

		<!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Board Write</h1><br />
       
        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Board Write Page</h6>
            </div>
            <div class="card-body">
            	<form action="/board1/signupForm" method="post">
	                <div class="mr-3 ml-3 mb-4">
	                    <div class="form-group row">
	                    	<label>Title</label>
	                        <input type="text" class="form-control" name="title" />
	                    </div>
	                    <div class="form-group row">
	                    	<label>Content</label>
	                    	<textarea class="form-control" rows="3" name="content" ></textarea>
	                    </div>
	                    <div class="form-group row">
	                    	<label>Writer</label>
	                        <input type="text" class="form-control" name="writer" />
	                    </div>
	                </div>
	                <div class="mr-1 ml-1">
	                	<button type="submit" class="btn btn-primary">Submit</button>
	                	<button type="reset" class="btn btn-warning">Reset</button>
	                	<button type="button" class="btn btn-info" >List</button>
	                </div>
                </form>
                
            </div>
        </div>
        <!--  content 내용물 끝나는 부분  -->



   	<!-- footer 복붙 -->        
	<%@ include file="../includes/footer.jsp" %>


