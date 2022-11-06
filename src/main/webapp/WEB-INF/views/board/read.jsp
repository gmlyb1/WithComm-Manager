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
		});
	})
</script>

<script type="text/javascript">
	$(document).ready(function() {
		var formObj = $("form[name='replyForm']")
		$(".replyWriteBtn").on("click", function() {
			var formObj = $("form[name='replyForm']");
			formObj.attr("action", "/board/WriteReply");
			formObj.attr("method", "post");
			formObj.submit();
		});
	})
</script>


<div class="row" style="margin-bottom: 20px; margin-left: 1px;">
	<c:if test="${member == null}">
		<span style="color: red" class="text-center"><strong>
				현재 페이지의 글쓰기,수정,삭제는 회원만 이용 가능합니다.</strong></span>
	</c:if>

	<c:if test="${member != null}">
		<span style="color: blue" class="text-center"><strong>
				댓글작성은 관리자만 가능합니다.</strong></span>
	</c:if>
	<div class="col-lg-12">
		<h1 class="page-header text-center">상세 페이지</h1>
	</div>
</div>

<div class="panel" style="margin-left: 1px;">
	<div id="contAreaBox">
		<div class="panel">
			<div class="panel-body">
				<form role="form" method="post" name="readForm">
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
								<hr>
								<div class="mb-3">
									<label class="form-label">작성자</label>
									<p class="h6">${read.board_writer}</p>
								</div>
								<hr>
								<div class="mb-3">
									<label class="form-label">제목</label>
									<p class="h6">${read.board_title}</p>
								</div>
								<hr>
								<div class="mb-3">
									<label class="form-label">내용</label>
									<textarea class="form-control" rows="10"
										style="resize: none; background-color: white;" readonly>${read.board_content}</textarea>
								</div>
								<hr>
							</tbody>
						</table>
					</div>
					<div style="margin-left: 1px;">
						<c:if test="${member.me_name == read.board_writer}">
							<button type="button" class="btn btn-success"
								onclick="location.href='/board/update?board_no=${read.board_no}';">수정</button>
							<button type="submit" class="btn btn-danger" id="delete_btn">삭제</button>
						</c:if>
						<button type="button" onclick="location.href='/board/list';"
							class="btn btn-primary">목록</button>
						<br>
						<hr>
					</div>
				</form>
				<!-- 게시판 끝 -->

				<!-- 댓글 시작 -->

				<div class="mb-3" style="height: 270px; OVERFLOW-Y: auto;">
					<table class="table table-striped">
						<c:choose>
							<c:when test="${replyList == null}">
								<tr>
									<td style="text-align: center">등록된 댓글이 없습니다</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${replyList}" var="replyList">
									<tr style="width: 100%;">
										<td style="font-weight: bold;" colspan="3">${replyList.reply_writer}</td>
									</tr>
									<tr>
										<td style="width: 60%; height: 50px;"><pre
												style="font-family: arial;">${replyList.reply_content}</pre>
											<p>
												<a class="btn btn-primary" href="">수정</a> /
												 <a class="btn btn-danger" href="">삭제</a>
											</p></td>
										<td style="width: 35%; text-align: right;"><fmt:formatDate
												value="${replyList.reply_regdate}" pattern="yy-MM-dd HH:mm" /></td>
										<td style="width: 5%;">&nbsp;</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</table>
				</div>
				<!-- 댓글 끝 -->


				<!-- 댓글 작성 시작 -->
				<c:if test="${member.me_grade == '최고관리자' }">
					<div>
						<form method="post" action="/reply/write">
							<p>
								<label>댓글 작성자:</label> <input type="text" name="reply_writer"
									value="${member.me_name}[${member.me_grade}]" readonly>
							</p>
							<p>
								댓글 내용:
								<textarea class="form-control" rows="3" cols="155"
									placeholder="댓글을 남겨주세요." name="reply_content"></textarea>
							</p>


							<p>
								<input type="hidden" name="reply.board_no"
									value="${read.board_no}">
								<button type="submit" class="btn btn-success"
									style="margin: 55px 0 0 10px;">댓글 작성</button>
							</p>
						</form>
					</div>
				</c:if>
				<!-- 댓글 작성 끝 -->
			</div>
		</div>
	</div>
</div>



<%@include file="../includes/footer.jsp"%>