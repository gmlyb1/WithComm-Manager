<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<%@include file="../includes/header.jsp"%>
<script type="text/javascript">
$(document).ready(function(){
	var msg = "${msg}";
	if(msg != "") {
		alert(msg)
	}
});
</script>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">회원 관리</h1>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">회원 관리 페이지(계정 , 비밀번호 , 닉네임 , 회원등급 , 회원가입일자 , 수정과 삭제 가능)</h6>
			<br> <span style="color: red"><strong> 현재 페이지는
					슈퍼 관리자와 관리자 등급만 조회 가능합니다.</strong></span>

		</div>
		<div class="card-body">
			<div class="table-responsive">

				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th class="text-center">번호</th>
							<th class="text-center">계정</th>
							<th class="text-center">비밀번호</th>
							<th class="text-center">닉네임</th>
							<th class="text-center">회원등급</th>
							<th class="text-center">회원가입일자</th>
							<th class="text-center">비고</th>
						</tr>
					</thead>

					<c:forEach items="${memberList}" var="memberList">
						<tr>
							<td class="text-center">${memberList.me_id}</td>
							<td class="text-center">${memberList.me_email}</td>
							<td class="text-center">${memberList.me_pwd}</td>
							<td class="text-center">${memberList.me_name}</td>
							<td class="text-center">${memberList.me_grade}</td>
							<td class="text-center">
							<fmt:formatDate value="${memberList.me_regDate}" pattern="yy-MM-dd HH:mm" />
							</td>
							<td class="text-center">
								<a href="/account/profile" class="btn btn-success">수정</a>
								<a class="btn btn-danger">삭제</a>
							</td>
						</tr>
					</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
</div>


<%@include file="../includes/footer.jsp"%>