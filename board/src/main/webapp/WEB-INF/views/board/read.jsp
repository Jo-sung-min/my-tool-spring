<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!-- header 복붙 -->
	<%@ include file="../includes/header.jsp" %>

		<!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Board Read</h1><br />
       
        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Board Read Page</h6>
            </div>
            <div class="card-body">
                <div class="mr-3 ml-3 mb-4">
                    <div class="form-group row">
                    	<label>Bno</label>
                        <input type="text" class="form-control" name="bno" value="${board.bno}" readonly="readonly"/>
                    </div>
                    <div class="form-group row">
                    	<label>Title</label>
                        <input type="text" class="form-control" name="title" value="${board.title}" readonly="readonly"/>
                    </div>
                    <div class="form-group row">
                    	<label>Content</label>
                    	<textarea class="form-control" rows="3" name="content" readonly="readonly">${board.content}</textarea>
                    </div>
                    <div class="form-group row">
                    	<label>Writer</label>
                        <input type="text" class="form-control" name="writer" value="${board.writer}" readonly="readonly"/>
                    </div>
                </div>
                
               	<%--시큐리티에서 principal 정보 pInfo 변수에 담기******중요 --%>
                <div class="mr-1 ml-1">
	               	<sec:authorize access="isAuthenticated()">
	               		<sec:authentication property="principal" var="pInfo"/>
	               		<c:if test="${pInfo.username eq board.writer}">
	                		<button class="btn btn-warning" data-service="modify">Modify</button>
	                	</c:if>
	               	</sec:authorize>
                	<button class="btn btn-info" data-service="list" >List</button>
                </div>
					
				<form  id="btnForm" action="/board/modify" method="get">
					<input type="hidden" name="bno"  value="${board.bno}">
					<input type="hidden" name="pageNum"  value="${cri.pageNum}">
					<input type="hidden" name="listQty"  value="${cri.listQty}">
					<input type="hidden" name="sel"  value="${cri.sel}">
					<input type="hidden" name="keyword"  value="${cri.keyword}">
				</form>
                
            </div>
        </div>
        <!--  content 내용물 끝나는 부분  -->
	
	
	<!-- 댓글 css 약식 -->
        <style> 
           .reply_container {
              margin: 0.5rem auto; 
              display: flex;
              flex-direction: column; 
           }
           .reply_li {
              margin: 1rem 0; 
              display: flex; 
              flex-direction: column;
              width: 100%;
           }
           .replyer_reg_ctn {
              margin: 0.4rem 0; 
              display: flex; 
              flex-direction: row; 
              justify-content: space-between;
              width: 100%; 
           }
           .reply_div {
              font-size: 1rem;
              width: 100%; 
           }
           .replyer_div {
              font-weight: bold;
              font-size: 0.9rem;
           }
           .replyReg_div {
              font-size: 0.7rem; 
           }
           .reply_inputbox {
              display: flex; 
              flex-direction: column;
              font-size: 0.7rem;
              width: 100%; 
           }
           .rbox_div {
              margin: 0.2rem 0; 
                width: 100%; 
           }
        </style>
        
        <!-- 댓글 DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Reply</h6>
            </div>
            <div class="card-body">
                <div class="mr-3 ml-3 mb-4">
                   <div class="reply_container">
                         <div class="reply_li">
                            <div class="replyer_reg_ctn">
                                <div class="replyer_div">replyer </div>
                                <div class="replyReg_div">2022.08.31</div>
                             </div>
                             <div>
                                <div class="reply_div">reply : 댓글내용.......................</div>
                                
                                <sec:authorize access="isAuthenticated()">
                                	
	                                <button class="btn btn-info replyBtn" data-rno="result[i].rno" data-service="modify">수정</button> 
	                                <button class="btn btn-warning replyBtn" data-rno="result[i].rno" data-service="delete">삭제</button> 
	                                
                                </sec:authorize>
                             </div>
                          </div>
                          
                          <div class="reply_li">
                            <div class="replyer_reg_ctn">
                                <div class="replyer_div">replyer </div>
                                <div class="replyReg_div">2022.08.31</div>
                             </div>
                             <div>
                                <div class="reply_div">reply : 댓글내용.......................</div>
                             </div>
                          </div>
                          
                    </div>
                    
                    <sec:authorize access="isAuthenticated()"> 
	                   <hr />
	                   <div class="reply_inputbox form-group">
	                        <div class="rbox_div"><textarea class="form-control" rows="3" name="reply" id="reply" placeholder="댓글작성.."></textarea></div>
	                        <div class="rbox_div"><input type="text" class="form-control" name="replyer" id="replyer" value='<sec:authentication property="principal.username" />'  readonly/></div>
	                        <div class="rbox_div"><button id="saveReplyBtn" type="button" class="btn btn-warning">Save Reply</button></div>
	                   </div>
                    </sec:authorize>
                </div>
            </div>
        </div> <!-- end 댓글card -->
        
        
        
		<script type="text/javascript">	
			$(document).ready(function(){
					let bnoVal = "${board.bno}";		//본문 글 고유번호
					console.log("bno!"+bnoVal);
					
					showReplyList();// 댓글 목록 가져와 뿌리기 호출
					
					//댓글 목록 가져와 뿌려주기 함수 (페이징 처리 없이)
					function showReplyList(){
						console.log("show replylist! 호출");
						//전체 댓글 가져오기 요청
						$.ajax({
							type	: "GET",
							url	: "/reply/list/"+bnoVal+".json",// 하면 꼭 json으로받겠다,
							data:{bno:bnoVal},
							success: function(result){
								console.log("요청성공!!");
								console.log(result);  
								/*
								console.log(result[0].reply);
								console.log(result[0].replyer);
								console.log(result[0].reg);
								*/
								makeList(result);
							},
							error: function(e){
								console.log("요청실패......");
								console.log(e);
							}
						});
					}//showReplyList
					
					let username="${pInfo.username}"; // sec:authenticated 로 저장한 로그인한 사람 정보 js 로 가져오기
					let replyContainer =$(".reply_container"); // 댓글목록 담을 컨테이너 div
					//댓글목록 만들어서 화면에 부착해줄 함수
					function makeList(result){
						console.log("makeList!!!!!!!!!"+result.length);
							
						if(result ==null || result.length ==0){
							// 댓글 목록에 아래와 같이 태그 부착하고 
							replyContainer.html("<div class='reply_li'>댓글이 없습니다</div>");
							return; // makeList 함수 강제 종료!
						}
						
						//댓글이 있으니 뿌려주는곳
						let str = "";
						for(let i = 0 ; i<result.length ; i++){
							
								str +=  "<div class='reply_li'><div class='replyer_reg_ctn'>";
								str +=  "<div class='replyer_div'>"+result[i].replyer+"</div>";
								str +=  "<div class='replyReg_div'>"+timeFormat(result[i].reg)+"</div></div>";
								str +=  "<div><div class='reply_div'>"+result[i].reply+"</div>";
								
								// 로그인 된 상황에서 보여줘야 , 댓글 단 사람이 로그인한 id 와 같으면 보여주기
								str +="<sec:authorize access='isAuthenticated()'>";
									if(username ==result[i].replyer){ // 댓글 작성자가 로그인한 사람과 동일하면 
										str += 	"<button class='btn btn-info replyBtn' data-rno='"+result[i].repno+"' data-service='modify'>수정</button>";								
										str +=	"<button class='btn btn-warning replyBtn' data-rno='"+result[i].repno+"' data-service='delete'>삭제</button>";
									}
								str +="</sec:authorize></div></div>";
						} 
							replyContainer.html(str); 	//html 부착 
						
					}
					
								
					
					
					
					//시간함수 : 오늘댓글은 시간, 오늘 이전 댓글은 날짜
					function timeFormat(regVal){
			              let today = new Date(); 
			              let diff = today.getTime() - regVal; 
			              let dateObj = new Date(regVal); 
			              if(diff < (1000*60*60*24)) { // 24h 보다 작으면 
			                 let hh = dateObj.getHours(); 
			                 let mi = dateObj.getMinutes(); 
			                 let ss = dateObj.getSeconds(); 
			                 return (hh > 9 ? "" : "0") + hh + ":" 
			                    + (mi > 9 ? "" : "0") + mi + ":"
			                    + (ss > 9 ? "" : "0") + ss;
			              }else {
			                 let yy = dateObj.getFullYear(); 
			                 let mm = dateObj.getMonth() + 1; 
			                 let dd = dateObj.getDate(); 
			                 return yy + "/" + (mm > 9 ? "" : "0") + mm + "/" + (dd > 9 ? "":"0") + dd;
			              }
			           }
					
					// csrf 정보 meta 태그에서 가져요기
					let token =$("meta[name='_csrf']").attr("content");		
					let header=$("meta[name='_csrf_header']").attr("content");		
					//xhr: XMLHttpRequest : 서버와 상호작용하기 위한 객체
					// ajax 통신시 xhr 객체를 이용함
					
					
					// 댓글 저장버튼 이벤트 등록
				$("#saveReplyBtn").on("click",function(e){ 
					console.log("save 버튼 클릭했써!")
					// let replyForm =$("#replyForm");
					//console.log(replyForm)
					let replyVal =$("#reply").val();
					let replyerVal =$("#replyer").val();
					//let replyerVal =$(this); this(클릭한것에서) 라는뜻
					
					//보낼 데이터 java script 객체로 만들기
					let reqData = {reply : replyVal,replyer :  replyerVal , bno : bnoVal}
					console.log(reqData);
					
						$.ajax({
							type: 	"POST",
							url: 	"/reply/add",
							data:	 JSON.stringify(reqData),
							contentType: "application/json;charset=utf-8",
							beforeSend: function(xhr){
								xhr.setRequestHeader(header,token);
							},
							success: function(result,status,xhr){
								console.log("요청성공");
								console.log(result);
								console.log(status);
								showReplyList();
								//등록 후 인풋란에 내용 없애기
								$("#reply").val("");
								
							},
							error: function(e){
								console.log("요청에러!!!");
								console.log(e);
							}
						});//ajax
					
				});// saveReplyBtn click
		
				
				
				//댓글 수정/ 삭제 버튼 이벤트 등록
				//동적으로 생성된 버튼 요소에는 직접적으로 이벤트 등록이 안되서
				//html 문서가 미리 만들어져있는 부모태그에 이벤트 우회해서 걸기
				$(".reply_container").on("click","button.replyBtn",function(){
					console.log("수정삭제 클릭!");
					let service =$(this).data("service");
					let repno =$(this).data("rno"); 
					console.log($(this).data("service"));
					
					if(service=='modify'){
						//수정가능한 폼으로 html 변경 -> reply_li 내용을 입력가능하게 변경
						let reply_li=$(this).parent().parent();
						console.log(reply_li);
						
						 // 기존작성 내용 꺼내기 
		                 let replyer = reply_li.find("div[class='replyer_div']").html(); 
		                 let reply = reply_li.find("div[class='reply_div']").html(); 
		                 
		                 // 입력가능한 요소로 변경 
		                 let modifyBox = "<div class='reply_inputbox form-group'> Modify Reply ";
		                 modifyBox += "<div class='rbox_div'><textarea class='form-control' rows='3' name='reply' id='modifyReply'>"+reply+"</textarea></div>";
		                 modifyBox += "<div class='rbox_div'><input type='text' class='form-control' name='replyer' id='modifyReplyer' value='"+replyer+"' readonly='readonly'/></div>";
		                 modifyBox += "<div class='rbox_div'><button id='saveModify' type='button' class='btn btn-warning' data-repno='"+repno+"'>Save Modify</button></div></div>";
		                 
		                 reply_li.html(modifyBox);
						
					}else if(service=='delete'){
						//ajax로 삭제 요청
							console.log(repno);
							$.ajax({
									type: "post",
									url:"/reply/delete",
									data: {repno:repno},
									beforeSend: function(xhr){
										xhr.setRequestHeader(header,token);
									},
									success: function(result,status,xhr){
										console.log("요청성공");
										console.log(result);
										console.log(status);
										showReplyList();
										//등록 후 인풋란에 내용 없애기
										$("#reply").val("");
										
									},
									error: function(e){
										console.log("요청에러!!!");
										console.log(e);
									}
						});
					}
				});
				
				
			     //저장처리
		           $(".reply_container").on("click", "button#saveModify", function(){
		              let modifyReply = $("#modifyReply").val(); 
		              let modifyReplyer = $("#modifyReplyer").val(); 
		              let repno = $(this).data("repno"); 
		              let modifyData = {reply: modifyReply, replyer: modifyReplyer, repno: repno,bno : bnoVal};
		              $.ajax({
		                 type: "POST",
		                 url: "/reply/modify",
		                 data: JSON.stringify(modifyData),
		                 contentType: "application/json;charset=utf-8",
		                 beforeSend: function(xhr){
		                  xhr.setRequestHeader(header, token);
		               },
		                 success: function(result){
		                    console.log("수정 처리 요청 성공");
		                    console.log(result);
		                	showReplyList();
		                    // 새로고침  
		                 }, 
		                 error: function(e){
		                    console.log("수정처리 요청 실패"); 
		                    console.log(e);
		                 }
		              }); 
		              
		           });
				
				
			});// ready
			
			
			
			
			
			
			
			
			
			
			
		</script>
			
			
			
			
			
		<script type="text/javascript">
		$(document).ready(function(){
			let btnForm=$("#btnForm");
			$("button[data-service='modify']").on("click", function(){
				btnForm.attr("action","/board/modify").submit();			
			});
			
			$("button[data-service='list']").on("click", function(){
				btnForm.find("#bno").remove; //bno 히든태그 삭제
				btnForm.attr("action","/board/list").submit(); // action 속성값 list 변경 attr=속성추가
			});
			
		});
		</script>
		
	
	
	
	
	
	
	
	
	<!-- footer 복붙 -->        
	<%@ include file="../includes/footer.jsp" %>
	