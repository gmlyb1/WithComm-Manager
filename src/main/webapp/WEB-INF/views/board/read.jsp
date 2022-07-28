<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>

<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var formObj = $("form[name='readForm']")

		//삭제
		$("#delete_btn").on("click", function() {
			formObj.attr("action", "/board/delete");
			formObj.attr("method", "post");
			formObj.submit();

		})
		
		  // 댓글작성
		$("#reply_Write_Btn").on("click",function() {
			var formObj = $("form[name='replyForm']");
			formObj.attr("action","/replyWrite");
			formObj.attr("method","post");
			formObj.submit();
		}) 
	})
</script>




<div class="row" style="margin-bottom: 20px; margin-left: 1px;">
	<div class="col-lg-12">
		<h1 class="page-header">상세 페이지</h1>
	</div>
</div>

<div class="panel" style="margin-left: 1px;">
	<div id="contAreaBox">
		<div class="panel">
			<div class="panel-body">
				<form role="form" method="post" name="readForm"
					onsubmit="return _onSubmit();">
					<input type="hidden" id="board_no" name="board_no"
						value="${read.board_no }" />
					<div class="table-responsive" style="text-align: center;">
						<table id="datatable-scroller"
							class="table table-bordered tbl_Form">
							<caption></caption>
							<colgroup>
								<col width="250px" />
								<col width="" />
							</colgroup>
							<tbody>
								<tr>
									<th class="active">작성자</th>
									<td>${read.board_writer}</td>
								</tr>
								<tr>
									<th class="active">제목</th>
									<td>${read.board_title}</td>
								</tr>
								<tr>
									<th class="active">내용</th>
									<td>${read.board_content}</td>
								</tr>
							</tbody>
						</table>
					</div>
				<div style="margin-left: 1px;">
						<c:if test="${member != null}">
							<button type="button" class="btn btn-success"
								onclick="location.href='/board/update?board_no=${read.board_no}';">수정</button>
							<button type="submit" class="btn btn-danger" id="delete_btn">삭제</button>
						</c:if>
						<button type="button" onclick="location.href='/board/list';"
							class="btn btn-primary">목록</button>
							<br> 
						<hr>
						<!-- 댓글 -->
						<div class="mb-3" style="height: 270px;">
							<table class="table table-striped">
								<c:forEach items="${replyList}" var="replyList">
									<tr style="width: 100%;">
										<td style="font-weight: bold;" colspan="3">[${replyList.reply_writer}]</td>
									</tr>
									<tr>
										<td style="width: 60%; height: 50px;"><pre
												style="font-family: arial;">${replyList.reply_content }</pre>
										</td>
										<td style="width: 35%; text-align: right;">
										<fmt:formatDate value="${replyList.reply_regdate}" pattern="yy-MM-dd HH:mm" /></td>
								</c:forEach>
							</table>
						
						</div>
					</div>
					
						<!-- 댓글끝 -->
						<c:if test="${member != null}">	
						<br>	<hr> 
						<!-- 댓글작성 -->
						<form name="replyForm" method="post">
							<input type="hidden" id="reply.board_no" name="reply.board_no" value="${reply.board_no}"/>
						
							<div>
							
								<label for="reply_writer">댓글 작성자:</label><input type="text" id="reply_writer" name="reply_writer" value="${member.me_name}" disabled/>
								<br/>
								<label for="reply_content">댓글 내용:</label><input type="text" id="reply_content" name="reply_content"/>
							
							</div>
							<div>
								<button type="submit" class="btn btn-success" id="reply_Write_Btn">작성</button>
							</div>
							
						</form>
						</c:if>
						<!-- 댓글작성 끝-->
						
					</div>
				</form>
			</div>
		</div>
	</div>
</div>



<%@include file="../includes/footer.jsp"%>