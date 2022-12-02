<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	
	$("#pwUpdate").on("click", function(){
		if($("#me_pwd").val==""){
			alert("현재 비밀번호를 입력해주세요");
			$("#me_pwd").focus();
			return false
		}
		if($("#me_pwd1").val==""){
			alert("변경비밀번호을를 입력해주세요");
			$("#me_pwd1").focus();
			return false
		}
		if($("#me_pwd2").val==""){
			alert("변경비밀번호를 입력해주세요");
			$("#me_pwd2").focus();
			return false
		}
		if ($("#me_pwd").val() != $("#me_pwd2").val()) {
			alert("변경비밀번호가 일치하지 않습니다.");
			$("#me_pwd2").focus();
			 
		
		$.ajax({
			url : "/account/pwCheck",
			type : "POST",
			dataType : "json",
			data : $("#pwUpdateForm").serializeArray(),
			success: function(data){
				
				if(data==0){
					alert("패스워드가 틀렸습니다.");
					return;
				}else{
					if(confirm("변경하시겠습니까?")){
						$("#pwUpdateForm").submit();
					}
					
				}
			}
		})
		
	});
})
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

	<form action="/account/update" method="post" id="pwUpdateForm" name="pwUpdateForm">
                       <input type="hidden" id="me_email" name="me_email" value="${member.me_email}">
    <div class="col-sm-8 col-sm-offset-2">
        <div class="panel panel-default panel-margin-10">
            <div class="panel-body panel-body-content text-center">
                <p class="lead">변경하실 비밀번호를 입력해 주세요.</p>
                <div class="form-group">
                    <input type="password" name="me_pwd" id="me_pwd" class="form-control form-control-inline text-center" placeholder="현재 비밀번호" />
                </div>
                <div class="form-group">
                    <input type="password" name="me_pwd1" class="form-control form-control-inline text-center" placeholder="새 비밀번호" />
                </div>
                <div class="form-group">
                    <input type="password" name="me_pwd2" class="form-control form-control-inline text-center" placeholder="새 비밀번호 확인" />
                </div>
                <button type="button" id="pwUpdate" name="pwUpdate" class="btn btn-primary">비밀번호 변경</button> <a href="/account/profile" class="btn btn-default">취소</a>
            </div>
        </div>
    </div>
    </form>

	<script src="/resources/vendor/jquery/jquery.min.js"></script>
	<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/resources/js/sb-admin-2.min.js"></script>

<%@include file="../includes/footer.jsp"%>