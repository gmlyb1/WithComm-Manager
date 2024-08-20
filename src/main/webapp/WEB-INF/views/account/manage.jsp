<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<%@include file="../includes/header.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {
		
		//관리자 지정
		$(".admin-button").click(function() {
			var memberId = $(this).data("member-id");
			var adminCk = $(this).data("admin-ck");
			var state = $(this).data("state");
			
			
			if (confirm("관리자로 지정하시겠습니까?")) {
				$.ajax({
					url : "/account/selectManager",
					type : "POST",
					data : {
						me_id : memberId,
						adminCk : 1,
						state : "관리자"
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
			var aprvStts = $(this).data("aprv-stts");

			if (confirm("회원가입된 회원을 승인 하시겠습니까?")) {
				$.ajax({
					url : "/account/state",
					type : "POST",
					data : {
						me_id : memberId,
						state : "일반회원",
						aprvStts : "승인완료"
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

		// 회원 활동 중지 처리.
		$(".notApproveBtn").click(function() {
			var memberId = $(this).data("member-id");
			var state = $(this).data("state");
			var aprvStts = $(this).data("aprv-stts");
			
			if (confirm("회원의 활동을 중지 하시겠습니까?")) {
				$.ajax({
					url : "/account/state",
					type : "POST",
					data : {
						me_id : memberId,
						state : "활동중지",
						aprvStts : ""
					},
					success : function(data) {
						alert("해당 회원은 활동 중지 처리되었습니다.");
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
		
		// 비밀번호 초기화
		$(".pwValid").click(function() {
			 var newPassword = "${newPassword}";
			 console.log("newPassword:",newPassword);
			 var mePwd = $(this).data("member-pwd");
			 var memberId = $(this).data("member-id");
			if (confirm("비밀번호를 초기화 하시겠습니까?")) {
				$.ajax({
					url : "/account/pwValid",
					type : "POST",
					data : {
						me_id : memberId
					},
					success : function(data) {
						alert("비밀번호가 초기화 되었습니다.\n새로운 비밀번호는 "+mePwd+"입니다.");
					},
					error : function(error) {
						console.log(error);
						alert("요청 처리 중 오류가 발생하였습니다."+error);
					}
				});
			}
		});
		
		
		//끝
	});
</script>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">회원 관리</h1>
	
	<!-- Search Form -->
	<div class="card mb-4">
		<div class="card-header">
			<h6 class="m-0 font-weight-bold text-primary">검색 조건</h6>
		</div>
		<div class="card-body">
			<form id="searchForm" action="/account/manage" method="GET">
				<div class="form-row">
					<div class="col-md-4 mb-3">
						<label for="me_email">계정</label>
						<input type="text" class="form-control" id="me_email" name="me_email" placeholder="이메일" value="${param.me_email}">
					</div>
					<div class="col-md-4 mb-3">
						<label for="me_name">닉네임</label>
						<input type="text" class="form-control" id="me_name" name="me_name" placeholder="닉네임" value="">
					</div>
					<div class="col-md-4 mb-3">
						<label for="state">상태</label>
						<select class="form-control" id="state" name="state">
							<option value="">전체</option>
			                <option value="승인대기중" ${param.state == '승인대기중' ? 'selected' : ''}>승인대기중</option>
			                <option value="일반회원" ${param.state == '일반회원' ? 'selected' : ''}>일반회원</option>
			                <option value="활동중지" ${param.state == '활동중지' ? 'selected' : ''}>활동중지</option>
						</select>
					</div>
				 	<div class="col-md-4 mb-3">
			            <label for="startDate">시작 날짜</label>
			            <input type="date" class="form-control" id="startDate" name="startDate" value="${param.startDate}">
			        </div>
			        <div class="col-md-4 mb-3">
			            <label for="endDate">종료 날짜</label>
			            <input type="date" class="form-control" id="endDate" name="endDate" value="${param.endDate}">
			        </div>
				</div>
				<button type="submit" id="searchBtn" class="button-container btn btn-primary">조회</button>
			</form>
		</div>
	</div>
	
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">회원 관리 페이지(계정 ,
				비밀번호 , 닉네임 , 회원등급 , 회원가입일자 , 수정과 삭제 가능)</h6>
			<br> <span style="color: red"><strong> 현재 페이지는
					슈퍼 관리자와 관리자 등급만 조회 가능합니다. (관리자 여부 0 = 관리자 x , 1 = 관리자)</strong></span>&nbsp;&nbsp;&nbsp;
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
					<thead>
						<tr>
							<th class="text-center">번호</th>
							<th class="text-center">계정</th>
							<th class="text-center">닉네임</th>
							<th class="text-center">상태</th>
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
								<td class="text-center"><fmt:formatDate
										value="${member.me_regDate}" pattern="yyyy-MM-dd" /></td>
								<td class="text-center">
								    <div class="btn-group" role="group">
									    <c:if test="${member.state == '승인대기중' || member.state == '활동중지'}">
									        <button type="button" class="btn btn-success approveBtn" data-member-id="${member.me_id}" data-aprv-stts="${member.aprvStts}">승인</button>
									    </c:if>
									     <c:if test="${member.state == '일반회원'}">
								        	<button type="button" class="btn btn-secondary admin-button" data-member-id="${member.me_id}" data-admin-ck="${member.adminCk}" data-state="${member.state}">관리자</button>
								         </c:if>
								         <c:if test="${member.state == '일반회원' || member.state != '활동중지'}">
								        <button type="button" class="btn btn-danger notApproveBtn" data-member-id="${member.me_id}" data-admin-ck="${member.adminCk}"}>중지</button>
								    	 </c:if>
								    	<button type="button" class="btn btn-primary pwValid" data-member-id="${member.me_id}" data-member-pwd="${member.me_pwd}">비밀번호 초기화</button>
								    </div>
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



