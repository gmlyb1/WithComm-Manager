<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
Date nowTime = new Date();
SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss");
%>

<!DOCTYPE html>
<html>

<head>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#logoutBtn").on("click", function() {
			alert("로그아웃을 완료하였습니다.");
			location.href = "/account/logout"
		})
	})
</script>



<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="/admin/index">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-laugh-wink"></i>
				</div>
				<div class="sidebar-brand-text mx-3">SOFT 관리자</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<!-- <li class="nav-item"><a class="nav-link" href="/home"> <i
					class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
			</a></li> -->

			<!-- Divider -->
			<!-- <hr class="sidebar-divider"> -->

			<!-- Heading -->
			<div class="sidebar-heading">관리</div>
			<!-- Nav Item - Tables -->
			<c:if test="${member != null}">
				<li class="nav-item active"><a class="nav-link"
					href="#"> <i class="fas fa-fw fa-table"></i> <span>상품 등록</span></a></li>
			</c:if>

			<c:if test="${member != null}">
				<li class="nav-item active"><a class="nav-link"
					href="#"> <i class="fas fa-fw fa-table"></i> <span>상품 목록</span></a>
				</li>
			</c:if>
			
			<c:if test="${member != null}">
				<li class="nav-item active"><a class="nav-link"
					href="#"> <i class="fas fa-fw fa-table"></i> <span>상품 소감</span></a>
				</li>
			</c:if>
			
			<c:if test="${member != null}">
				<li class="nav-item active"><a class="nav-link"
					href="#"> <i class="fas fa-fw fa-table"></i> <span>유저 목록</span></a>
				</li>
			</c:if>


			<!-- Nav Item - Pages Collapse Menu -->
			<!-- <li class="nav-item"><a class="nav-link collapsed" href="#"
					data-toggle="collapse" data-target="#collapseTwo"
					aria-expanded="true" aria-controls="collapseTwo"> <i
						class="fas fa-fw fa-cog"></i> <span>Components</span> -->
			</a>
			<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
				data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Custom Components:</h6>
					<a class="collapse-item" href="buttons.html">Buttons</a> <a
						class="collapse-item" href="cards.html">Cards</a>
				</div>
			</div>
			</li>

			<!-- Nav Item - Utilities Collapse Menu -->
			<!-- <li class="nav-item"><a class="nav-link collapsed" href="#"
					data-toggle="collapse" data-target="#collapseUtilities"
					aria-expanded="true" aria-controls="collapseUtilities"> <i
						class="fas fa-fw fa-wrench"></i> <span>Utilities</span> -->
			</a>
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
			</li>

			<!-- Divider -->
			<!-- <hr class="sidebar-divider"> -->

			<!-- Heading -->
			<!-- <div class="sidebar-heading">Addons</div> -->

			<!-- Nav Item - Pages Collapse Menu -->
			<!-- <li class="nav-item"><a class="nav-link collapsed" href="#"
					data-toggle="collapse" data-target="#collapsePages"
					aria-expanded="true" aria-controls="collapsePages"> <i
						class="fas fa-fw fa-folder"></i> <span>Pages</span> -->
			</a>
			<div id="collapsePages" class="collapse"
				aria-labelledby="headingPages" data-parent="#accordionSidebar">
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
			</li>

			<!-- Nav Item - Charts -->
			<!-- <li class="nav-item"><a class="nav-link" href="charts.html">
						<i class="fas fa-fw fa-chart-area"></i> <span>Charts</span>
				</a></li> -->

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
								</div></li>
							<c:if test="${member == null}">
								<a href="/account/login" class="btn btn-primary">로그인</a>
							</c:if>
							<c:if test="${member != null }">
								<li><a class="nav-item dropdown no-arrow" href="#"
									id="userDropdown" role="button" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false"> <span
										class="mr-2 d-none d-lg-inline text-gray-600 small"><strong>${member.me_name}</strong></span>
										<img class="img-profile rounded-circle"
										src="img/undraw_profile.svg">
								</a> <!-- Dropdown - User Information -->
									<div
										class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
										aria-labelledby="userDropdown">
										<a class="dropdown-item" href="/account/profile"> <i
											class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
											프로필
										</a>
										<c:if test="${member.me_grade == '최고관리자'|| member.me_grade =='관리자' }">
										<a class="dropdown-item" href="/account/manage"> <i
											class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
											회원관리
										</a> 
										
										<a class="dropdown-item" href="/admin/index"> <i
											class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
											관리자 화면
										</a> 
										
										<a class="dropdown-item" href="../home"> <i
											class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
											일반 화면
										</a> 
										</c:if>
										<a class="dropdown-item" href="#"> <i
											class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
											설정
										</a>
										 <a class="dropdown-item" href="#"> <i
											class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
											활동 로그
										</a>
										<div class="dropdown-divider"></div>
									</div></li>
								<button id="logoutBtn" type="button" class="btn btn-primary">로그아웃</button>
								<button type="button" class="btn btn-danger"
									onclick="location.href='/account/delete';">회원탈퇴</button>
							</c:if>
							<c:if test="${member.me_email == 'admin@admin.co.kr' }">
								<a href="/account/register" class="btn btn-success">회원가입</a>
								<br>
							</c:if>
							<!-- Nav Item - User Information -->
							<%-- <c:if test="${member != null }">
						<li>
                            <a class="nav-item dropdown no-arrow" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">${member.me_name}</span>
                                <img class="img-profile rounded-circle"
                                    src="img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Settings
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Activity Log
                                </a>
                                <div class="dropdown-divider"></div>
                               <!--  <Button id="logoutBtn" class="dropdown-item">
                                    <!-- <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i> 
                                    Logout
                                </Button> -->
                            </div>
                        </li>
                        
                       </c:if> --%>
					</form>
					</ul>
				</nav>
				<!-- End of Topbar -->