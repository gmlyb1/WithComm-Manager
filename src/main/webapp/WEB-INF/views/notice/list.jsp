<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	
	// new 스티커 처리
	var currentTime = new Date().getTime();
	
	$("table tr").each(function() {
		var regdate = new Date($(this).data("regdate")).getTime();
		var isNewPost = (currentTime - regdate < 24 * 60 * 60 * 1000);
		
		if(isNewPost) {
			$(this).find("td:eq(1)").append('<span class="badge badge-success">New</span>');
			
			setTimeout(function() {
				$sticker.find(".badge").remove();
			},24 * 60 * 60 * 1000);
		}
	});
</script>
<style type="text/css">
  .btn-right {
    float: right;
  }
</style>
<%@include file="../includes/header.jsp"%>

<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800">공지사항</h1>
	<p class="mb-4">
		<a><strong>이곳은 공지사항입니다. 관리자 외에는 글을 조회만 가능합니다.</strong></a>
	</p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">공지사항 리스트</h6>
			<br>
				<span style="color: red"><strong> 현재 페이지의 글쓰기,수정,삭제는 회원만 이용 가능합니다.</strong></span>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
					<thead>
						<tr>
							<th class="text-center">번호</th>
							<th class="text-center">주제</th>
							<th class="text-center">작성자</th>
							<th class="text-center">조회수</th>
							<th class="text-center">작성일자</th>
							<th class="text-center">수정일자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${FixedList}" var="FixedList">
							<tr style="background: LightGray">
								<td class="text-center"><c:out value="" /><strong>[공지]</strong></td>
								<td><strong><a
										href="/notice/read?notice_no=${FixedList.notice_no}"><c:out
												value="${FixedList.notice_title}" /></a></strong></td>
								<td class="text-center"><strong><c:out
											value="${FixedList.notice_writer}" /></strong></td>
								<td class="text-center"><strong><c:out
											value="${FixedList.notice_count}" /></strong></td>
								<td class="text-center"><strong><fmt:formatDate pattern="yyyy-MM-dd hh:mm"
											value="${FixedList.notice_regdate}" /></strong></td>
								<td class="text-center"><strong><fmt:formatDate pattern="yyyy-MM-dd hh:mm"
											value="${FixedList.notice_updateDate}" /></strong></td>
							</tr>
						</c:forEach>
						<c:forEach items="${noticeList}" var="list">
							<tr data-regdate = "${list.notice_regdate}">
								<td class="text-center"><c:out value="${list.notice_no}" /></td>
								<td><a href="/notice/read?notice_no=${list.notice_no}">
								<c:out value="${list.notice_title}" /></a></td>
								<td class="text-center"><c:out value="${list.notice_writer}" /></td>
								<td class="text-center"><c:out value="${list.notice_count}" /></td>
								<td class="text-center"><fmt:formatDate pattern="yyyy-MM-dd hh:mm"
										value="${list.notice_regdate}" /></td>
								<td class="text-center"><fmt:formatDate pattern="yyyy-MM-dd hh:mm"
										value="${list.notice_updateDate}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<c:if test="${member.adminCk == 1}">
					<button type="button" onclick="location.href='/notice/create';"
						class="btn btn-success btn-right">글쓰기</button>
				</c:if>
				
			</div>
		</div>
	</div>
</div>
<%@include file="../includes/footer.jsp"%>
