<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                <div class="mr-1 ml-1">
                   <%-- 시큐리티에서 principal 정보 pInfo 변수에 담기 --%>
                   <sec:authorize access="isAuthenticated()">
                      <sec:authentication property="principal" var="pInfo" />
                      <c:if test="${pInfo.username eq board.writer}">
                         <button class="btn btn-warning" data-service="modify">Modify</button>
                      </c:if>
                   </sec:authorize>
                   
                   <button class="btn btn-info" data-service="list" >List</button>
                </div>
                
                <form id="btnForm" action="/board/modify" method="get">
                   <input type="hidden" name="bno" value="${board.bno}" id="bno" />
                   <input type="hidden" name="pageNum" value="${cri.pageNum}"  />
                   <input type="hidden" name="listQty" value="${cri.listQty}"  />
                   <input type="hidden" name="sel" value="${cri.sel}"  />
                   <input type="hidden" name="keyword" value="${cri.keyword}"  />
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
                    
                    <%-- 로그인했을때만 댓글 작성 가능하게 --%>
                    <sec:authorize access="isAuthenticated()">
                    <hr />
                    <div class="reply_inputbox form-group">
                         <div class="rbox_div"><textarea class="form-control" rows="3" name="reply" id="reply" placeholder="댓글작성.."></textarea></div>
                         <div class="rbox_div"><input type="text" class="form-control" name="replyer" id="replyer" value='<sec:authentication property="principal.username" />' readonly="readonly"/></div>
                         <div class="rbox_div"><button id="saveReplyBtn" type="button" class="btn btn-success">Save Reply</button></div>
                    </div>
                    </sec:authorize>
                    
                </div>
            </div>
        </div> <!-- end 댓글card -->
        
        
        <script type="text/javascript">
			$(document).ready(function(){
				let bnoVal  = "${board.bno}";
				console.log("bnoVal"+bnoVal);
				showReplyList();
				
				
				function showReplyList(){
					console.log("showList 가 실행되었다");
					$.ajax({
						type : "POST",
						url : "/reply/list"+bnoVal+".json",
						data: {bno:bnoVal},
						success : function(result){
							console.log("요청성공");
						},
						error : function(e){
							console("요청실패!!");
						}
					});
				}//showReplyList()
			
				
				let username="${pInfo.username}";
				let replyContainer =${".reply_container"};
				// 댓글 목록 만들어서 화면에 부착해줄 함수
				
				
				
				function makeList(result){
					console.log("makeList!!!"+result.lenth);
					if(result == null || result.length ==0){
						// 댓글 목록에 아래와 같이 태그 부착하고
						replyContainer.html("<div class='reply_li'>댓글이 없습니다.</div>");
						return;
					}
					//댓글이 있으니까 뿌려주는곳
					let str= "";
					for(let i = 0 ;i<result.length ;i++){
						str+= "<div class='reply_li'><div class='replyer_reg_ctn'>";
						str +=  "<div class='replyer_div'>"+result[i].replyer+"</div>";
						str +=  "<div class='replyReg_div'>"+timeFormat(result[i].reg)+"</div></div>";
						str +=  "<div><div class='reply_div'>"+result[i].reply+"</div>";
						//로그인된 상황에서 보여줘야 , 댓글 단 사람이 로그인한 id 와 같으면 보여주기
						str +="<sec:authorize access='isAuthenticated()'>";
						if(username ==result[i].replyer){ // 댓글 작성자가 로그인한 사람과 동일하면 
							str += 	"<button class='btn btn-info replyBtn' data-rno='"+result[i].repno+"' data-service='modify'>수정</button>";								
							str +=	"<button class='btn btn-warning replyBtn' data-rno='"+result[i].repno+"' data-service='delete'>삭제</button>";
						}
							str +="</sec:authorize></div></div>";
						} 
							replyContainer.html(str); 	//html 부착 
				
					}//makeList
			
		
					//댓글 저장버튼 이벤트 등록
					$("#saveReplyBtn").on("click",function(e){
						console.log("save 버튼 클릭했써");
						let replyVal= $("#reply").val();
						let replyerVal = $("#replyer").val();
						
						let reqData = {reply : replyVal, replyer : replyerVal, bno : bnoVal};
						cons7ole.log(reqData);
						
						$.ajax({
							type : "POST",
							url : "/reply/add",
							data: JSON.stringify(reqData),
							contentType: "application/json;charset=utf-8",
							beforeSend : function(xhr){
								xhr.setRequestHeader(header,token);
								
							};
							success : function(){
								console.log("요청성공");
								console.log(result);
								showReplyList();
								$("#reply").val("");
								
							},
							error : function(e){
								console.log("요청에러!!!");
								console.log(e);
							}
						});//ajax
					});// saveBtn
		
		
		
		
		
		
		
		
						
						
						
						
					}
				
			});
		</script>
        
        
        
        
      <!-- footer 복붙 -->        
   <%@ include file="../includes/footer.jsp" %>  
        
        