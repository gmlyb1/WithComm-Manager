<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var msg = "${msg}";
		if (msg != "") {
			alert(msg);
		}
	});
</script>
<%@include file="../includes/header.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Tables</h1>
	<p class="mb-4">
		DataTables is a third party plugin that is used to generate the demo
		table below. For more information about DataTables, please visit the <a
			target="_blank" href="https://datatables.net">official DataTables
			documentation</a>.
	</p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
			<br> 
			<c:if test="${member == null}">	
			<span style="color: red"><strong> 현재 페이지는 회원만 이용 가능합니다.</strong></span>
			</c:if>
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
						</tr>
					</thead>

					<c:forEach items="${boardList}" var="list">
						<tr>
							<td class="text-center"><c:out value="${list.board_no}" /></td>
							<td><a href="/board/read?board_no=${list.board_no}"><c:out
										value="${list.board_title}" /></a></td>
							<td class="text-center"><c:out value="${list.board_writer}" /></td>
							<td class="text-center"><c:out value="${list.board_count}" /></td>
							<td class="text-center"><c:out value="${list.board_regdate}" /></td>
						</tr>
					</c:forEach>

					</tbody>
				</table>
				<c:if test="${member != null}">	
				<button type="button" onclick="location.href='/board/create';" class="btn btn-success">글쓰기</button>
				</c:if>
			</div>
		</div>
	</div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->
<%@include file="../includes/footer.jsp"%>
