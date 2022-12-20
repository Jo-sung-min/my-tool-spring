<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
	<!-- header 복붙 -->
	<%@ include file="../includes/header.jsp" %>

		<!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Board Modify</h1><br />
       
        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Board Modify Page</h6>
            </div>
            <div class="card-body">
            	<form id="modifyForm" action="/board/modify" method="post">
	                <div class="mr-3 ml-3 mb-4">
	                    <div class="form-group row">
	                    	<label>Bno</label>
	                        <input type="text" class="form-control" name="bno" value="${board.bno}" readonly="readonly"/>
	                    </div>
	                    <div class="form-group row">
	                    	<label>Title</label>
	                        <input type="text" class="form-control" name="title" value="${board.title}" />
	                    </div>
	                    <div class="form-group row">
	                    	<label>Content</label>
	                    	<textarea class="form-control" rows="3" name="content" >${board.content}</textarea>
	                    </div>
	                    <div class="form-group row">
	                    	<label>Writer</label>
	                        <input type="text" class="form-control" name="writer" value="${board.writer}" readonly="readonly"/>
	                    </div>
	                    <div class="form-group row">
	                    	<label>Reg Date</label>
	                        <input type="text" class="form-control" name="reg" value='<fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${board.reg}"/>' readonly="readonly"/>
	                    </div>
	                </div>
	                <div class="mr-1 ml-1">
	                	<button type="submit" data-service="modify" class="btn btn-warning">Save</button>
	                	<button type="submit" data-service="delete" class="btn btn-danger">Delete</button>
	                	<button type="submit" data-service="list" class="btn btn-info" >List</button>
	                </div>
	                <!-- 이동시 들고갈 pageNum listQty 히든으로 추가  -->
	                <input type="hidden" name="pageNum" value="${cri.pageNum}" />
	                <input type="hidden" name="listQty" value="${cri.listQty}" />
	                <input type="hidden" name="sel" value="${cri.sel}" />
	                <input type="hidden" name="keyword" value="${cri.keyword}" />
                </form>
                
            </div>
        </div>
        <!--  content 내용물 끝나는 부분  -->
        
        <!-- 버튼에 따른 이벤트 처리 스크립트 추가  -->
        <script type="text/javascript">
        $(document).ready(function(){
			let formObj = $("#modifyForm");	// form 태그 가져오기 
			$("button").on("click", function(e){
				e.preventDefault(); 	// 기본 동작 취소 (submit의 이동기능 취소)
				//console.log(e);
				let service = $(this).data("service"); 
				//console.log(service);
				if(service == 'delete'){
					formObj.attr("action", "/board/delete"); 
				}else if(service == 'list'){
					//formObj.attr("action", "/board/list");
					//self.location = "/board/list";
					//return;
					
					// 폼태그의 action과 method 속성을 변경 
					formObj.attr("action", "/board/list").attr("method", "get");
					// list로 이동할때는 폼태그안에 있는 데이터 전부 보낼필요가 없으니 
					// pageNum과 listQty 히든태그를 복사해놓고 
					// 내용물 전부 삭제하고 
					// 복사해둔 pageNum, listQty 태그만 다시 추가해서 
					// 이동시킴 (form submit날려서 이동)
					let pageNumTag = $("input[name='pageNum']").clone(); 
					let listQtyTag = $("input[name='listQty']").clone(); 
					let selTag = $("input[name='sel']").clone(); 
					let keywordTag = $("input[name='keyword']").clone(); 
					formObj.empty(); 
					
					formObj.append(pageNumTag);
					formObj.append(listQtyTag);
					formObj.append(selTag);
					formObj.append(keywordTag);
				}
				
				// js로 폼의 submit 버튼 누른 효과와 동일 
				formObj.submit(); 
				
			}); 
        	
        	
        	
        });
        </script>
        
        
	
	<!-- footer 복붙 -->        
	<%@ include file="../includes/footer.jsp" %>
	