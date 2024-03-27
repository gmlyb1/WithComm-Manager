<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/includes/header.jsp"%>

<br>
<div class="conatiner-fluid content-inner mt-n5 py-0">
   <div class="row">
      <div class="col-xl-9 col-lg-8">
         <div class="card">
            <div class="card-header d-flex justify-content-between">
               <div class="header-title">
                  <h4 class="card-title">content</h4>
               </div>    
            </div>
            <div class="card-body">
               	<div class="mb-3">
	                <label for="exampleInputEmail1" class="form-label">받는사람</label>
	                <p class="h6">&nbsp; ${recName} [${recevReadDetail.mail_id }]</p>
           		</div>
				<div class="mb-3">
	                <label for="exampleInputEmail1" class="form-label">보낸사람</label>
	                <p class="h6">&nbsp; ${sendName} [${recevReadDetail.mail_email }]</p>
           		</div>
           		<div class="mb-3">
	                <label for="exampleInputEmail1" class="form-label">제목</label>
	                <p class="h6">&nbsp; ${recevReadDetail.mail_title }</p>
           		</div>
           		<div class="mb-3">
                   	<label class="form-label" for="disabledCustomFile">첨부파일</label>
                   	<c:choose>
                   		<c:when test="${recReadDetail.mail_file != null }">
                   			<a href="filedown?fileName=${recevReadDetail.mail_file }"><p>&nbsp; ${recevReadDetail.mail_file }</p></a>
                   		</c:when>
                   		<c:otherwise>
                   			<p class="h6">&nbsp; 첨부파일이 없습니다.</p>
                   		</c:otherwise>
                   	</c:choose>
               	</div>
               	<div class="mb-3">
                   	<label class="form-label" for="disabledCustomFile">내용</label>
                   	<textarea class="form-control" rows="10" id="mails_content" name="mail_content" style="resize: none; background-color:white;" " readonly>${recevReadDetail.mail_content }</textarea>
               	</div>
               	<div style="text-align:right;">
               		<button type="button" class="btn btn-primary btn-sm" onclick="location.href='recevMail'">취소</button>
               	</div>

            </div>
         </div>
      </div>
   </div>
</div>

<%@include file="/WEB-INF/views/includes/footer.jsp"%>