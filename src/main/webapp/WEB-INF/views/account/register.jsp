<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>    
 
<head>

   <meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
 
<title>SB Admin 2 - Register</title>
 
<!-- Custom fonts for this template-->
<link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link
href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
rel="stylesheet">
 
<!-- Custom styles for this template-->
<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">
 
</head>
 
<form commandName="searchVO" id="createForm" action="/account/register_action.do" method="post">
<input type="hidden" id="me_id_yn" name="me_id_yn" value="N"/>
 
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
<form class="user">
    <div class="form-group row">
        <div class="col-sm-12 mb-3 mb-sm-0">    
            <input type="text" class="form-control form-control-user" id="me_name" name="me_name" style="text-align:center;"
                placeholder="이름">
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-8 mb-3 mb-sm-0">
            <input type="text" class="form-control form-control-user" id="me_id" name="me_id" style="text-align:center;"
                placeholder="아이디">
        </div>
        <div class="col-sm-4 mb-3 mb-sm-0">
        <button type="button" class="btn btn-success btn-icon-split" style="text-align:center;" onclick="duplicate(); return false;">
            <span class="icon text-white-50">
                <i class="fas fa-check"></i>
            </span>
            <span class="text">중복체크</span>
        </button>
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-12 mb-3 mb-sm-0">
            <input type="text" class="form-control form-control-user" id="me_tel" name="me_tel" style="text-align:center;"
                placeholder="전화번호">
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-12 mb-3 mb-sm-0">
            <input type="text" class="form-control form-control-user" id="me_email" name="me_email" style="text-align:center;"
                placeholder="이메일 주소">
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-12 mb-3 mb-sm-0">
            <input type="password" class="form-control form-control-user" id="me_pwd" name="me_pwd" style="text-align:center;"
                placeholder="비밀번호">
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-12 mb-3 mb-sm-0">
            <input type="password" class="form-control form-control-user" id="me_pwd2" style="text-align:center;"
                placeholder="비밀번호 확인">
        </div>
    </div>
    <button type="submit" class="btn btn-primary btn-user btn-block" onclick="fnSubmit(); return false;">
        회원가입
    </button>
    <hr>
    <a href="index.html" class="btn btn-google btn-user btn-block">
            아이디/비밀번호 찾기
    </a>
    <a href="index.html" class="btn btn-facebook btn-user btn-block">
            로그인
    </a>
    <a href="/" class="btn btn-warning btn-user btn-block">
            홈페이지
    </a>
</form>
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