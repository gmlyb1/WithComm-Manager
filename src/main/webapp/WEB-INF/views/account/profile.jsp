<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="/resources/vendor/jquery/jquery.min.js"></script>
	<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/resources/js/sb-admin-2.min.js"></script>
	<link href="/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">

<script type="text/javascript">
	function _onsubmit() {

		if ($("#me_pwd").val() == "") {
			alert("비밀번호를 입력해주세요");
			$("#me_pwd").focus();
			return false;
		}


		if (!confirm("2차 비밀번호를 변경 하시겠습니까?")) {
			return false;
		}
	}
</script>

<!-- Custom fonts for this template-->
<div class="container">
	<div class="card o-hidden border-12 shadow-lg my-12">
		<div class="card-body p-0">
			<div class="row">
				<div class="col-lg-12 d-none d-lg-block be-register-image">
					<div class="col-lg-12">
						<div class="p-12">
						<div class="text-center">
							<h1 class="h4 text-gray-900 mb-12">2차 비밀번호 변경</h1>
						</div>
						</div>
						<div class="form-group">
						    <div class="col-sm-12 mb-12 mb-sm-12">
						        <label for="me_pwd">비밀번호:</label>
						        <input type="password" class="form-control form-control-user" id="me_pwd" name="me_pwd" style="text-align: center;" placeholder="비밀번호">
						    </div>
						</div>
						<a href="/account/update" class="btn btn-primary"> 수정하기</a>
						 <a href="/home" class="btn btn-warning"> 메인으로 </a>
						<hr>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="../includes/footer.jsp"%>