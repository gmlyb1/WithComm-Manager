<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page session="true"%>

<%
Date nowTime = new Date();
SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss");
%>

<%-- <%
	HttpSession s = request.getSession();
	s.setMaxInactiveInterval(6);
%> --%>

<!DOCTYPE html>
<html>

<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

	
	// 로그인 버튼 클릭 시 모달을 띄우는 예시
    $('#changePasswordModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // 버튼을 클릭했을 때의 이벤트
        var recipient = button.data('whatever'); // 버튼의 data-whatever 속성값

        var modal = $(this);
        modal.find('.modal-title').text('2차 비밀번호 변경');
        modal.find('.modal-body input').val(recipient);
    });

    // 폼 제출 전 유효성 검사
    $("#secondPwdForm").on('submit', function(e) {
        var second_me_pwd = $('#second_me_pwd').val();
		console.log(second_me_pwd);
        if (second_me_pwd == '') {
        	e.preventDefault();
            alert('변경하실 2차 비밀번호를 입력해 주십시오.');
            return;
        }
    });	
		
	$("#logoutBtn").on("click", function() {
			
		if(confirm("로그아웃 하시겠습니까?")) {
			alert("로그아웃을 완료하였습니다.");
			location.href = "/account/logout"
		}
	});

	
	var countdownElement = document.getElementById('countdown');
    var minutesElement = document.getElementById('minutes');
    var secondsElement = document.getElementById('seconds');

    var totalSeconds = 30 * 60; // 30분을 초로 변환
    var countdownInterval = setInterval(updateCountdown, 1000); // 1초마다 카운트다운 업데이트

    function updateCountdown() {
        var minutes = Math.floor(totalSeconds / 60);
        var seconds = totalSeconds % 60;

        // 시간을 업데이트
        minutesElement.textContent = minutes < 10 ? '0' + minutes : minutes;
        secondsElement.textContent = seconds < 10 ? '0' + seconds : seconds;

        if (totalSeconds <= 0) {
            clearInterval(countdownInterval); // 카운트다운 중지
            // 원하는 동작을 수행 (예: 로그아웃)
        	var sessionExpirationTime = 6000;
			setTimeout(function() {
				alert("세션이 만료되어 자동 로그아웃 됩니다.");
				location.reload();
			}, sessionExpirationTime);
        } else {
            totalSeconds--;
        }
    };
    //끝
});
</script> 
<style>
  /* 카운트다운 스타일 */
  #countdown {
    font-size: 24px;
    color: #000; /* 검은색 */
    font-weight: bold;
    display: flex;
    align-items: center;
  }

  #countdown span {
    background-color: #f5f5f5; /* 배경색 */
    padding: 5px;
    border-radius: 5px;
    margin: 0 5px;
  }

  #clock-icon {
    font-size: 24px;
    color: #000; /* 아이콘 색상 (검은색) */
  }
</style>
<meta charset="UTF-8"> <!-- 추가할부분 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 추가할부분 -->
<meta http-equiv="X-UA-Compatible" content="ie=edge"> <!-- 추가할부분 -->
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Tables</title>

