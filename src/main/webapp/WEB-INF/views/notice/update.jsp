<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@include file="../includes/header.jsp"%>
<%@ page import="java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>   
<%-- <script src="${pageContext.request.contextPath }/resources/js/ezform_js/noti_event.js"></script> --%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

		$(".cancel_btn").on("click", function() {
			event.preventDefault();
			location.href = "/board/list";
		});

	function _onSubmit() {
		if (!confirm("수정 하시겠습니까?")) {
			return false;
		}
	}
	
	function YnCheck(obj) {
		var checked = obj.checked;
		if(checked) {
			obj.value = 1;
		}else {
			obj.value = 2;
		}
		
		var isFixed = "${data.isFixed}";
		if(isFixed == 1) {
		    $("#isFixed").prop("checked", true);
		} else {
		    $("#isFixed").prop("checked", false);
		}
		
		// 체크박스 value값 설정
		if($("#isFixed").is(':checked')==true) {
			data.set("isFixed",1);
		}else {
			data.set("isFixed",0);
		}
	};
});
</script>
<hr>
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
               	  <form action="/notice/update" role="form" method="post" name="updateForm" onsubmit="return _onSubmit();">
					<input type="hidden" name="notice_no" value="${update.notice_no}" readonly="readonly" />
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
	                                <label class="form-label">작성자</label>
									<input class="form-control form-control-sm" id="notice_writer" name="notice_writer" value="${update.notice_writer}" readonly>
								  </div>	
	                              <div class="mb-3">
	                                <label class="form-label">제목</label>
									<input class="form-control form-control-sm" id="notice_title" name="notice_title" value="${update.notice_title}">
								  </div>	
	                              <div class="mb-3">
	                                 <label class="form-label">내용</label>
	                                 <textarea class="form-control" rows="10" id="notice_content" name="notice_content" style="resize: none;">${update.notice_content}</textarea>
	                              </div>
	                           </th>
	                        </tr>   
	                        <tr>
								 <td>
									<input type="checkbox" id="isFixed" name="isFixed" onchange="YnCheck(this);"><label for="isFixed">상단 고정</label>								
								</td> 
							</tr>
	                        <tr>
	                           <td style="text-align:right;">
	                              <div class="mb-3">
									<button type="submit" class="btn btn-success">수정</button>
									<a href="/notice/list" class="btn btn-danger">취소</a>
								</div>
	                           </td>  
	                        </tr>
	                     </tbody>
	                  </table>
                  </form>
               </div>
            </div>
         </div>
      </div>
   </div>
</div>

<%@include file="../includes/footer.jsp"%>