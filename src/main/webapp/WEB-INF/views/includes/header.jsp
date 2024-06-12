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
		
		$("#logoutBtn").on("click", function() {
			
		if(confirm("로그아웃 하시겠습니까?")) {
			alert("로그아웃을 완료하였습니다.");
			location.href = "/account/logout"
		}
	})

	var msg = "${msg}";
	if (msg != "") {
		alert(msg);
	}
	
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
    }
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

<!-- Custom fonts for this template -->
<link href="/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="/resources/vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">

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
		<div class="sidebar-heading">Interface</div>
			<!-- Nav Item - Tables -->
			<c:if test="${member.state == '최고관리자'}">
				<li class="nav-item active"><a class="nav-link"
					href="/account/AdminManage"><i class="fa-thin fa-user"></i>
					<span>운영진 관리</span></a></li>
			</c:if>
			<c:if test="${member != null}">
				<li class="nav-item active"><a class="nav-link"
					href="/account/manage"><i class="fa-sharp fa-solid fa-users"></i>
					<span>회원 관리</span></a></li>
				<li class="nav-item active"><a class="nav-link"
					href="/notice/list"><i class="fa-thin fa-check"></i>
					<span>공지사항 관리</span></a></li>
				<li class="nav-item active"><a class="nav-link"
					href="/board/list"><i class="fa-thin fa-mug-hot"></i>
					<span>게시판 관리</span></a></li>
				<li class="nav-item active"><a class="nav-link"
					href="/inquiry/list"><i class="fa-thin fa-circle-exclamation"></i>
					<span>1:1 문의 관리</span></a></li>
				<li class="nav-item active"><a class="nav-link"
					href="/mail/recevMail"><i class="fa-thin fa-circle-exclamation"></i>
					<span>메일 관리</span></a></li>
			</c:if>
			
			<!-- Nav Item - Pages Collapse Menu -->
			
			<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Custom Components:</h6>
					<a class="collapse-item" href="buttons.html">Buttons</a> <a
						class="collapse-item" href="cards.html">Cards</a>
				</div>
			</div>

			<!-- Nav Item - Utilities Collapse Menu -->
			
			<div id="collapseUtilities" class="collapse"
				aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Custom Utilities:</h6>
					<a class="collapse-item" href="utilities-color.html">Colors</a> <a
						class="collapse-item" href="utilities-border.html">Borders</a> <a
						class="collapse-item" href="utilities-animation.html">Animations</a>
					<a class="collapse-item" href="utilities-other.html">Other</a>
				</div>
			</div>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Addons</div>

			<!-- Nav Item - Pages Collapse Menu -->
			
			<div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Login Screens:</h6>
					<a class="collapse-item" href="/account/login">Login</a> <a
						class="collapse-item" href="/account/register">Register</a> <a
						class="collapse-item" href="forgot-password.html">Forgot
						Password</a>
					<div class="collapse-divider"></div>
					<h6 class="collapse-header">Other Pages:</h6>
					<a class="collapse-item" href="/error/404.jsp">404 Page</a> <a
						class="collapse-item" href="blank.html">Blank Page</a>
				</div>
			</div>

			<!-- Nav Item - Charts -->

			<!-- Nav Item - Tables -->
			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

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
										<a class="dropdown-item" href="/account/profile"> <i
											class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> 프로필
										</a>
										<a class="dropdown-item" href="/account/updateImg"> <i
											class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> 이미지변경
										</a>
										<c:if test="${member.adminCk == 1}">
											<a class="dropdown-item" href="/account/manage"> <i
												class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i> 회원관리
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
								<button id="logoutBtn" type="button" class="btn btn-primary">로그아웃</button>
						   </div>
							</c:if>
                      </ul>
					</form>
				</nav>
				<!-- End of Topbar -->