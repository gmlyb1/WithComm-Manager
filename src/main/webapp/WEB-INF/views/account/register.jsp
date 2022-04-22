<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$(".cancel").on("click", function() {
			location.href = "/account/login"
		})

		$("#submit").on("click", function() {
			if ($("#me_id").val() == "") {
				alert("닉네임을 입력하세요.");
				$("#me_id").focus();
				return false;
			}
			
			if ($("#me_email").val() == "") {
				alert("가입하실 이메일을 입력하세요.");
				$("#me_email").focus();
				return false;
			}

			if ($("#me_pwd").val() == "") {
				alert("비밀번호를 입력하세요.");
				$("#me_pwd").focus();
				return false;
			}
			
/* 			var idChkVal = $("#idChk").val();
			if(idChkVal == "N") {
				alert("중복 확인 버튼을 눌러주세요");
			} else if (idChkVal == "Y") {
				$("#regForm").submit();
			}
 */			
		});
	})
	
	/* function fn_idChk() {
		$.ajax({
			url: "/account/idChk",
			type : "post",
			dataType :"json",
			data : {"me_email" : $("#me_email").val()},
			success : function(data) {
				if(data ==1) {
					alert("중복된 아이디입니다.");
				}else if(data ==0) {
					$("#idChk").attr("value","Y");
					alert("사용가능한 아이디입니다.");
				}
			}
		
		})
	} */
</script>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Register</title>

<!-- Custom fonts for this template-->
<link href="/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<form action="/account/register" method="post" id="regform">
	<input type="hidden" id="me_id_yn" name="me_id_yn" value="N" />

	<body class="bg-gradient-primary">
		<div class="container">
			<div class="card o-hidden border-0 shadow-lg my-5">
				<div class="card-body p-0">
					<!-- Nested Row within Card Body -->
					<div class="row">
						<div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
						<div class="col-lg-7">
							<div class="p-5">
								<div class="text-center">
									<h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
								</div>
									<div class="form-group row">
										<div class="col-sm-12 mb-3 mb-sm-0">
											<input type="text" class="form-control form-control-user"
												id="me_id" name="me_id" style="text-align: center;"
												placeholder="닉네임">
										</div>
									<div class="form-group row">
										<div class="col-sm-12 mb-3 mb-sm-0">
											<input type="email" class="form-control form-control-user"
												id="me_email" name="me_email" style="text-align: center;"
												placeholder="이메일">
										</div>
									</div>
									<div class="form-group row">
										<div class="col-sm-8 mb-3 mb-sm-0">
											<input type="password" class="form-control form-control-user"
												id="me_pwd" name="me_pwd" style="text-align: center;"
												placeholder="비밀번호">
										</div>
									</div>
									<button type="submit" id="submit" class="btn btn-primary btn-user btn-block">회원가입</button>
									<hr>
									<a href="index.html" class="btn btn-google btn-user btn-block">
										아이디/비밀번호 찾기(구현x) </a> <a href="/account/login"
										class="btn btn-facebook btn-user btn-block"> 로그인 </a> <a
										href="/home" class="btn btn-warning btn-user btn-block">
										홈페이지 </a>
								<hr>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Bootstrap core JavaScript-->
		<script src="/resources/vendor/jquery/jquery.min.js"></script>
		<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

		<!-- Core plugin JavaScript-->
		<script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

		<!-- Custom scripts for all pages-->
		<script src="/resources/js/sb-admin-2.min.js"></script>

	</body>
</form>
</html>