<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%-- <script src="${pageContext.request.contextPath }/resources/js/ezform_js/noti_event.js"></script> --%>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var formObj = $("form[name='readForm']")
		
		//삭제
		$("#delete_btn").on("click", function() {
			if(!confirm("삭제 하시겠습니까?")) return false;
			formObj.attr("action", "/notice/delete");
			formObj.attr("method", "post");
			formObj.submit();
		});
	})
</script>

<script type="text/javascript">
	$(document).ready(function() {
		var formObj = $("form[name='replyForm']")
		$(".replyWriteBtn").on("click", function() {
			var formObj = $("form[name='replyForm']");
			formObj.attr("action", "/notice/WriteReply");
			formObj.attr("method", "post");
			formObj.submit();
		});
	})
</script>
<script type="text/javascript">
	function fn_fileDown(fileNo){
		var formObj = $("form[name='readForm']");
		$("#FILE_NO").attr("value",fileNo);
		formObj.attr("action","/notice/fileDown");
		formObj.submit();
	}

</script>
<script type="text/javascript">
	function remove_replyNo(data1,data2) {
		if(!confirm("삭제 하시겠습니까?")) return false;
		else {
			location.href="/reply/delete?reply_no="+data1+"&notice_no="+data2;
		}
	}
</script>
<div class="conatiner-fluid content-inner mt-n5 py-0">
   <div class="row">
      <div class="col-sm-12">
         <div class="card">
            <div class="card-header d-flex justify-content-between">
               <div class="header-title">
                  <h4 class="card-title">공지사항</h4>
               </div>
            </div>
            <div class="card-body p-0">
               <div class="table-responsive mt-4">
               	  <form role="form" method="post" name="readForm">
               	  <input type="hidden" id="FILE_NO" name="FILE_NO" value="">
					<input type="hidden" id="notice_no" name="notice_no" value="${read.notice_no}" />
					<%-- <input type="hidden" id="reply_no" name="reply_no" value="${replyList.board_no}"> --%>
	                  <table id="basic-table" class="table table-striped mb-0" role="grid">
	                     <thead>
	                        <tr>
	                           <th>
	                              <svg width="26" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
	                                 <path d="M15.7161 16.2234H8.49609" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path>
	                                 <path d="M15.7161 12.0369H8.49609" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path>
	                                 <path d="M11.2521 7.86011H8.49707" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path>
	                                 <path fill-rule="evenodd" clip-rule="evenodd" d="M15.909 2.74976C15.909 2.74976 8.23198 2.75376 8.21998 2.75376C5.45998 2.77076 3.75098 4.58676 3.75098 7.35676V16.5528C3.75098 19.3368 5.47298 21.1598 8.25698 21.1598C8.25698 21.1598 15.933 21.1568 15.946 21.1568C18.706 21.1398 20.416 19.3228 20.416 16.5528V7.35676C20.416 4.57276 18.693 2.74976 15.909 2.74976Z" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path>
	                              </svg> Content       
	                           </th>
	                        </tr>
	                     </thead>
	                     <tbody>
	                        <tr>
	                           <th>
	                              <div class="mb-3">
	                                <label class="form-label">제목</label>
									<p class="h6">${read.notice_title}</p>
								  </div>	
	                              <div class="mb-3">
	                                 <label class="form-label">내용</label>
	                                 <textarea class="form-control" rows="10" style="resize: none; background-color:white;" readonly>${read.notice_title}</textarea>
	                              </div>
	                           </th>
	                        </tr>   
	                        <tr>
	                           <td style="text-align:right;">
	                              <div class="mb-3">
	                           	  	<c:choose>
	                           	  	
										<c:when test="${member.state == '관리자' }">
											<button type="button" class="btn btn-success btn-sm" onclick="location.href='/notice/update?notice_no=${read.notice_no}';">수정</button>
											<button type="submit" class="btn btn-danger btn-sm" id="delete_btn">삭제</button>
										</c:when>
								 	</c:choose>
								 	<a href="/notice/list" class="btn btn-primary btn-sm">목록으로</a>
	                              </div>
	                           </td>  
	                        </tr>
	                     </tbody>
	                  </table>
                  </form>
                  
                 <!-- 이전글 / 다음글 -->
				<div class="my-3 p-3 bg-white rounded shadow-sm">
					<c:choose>
						<c:when test="${nextNoticeList.notice_no != null}">

							<button type="button" class="btn btn-warning mr-3 mb-3"
								onclick="location.href='/notice/read?notice_no=${nextNoticeList.notice_no}'">
								<span class="glyphicon glyphicon-menu-up" aria-hidden="true"></span>다음글
							</button>
							<a href="/notice/read?notice_no=${nextNoticeList.notice_no}" style="color: black">
								${nextNoticeList.notice_title} </a>
						</c:when>

						<c:when test="${nextNoticeList.notice_no == null}">
							<button type="button" class="btn btn-warning mr-3 mb-3" disabled>다음글이
								없습니다</button>
						</c:when>
					</c:choose>
					<br />
					<c:choose>
						<c:when test="${lastNoticeList.notice_no != null}">
							<button type="button" class="btn btn-info mr-3 "
								onclick="location.href='/notice/read?notice_no=${lastNoticeList.notice_no}'">
								<span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span>이전글
							</button>
							<a href="/notice/read?notice_no=${lastNoticeList.notice_no}" style="color: black">
								${lastNoticeList.notice_title} </a>
						</c:when>

						<c:when test="${lastNoticeList.notice_no == null}">
							<button type="button" class="btn btn-info mr-3" disabled>이전글이
								없습니다</button>
						</c:when>
					</c:choose>

				</div>
                  
               </div>
            </div>
         </div>
      </div>
   </div>
</div>


<%@include file="../includes/footer.jsp"%>