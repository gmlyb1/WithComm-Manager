<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<%@include file="../includes/header.jsp"%>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		var msg = "${msg}";
		if (msg != "") {
			alert(msg);
		};
		
		
		$(".loading-button").click(function() {
			 var answerYn = $(this).data("answerYn");
			 var inq_no = $(this).data("inq-no");
			 
			
			if (confirm("상태를 '대기중' 으로 변경 하시겠습니까?")) {
				$.ajax({
					url : "/inquiry/updateState",
					type : "POST",
					data : {
						inq_no : inq_no,
						answerYn : "대기중"
					},
					success : function(data) {
						alert("상태를 '대기중' 으로 변경 하였습니다.");
						location.reload();
					},
					error : function(error) {
						console.log(error);
						alert("요청 처리 중 오류가 발생하였습니다."+error);
					}
				});
			}
		});
		
		$(".confirm-button").click(function() {
			 var answerYn = $(this).data("answerYn");
			 var inq_no = $(this).data("inq-no");
			if (confirm("상태를 '확인중' 으로 변경 하시겠습니까?")) {
				$.ajax({
					url : "/inquiry/updateState",
					type : "POST",
					data : {
						inq_no : inq_no,
						answerYn : "확인중"
					},
					success : function(data) {
						alert("상태를 '확인중' 으로 변경 하였습니다.");
						location.reload();
					},
					error : function(error) {
						console.log(error);
						alert("요청 처리 중 오류가 발생하였습니다."+error);
					}
				});
			}
		});
		
		$(".complete-button").click(function() {
			 var answerYn = $(this).data("answerYn");
			 var inq_no = $(this).data("inq-no");
			if (confirm("상태를 '답변완료' 로 변경 하시겠습니까?")) {
				$.ajax({
					url : "/inquiry/updateState",
					type : "POST",
					data : {
						inq_no : inq_no,
						answerYn : "답변완료"
					},
					success : function(data) {
						alert("상태를 '답변완료' 으로 변경 하였습니다.");
						location.reload();
					},
					error : function(error) {
						console.log(error);
						alert("요청 처리 중 오류가 발생하였습니다."+error);
					}
				});
			}
		});
		
		
	});
</script>

 <div class="container-fluid">
<br>
	<h1 class="h3 mb-2 text-gray-800">1:1문의</h1>
	<p class="mb-4">
		<a><strong>관리자와 1:1 문의가 가능합니다.</strong></a>
	</p>

	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">고객 게시판 리스트</h6>
			<br>
			<c:if test="${member == null}">
				<span style="color: red"><strong> 현재 페이지의 글쓰기,수정,삭제는
						<strong style="color:blue">관리자</strong>만 이용 가능합니다.</strong></span>
			</c:if>
		</div>
		<div class="card-body">
			<div class="table-responsive">
			  <form method="post" id="updateform" action="/inquiry/updateState">
			  <input type="hidden" name="inq_no" value="${list.inq_no}" />
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th class="text-center">번호</th>
							<th class="text-center">주제</th>
							<th class="text-center">작성자</th>
							<th class="text-center">작성일자</th>
							<th class="text-center">수정일자</th>
							<th class="text-center">현재상태</th>
							<th class="text-center">답변여부</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${inquiryList}" var="list">
								<tr>
									<td class="text-center"><c:out value="${list.inq_no}" /></td>
									<td><a href="/inquiry/detail?inq_no=${list.inq_no}"><c:out value="${list.inq_title}" /></a></td>
									<td class="text-center"><c:out value="${list.inq_name}" /></td>
									<td class="text-center">
									<fmt:formatDate pattern="yyyy-MM-dd" value="${list.inq_regdate}"/></td>
									<c:if test="${list.inq_updateDate != null }">
										<td class="text-center">
											<fmt:formatDate pattern="yyyy-MM-dd" value="${list.inq_updateDate}"/>
										</td>
									</c:if>
									<c:if test="${list.inq_updateDate == null }">
										<td class="text-center">-</td>
									</c:if>
									<td class="text-center"><c:out value="${list.answerYn}" /></td>
									<td class="text-center">
										<c:if test="${list.answerYn != '대기중' }">
								        	<button type="button" class="btn btn-success loading-button" data-answerYn="${list.answerYn}" data-inq-no="${list.inq_no}">대기중</button>
							        	</c:if>
							        	<c:if test="${list.answerYn != '확인중' }">
							        		<button type="button" class="btn btn-secondary confirm-button" data-answerYn="${list.answerYn}" data-inq-no="${list.inq_no}">확인중</button>
								        </c:if>
								        <c:if test="${list.answerYn != '답변완료' }">
								        	<button type="button" class="btn btn-danger complete-button" data-answerYn="${list.answerYn}" data-inq-no="${list.inq_no}">완료</button>
										</c:if>
									</td>
								</tr>
						</c:forEach>
					</tbody>
				</table>
			
				<c:if test="${member != null}">
				<br>
					<a type="button" href="/inquiry/create" class="btn btn-primary">글쓰기</a>
				</c:if>
			  </form>	
			</div>
		</div>
	</div>
</div>
<!-- End of Main Content -->
<%@include file="../includes/footer.jsp"%>
