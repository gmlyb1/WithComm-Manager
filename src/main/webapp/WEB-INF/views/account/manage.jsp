<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<%@include file="../includes/header.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {
		//관리자 지정
		$(".admin-button").click(function() {
			var memberId = $(this).data("member-id");
			var adminCk = $(this).data("admin-ck");

			if (confirm("관리자로 지정하시겠습니까?")) {
				$.ajax({
					url : "/account/selectManager",
					type : "POST",
					data : {
						me_id : memberId,
						adminCk : 1
					},
					success : function(data) {
						// 요청이 성공적으로 처리되면, 처리할 코드 작성
						alert("요청이 성공적으로 처리되었습니다.");
						console.log(data);
						location.reload();
					},
					error : function(error) {
						console.log(error);
						alert("요청 처리 중 오류가 발생하였습니다."+error);
					}
				});
			}
		});
		
		// 회원 승인 처리
		$(".approveBtn").click(function() {
			var memberId = $(this).data("member-id");
			var state = $(this).data("state");
			
			
			if (confirm("회원가입된 회원을 승인 하시겠습니까?")) {
				$.ajax({
					url : "/account/approvalChk",
					type : "POST",
					data : {
						me_id : memberId,
						state : "일반회원"
					},
					success : function(data) {
						alert("승인이 성공적으로 처리되었습니다.");
						console.log(data);
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

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">회원 관리</h1>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">회원 관리 페이지(계정 ,
				비밀번호 , 닉네임 , 회원등급 , 회원가입일자 , 수정과 삭제 가능)</h6>
			<br> <span style="color: red"><strong> 현재 페이지는
					슈퍼 관리자와 관리자 등급만 조회 가능합니다. (관리자 여부 0 = 관리자 x , 1 = 관리자)</strong></span>

		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th class="text-center">번호</th>
							<th class="text-center">계정</th>
							<th class="text-center">닉네임</th>
							<th class="text-center">상태</th>
							<th class="text-center">관리자 여부</th>
							<th class="text-center">회원가입일자</th>
							<th class="text-center">비고</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${memberList}" var="member">
							<tr>
								<td class="text-center">${member.me_id}</td>
								<td class="text-center">${member.me_email}</td>
								<td class="text-center">${member.me_name}</td>
								<td class="text-center">${member.state}</td>
								<td class="text-center">${member.adminCk}</td>
								<td class="text-center"><fmt:formatDate
										value="${member.me_regDate}" pattern="yyyy-MM-dd" /></td>
								<td class="text-center">
									<c:if test="${member.state == '승인대기중' }">
										<button type="button" class="btn btn-success approveBtn" data-member-id="${member.me_id}" data-state="${member.state}">가입승인</button>
									</c:if>
									<c:if test="${member.adminCk != '1' }">
										<button type="button" class="btn btn-secondary admin-button" data-member-id="${member.me_id}" data-admin-ck="${member.adminCk}">관리자 지정</button>
									</c:if> 
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>


<%@include file="../includes/footer.jsp"%>