<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- header 복붙 -->
<%@ include file="../includes/header.jsp" %>


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
                	<button class="btn btn-warning" data-service="modify">Modify</button>
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
                                <button class="btn btn-info replyBtn" data-rno="result[i].rno" data-service="modify">수정</button> 
                                <button class="btn btn-warning replyBtn" data-rno="result[i].rno" data-service="delete">삭제</button> 
                             </div>
                          </div>
                          
                   </div>
                    <sec:authorize access="isAuthenticated()"> 
	                   <hr />
	                   <div class="reply_inputbox form-group">
	                        <div class="rbox_div"><textarea class="form-control" rows="3" name="reply" id="reply" placeholder="댓글작성.."></textarea></div>
	                        <div class="rbox_div"><input type="text" class="form-control" name="replyer" id="replyer" value='<sec:authentication property="principal.username"/>'  readonly/></div>
	                        <div class="rbox_div"><button id="saveReplyBtn" type="button" class="btn btn-warning">Save Reply</button></div>
	                   </div>
                    </sec:authorize>
                </div>
            </div>
        </div> <!-- end 댓글card -->
        
        
        <script type="text/javascript">
        $(document).ready(function(){
        	
        	let bnoVal = "${board.bno}"; // 본문 글 고유번호
        	showReplyList(); // 댓글 목록 가져와서 뿌릴꺼임
        	
        	function showReplyList(){
        		console.log("show replylist! 호출");
        		//전체 댓글 가져오기 ajax로 요청하기
        		
        		// 요청보내는 ajax
        		$.ajax({
        			type	: "GET",
        			url 	: "reply/list"+bnoVal+".json", // 하면 꼭 json으로 받겠다는 의미
        			data:{bno:bnoVal}
        			success: function(result){
        				
        			makeList(result); // 이걸 만들어야한다.
        			},
        			error: function(e){
        				console.log(e);
        			}
        		});
        	}//showList
        	
        	let replyContainer = $(".reply_container"); // 댓글목록 담을 컨테이너 div
        	
        	function makeList(result){
        		//컨트롤러로 가져온 댓글이 없을때
        		if(result ==null || result.length==0){
        			//댓글 목록에 아래와 같이 태그 부착하고
        			replyContainer.html("<div class='reply_li'>댓글이 없습니다.</div>");
        			return;
        		}	
        		
        		//컨트롤러로 가져온 댓글이 있을때
				let str= "";
        		for(let i=0;i<result.length;i++){
        			str +=  "<div class='reply_li'><div class='replyer_reg_ctn'>";
					str +=  "<div class='replyer_div'>"+result[i].replyer+"</div>";
					str +=  "<div class='replyReg_div'>"+timeFormat(result[i].reg)+"</div></div>";
					str +=  "<div><div class='reply_div'>"+result[i].reply+"</div>";
					str += 	"<button class='btn btn-info replyBtn' data-rno='"+result[i].repno+"' data-service='modify'>수정</button>";								
					str +=	"<button class='btn btn-warning replyBtn' data-rno='"+result[i].repno+"' data-service='delete'>삭제</button></div></div>";
        		}
        		replyContainer.html(str); 	//html 부착
        	}//makeList 끝
        	
        	
        	//csrf 정보 meta 태그에서 가져오기
        	let token =$("meta[name='_csrf']").attr("content");
        	let header=$("meta[name='_csrf_header']").attr("content");
        	
        	
        	
        	
        	//댓글 저장 이벤트 등록 이걸로 버튼 눌렀을떄 데이터 보내줄꺼임 ******
        	$("#saveReplyBtn").on("click",function(e){
        		let replyVal =$("#reply").val(); // 텍스트 area 로 쓰였고
				let replyerVal =$("#replyer").val();//이거의 벨류는 시큐리티로 뽑았음
        		
				let reqData = {reply : replyVal,replyer :  replyerVal , bno : bnoVal};
        		
				$.ajax({
					type : "POST",
					url: "/reply/add",
					data: JSON.stringify(reqData),
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
				});
				
				
        	});//saveReplyBtn
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	//시간함수
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
        });

		</script>
        
        
        
        
        
        
        
        
        
        
        
        
        
        