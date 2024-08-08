<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/resources/vendor/jquery/jquery.min.js"></script>
<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="/resources/js/sb-admin-2.min.js"></script>
<link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">방문자 로그 관리</h1>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">.</h6>
			<br> <span style="color: red"><strong>.</strong></span>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
					<thead>
						<tr>
							<th class="text-center">번호</th>
							<th class="text-center">방문자ip</th>
							<th class="text-center">접속일자</th>
							<th class="text-center">방문자 게정 ID</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${visitList}" var="list">
							<tr>
								<td class="text-center">${list.visit_id}</td>
								 <c:choose>
						            <c:when test="${member.state == '최고관리자'}">
						                <td class="text-center">${list.visit_ip}</td>
						            </c:when>
						            <c:otherwise>
						                <!-- 기본적으로 표시할 내용 또는 빈 셀을 추가합니다. -->
						                <td class="text-center">ip는 조회하실수 없습니다.</td>
						            </c:otherwise>
						        </c:choose>
									<td class="text-center">${list.regdate}</td>
								<td class="text-center">${list.me_name}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>



<%@include file="../includes/footer.jsp"%>