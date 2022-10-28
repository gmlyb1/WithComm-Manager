<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript">
	var path = "${pageContext.request.contextPath}";
	
	$(document).ready(function(){
		var msg = "${msg}";
		if(msg != "") {
			alert(msg)
		}
	});
	
	function fnSubmit() {
		var email_rule =  /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		var tel_rule = /^\d{2,3}-\d{3,4}-\d{4}$/;
		
		if($("#me_name").val() == null || #("#me_name").val() == "") {
			alert("이름을 입력해 주세요.");
			$("#me_name").focus();
			return false;
		}
		
		if($("#me_id").val() == null || $("#me_id").val() == "") {
			alert("아이디를 입력해 주세요.");
			$("#me_id").focus();
			return false;
		}
		
		if($("#me_tel").val() == null || #("#me_tel").val () == "") {
			alert("전화번호를 입력해 주세요.");
			$("#me_tel").focus();
			return false;
		}
		
		if(!tel_rule.test($("#me_tel").val())) {
			alert("전화번호 형식에 맞게 입력해 주세요.");
			return false;
		}
		
		if($("#me_email").val() == null || $("#me_email").val() == "") {
			alert("이메일을 입력해 주세요.");
			$("#me_email").focus();
			return false;
		}
		
		if(!email_rule.test($("#me_email").val())) {
			alert("이메일을 형식에 맞게 입력해 주세요.");
			return false;
		}
		
		if($("#me_pwd").val() != "" && $("#me_pwd2").val() != "") {
			alert("비밀번호를 입력해 주세요.");
			$("#me_pwd2").focus();
			return false;
		}
		
		if($("#me_pwd").val() != $("#me_pwd2").val()) {
			alert("비밀번호가 일치하지 않습니다.");
			$("#me_pwd2").focus();
			return false;
		}
		
		if(confirm("회원 정보를 수정 하시겠습니까?")) {
			$("#createForm").submit();
			return false
		}
	}
</script>
<!-- Custom fonts for this template-->
<link href="/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">
<%@include file="../includes/header.jsp"%>

<form commandName="mVO" id="createForm"
	action="${path}/account/profile_action" method="post">
	<div class="container">
		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0">
				<div class="row">
					<div class="col-lg-5 d-none d-lg-block be-register-image">
						<div class="col-lg-7">
							<div class="p-5">
								<div class="text-center">
									<h1 class="h4 text-gray-900 mb-4">프로필</h1>
								</div>
							</div>

							<form class="user">
								<div class="form-group row">
									<div class="col-sm-12 mb-3 mb-sm-0">
										계정아이디:<input type="text" class="form-control form-control-user"
											id="me_id" name="me_id" style="text-align: center;"
											value="${member.me_email}"
											placeholder="아이디"
											readonly="readonly">
									</div>
								</div>

								<div class="form-group row">
									<div class="col-sm-12 mb-3 mb-sm-0">
										닉네임:<input type="text" class="form-control form-control-user"
											id="me_name" name="me_name" style="text-align: center;"
											value="${member.me_name}" placeholder="닉네임">
									</div>
								</div>
								
								<div class="form-group row">
									<div class="col-sm-12 mb-3 mb-sm-0">
									회원등급:	<input type="text" class="form-control form-control-user"
											id="me_grade" name="me_grade" style="text-align: center;"
											value="${member.me_grade}" placeholder="회원등급">
									</div>
								</div>

								<%-- <div class="form-group row">
									<div class="col-sm-12 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user"
											id="me_tel" name="me_tel" style="text-align: center;"
											value="${mVO.me_tel}" placeholder="전화번호">
									</div>
								</div> --%>

								<%-- <div class="form-group row">
									<div class="col-sm-12 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user"
											id="me_email" name="me_email" style="text-align: center;"
											value="${mVO.me_email }" placeholder="이메일 주소">
									</div>
								</div> --%>
								<div class="form-group row">
									<div class="col-sm-12 mb-3 mb-sm-0">
										<input type="password" class="form-control form-control-user"
											id="me_pwd" name="me_pwd" style="text-align: center;"
											placeholder="비밀번호">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12 mb-3 mb-sm-0">
										<input type="password" class="form-control form-control-user"
											id="me_pwd2" style="text-align: center;"
											placeholder="비밀번호 확인">
									</div>
								</div>
								<button onclick="location.href='#;" class="btn btn-primary" onclick="fnSubmit();" return false;">
									수정
								</button>
								<br>
								<button type="button" class="btn btn-danger"
									onclick="location.href='/account/delete';">회원탈퇴</button>
								<br>
								<a href="/home" class="btn btn-warning">
									메인페이지로 이동
								</a>								
							</form>
							<hr>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

<script src="/resources/vendor/jquery/jquery.min.js"></script>
<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
 
<!-- Core plugin JavaScript-->
<script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>
 
<!-- Custom scripts for all pages-->
<script src="/resources/js/sb-admin-2.min.js"></script>


</form>

<%@include file="../includes/footer.jsp"%>