<link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">
<link href="/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a class="sidebar-brand d-flex align-items-center justify-content-center" href="../home">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-laugh-wink"></i>
				</div>
				<div class="sidebar-brand-text mx-3">위드컴 관리자</div>
			</a>


			<!-- Heading -->
		<div class="sidebar-heading">멤버 관리</div>
			<!-- Nav Item - Tables -->
			<c:if test="${member.state == '최고관리자'}">
				<li class="nav-item active"><a class="nav-link"
					href="/account/AdminManage"><i class="fa-solid fa-person"></i>
					<span>운영진 관리</span></a></li>
			</c:if>
			<c:if test="${member != null}">
				<li class="nav-item active"><a class="nav-link"
					href="/account/manage"><i class="fa-solid fa-person"></i>
					<span>회원 관리</span></a></li>
		<div class="sidebar-heading">게시판 관리</div>
				<li class="nav-item active"><a class="nav-link"
					href="/notice/list"><i class="fa-solid fa-person"></i>
					<span>공지사항 관리</span></a></li>
				<li class="nav-item active"><a class="nav-link"
					href="/board/list"><i class="fa-solid fa-person"></i>
					<span>게시판 관리</span></a></li>
				<li class="nav-item active"><a class="nav-link"
					href="/inquiry/list"><i class="fa-solid fa-person"></i>
					<span>1:1 문의 관리</span></a></li>
		<div class="sidebar-heading">기타 관리</div>
				<li class="nav-item active"><a class="nav-link"
					href="/mail/recevMail"><i class="fa-solid fa-persone"></i>
					<span>메일 관리</span></a></li>
				<li class="nav-item active"><a class="nav-link"
					href="/visit/list"><i class="fa-solid fa-persone"></i>
					<span>접속자 정보 관리</span></a></li>
			</c:if>

			<!-- Divider -->


		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<form class="form-inline">
						<button id="sidebarToggleTop"
							class="btn btn-link d-md-none rounded-circle mr-3">
							<i class="fa fa-bars"></i>
						</button>
					</form>

					<!-- Topbar Search -->
					<form
						class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
						<div class="input-group">
							<input type="text" class="form-control bg-light border-0 small"
								placeholder="Search for..." aria-label="Search"
								aria-describedby="basic-addon2">
							<div class="input-group-append">
								<button class="btn btn-primary" type="button">
									<i class="fas fa-search fa-sm"></i>
								</button>
							</div>
						</div>
					</form>

					<!-- Topbar Navbar -->
				<form action="/account/login" method="post">
					<ul class="navbar-nav ml-auto">
							<!-- Nav Item - Search Dropdown (Visible Only XS) -->
						<li class="nav-item dropdown no-arrow d-sm-none"><a
								class="nav-link dropdown-toggle" href="#" id="searchDropdown"
								role="button" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
							</a> <!-- Dropdown - Messages -->
								<div
									class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
									aria-labelledby="searchDropdown">
									<form class="form-inline mr-auto w-100 navbar-search">
										<div class="input-group">
											<input type="text"
												class="form-control bg-light border-0 small"
												placeholder="Search for..." aria-label="Search"
												aria-describedby="basic-addon2">
											<div class="input-group-append">
												<button class="btn btn-primary" type="button">
													<i class="fas fa-search fa-sm"></i>
												</button>
											</div>
										</div>
								</div>
							</li>
							
							
							<c:if test="${member == null}">
								<a href="/account/login" class="btn btn-primary">로그인</a>
							</c:if>
							
							<c:if test="${member != null }">
							<a href="#" style="color: black; font-size: 16px; text-decoration: none; font-weight: bold;">
							    <c:out value="${list.memberVO.me_name}" />
							</a>
								<li>
									<!-- 타임아웃 -->
									<div class="d-flex align-items-center">
									    <strong>자동 로그아웃 <i id="clock-icon" class="fas fa-clock"></i></strong>
									    <span id="countdown" class="mr-3">
									        <strong><span id="minutes">30</span>:<span id="seconds">00</span></strong>
									    </span>
									    <a class="nav-item dropdown no-arrow" href="#" id="userDropdown" role"button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									        <span class="nav-link" style="color: black;"><strong>${member.me_name}</strong>님, 환영합니다!</span>
									    </a>
									</div>
								 <!-- Dropdown - User Information -->
									<div
										class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
										aria-labelledby="userDropdown">
										<a class="dropdown-item" href="/account/profile"> 
											<i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> 프로필
										</a>
										<a class="dropdown-item" href="/account/updateImg"> 
											<i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> 이미지변경
										</a>
										<c:if test="${member.state == '관리자'}">
											<a class="dropdown-item" href="/account/manage"> 
												<i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i> 회원관리
											</a>
										</c:if>
										<a class="dropdown-item" href="#"> <i
											class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i> 설정
										</a> <a class="dropdown-item" href="#"> <i
											class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i> 활동 로그
										</a>
										<div class="dropdown-divider"></div>
									</div>
								 </li>
						   <div style="display: flex; align-items: center;">
								<button id="logoutBtn" type="button" class="btn btn-danger">로그아웃</button>&nbsp;
								<c:if test="${member.state == '최고관리자'}">
									 <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#changePasswordModal">2차 비밀번호 변경</a>
								</c:if>
						   </div>
							</c:if>
                      </ul>
					</form>
				</nav>
				
				<!-- 2차 비밀번호 변경 모달 -->
			    <div class="modal fade" id="changePasswordModal" tabindex="-1" role="dialog" aria-labelledby="changePasswordModalLabel" aria-hidden="true">
			        <div class="modal-dialog" role="document">
			            <div class="modal-content">
			                <div class="modal-header">
			                    <h5 class="modal-title" id="changePasswordModalLabel">2차 비밀번호 변경</h5>
			                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			                        <span aria-hidden="true">&times;</span>
			                    </button>
			                </div>
			                <form action="/account/updateSecondPassword" method="post" id="secondPwdForm">
			                    <div class="modal-body">
			                        <div class="form-group">
			                            <label for="second_me_pwd">비밀번호:</label>
			                            <input type="password" class="form-control" id="second_me_pwd" name="second_me_pwd">
			                        </div>
			                    </div>
			                    <div class="modal-footer">
			                        <button type="submit" class="btn btn-primary">변경하기</button>
			                        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
			                    </div>
			                </form>
			            </div>
			        </div>
			    </div>
				<!-- End of Topbar -->