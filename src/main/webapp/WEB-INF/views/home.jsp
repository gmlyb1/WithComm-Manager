<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<%@include file="/WEB-INF/views/includes/header.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">대쉬보드</h1>
		<a href="#"
			class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
			class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
	</div>

	<!-- Content Row -->`
	<div class="row">

		<!-- Earnings (Monthly) Card Example -->
		<div class="col-xl-3 col-md-6 mb-4">
			<div class="card border-left-primary shadow h-100 py-2">
				<div class="card-body">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div
								class="text-xs font-weight-bold text-primary text-uppercase mb-1">
								오늘 방문자수</div>
							<div class="h5 mb-0 font-weight-bold text-gray-800">1명</div>
						</div>
						<div class="col-auto">
							<i class="fas fa-calendar fa-2x text-gray-300"></i>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Earnings (Monthly) Card Example -->
		<div class="col-xl-3 col-md-6 mb-4">
			<div class="card border-left-success shadow h-100 py-2">
				<div class="card-body">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div
								class="text-xs font-weight-bold text-success text-uppercase mb-1">
								이번달 방문자수</div>
							<div class="h5 mb-0 font-weight-bold text-gray-800">215,000명</div>
						</div>
						<div class="col-auto">
							<i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Earnings (Monthly) Card Example -->
		<div class="col-xl-3 col-md-6 mb-4">
			<div class="card border-left-info shadow h-100 py-2">
				<div class="card-body">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div
								class="text-xs font-weight-bold text-info text-uppercase mb-1">목표치
							</div>
							<div class="row no-gutters align-items-center">
								<div class="col-auto">
									<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">50%</div>
								</div>
								<div class="col">
									<div class="progress progress-sm mr-2">
										<div class="progress-bar bg-info" role="progressbar"
											style="width: 50%" aria-valuenow="50" aria-valuemin="0"
											aria-valuemax="100"></div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-auto">
							<i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Pending Requests Card Example -->
		<div class="col-xl-3 col-md-6 mb-4">
			<div class="card border-left-warning shadow h-100 py-2">
				<div class="card-body">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div
								class="text-xs font-weight-bold text-warning text-uppercase mb-1">
								오늘 1:1문의건수</div>
							<div class="h5 mb-0 font-weight-bold text-gray-800">18</div>
						</div>
						<div class="col-auto">
							<i class="fas fa-comments fa-2x text-gray-300"></i>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Content Row -->

	<div class="row">

		<!-- Area Chart -->
		<div class="col-xl-8 col-lg-7">
			<div class="card shadow mb-4">
				<!-- Card Header - Dropdown -->
				<div
					class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
					<h6 class="m-0 font-weight-bold text-primary">고객 게시판-상위 5개(비로그인 상태는 서비스를 이용하실수 없습니다.)</h6>
					<div class="dropdown no-arrow">
						<a class="dropdown-toggle" href="#" role="button"
							id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i
							class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
						</a>
						<div
							class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
							aria-labelledby="dropdownMenuLink">
							<div class="dropdown-header">Dropdown Header:</div>
							<a class="dropdown-item" href="#">Action</a> <a
								class="dropdown-item" href="#">Another action</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Something else here</a>
						</div>
					</div>
				</div>
				<!-- Card Body -->
				<div class="card-body">
					<div class="chart-area">
						<%-- <canvas id="myAreaChart"></canvas> --%>
						<c:if test="${member != null}">
						<table class="table table-bordered" >
					<!-- 	id="dataTable" width="100%"
							cellspacing="0" -->
							<thead>
								<tr>
									<th class="text-center">번호</th>
									<th class="text-center">주제</th>
									<th class="text-center">작성자</th>
									<th class="text-center">조회수</th>
									<th class="text-center">작성일자</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${HomeBoardList}" var="list">
									<tr>
										<td class="text-center"><c:out value="${list.board_no}" /></td>
										<td><a href="/board/read?board_no=${list.board_no}"><c:out
													value="${list.board_title}" /></a><strong>(${list.board_reply_hit})</strong></td>
										<td class="text-center"><c:out
												value="${list.board_writer}" /></td>
										<td class="text-center"><c:out
												value="${list.board_count}" /></td>
										<td class="text-center"><c:out
												value="${list.board_regdate}" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						</c:if>
					</div>
				</div>
			</div>
		</div>

		<!-- Pie Chart -->
		<div class="col-xl-4 col-lg-5">
			<div class="card shadow mb-4">
				<!-- Card Header - Dropdown -->
				<div
					class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
					<h6 class="m-0 font-weight-bold text-primary">1:1 문의 리스트</h6>
					<div class="dropdown no-arrow">
						<a class="dropdown-toggle" href="#" role="button"
							id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i
							class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
						</a>
						<div
							class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
							aria-labelledby="dropdownMenuLink">
							<div class="dropdown-header">Dropdown Header:</div>
							<a class="dropdown-item" href="#">Action</a> <a
								class="dropdown-item" href="#">Another action</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Something else here</a>
						</div>
					</div>
				</div>
				<!-- Card Body -->
				<div class="card-body">
					<div class="chart-pie pt-4 pb-2">
						<%-- <canvas id="myPieChart"></canvas> --%>
					</div>
					<div class="mt-4 text-center small">
						<span class="mr-2"> <i class="fas fa-circle text-primary"></i>
						
						</span> <span class="mr-2"> <i class="fas fa-circle text-success"></i>
							
						</span> <span class="mr-2"> <i class="fas fa-circle text-info"></i>
							
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Content Row -->
	<div class="row">

		<!-- Area Chart -->
		<div class="col-xl-8 col-lg-7">
			<div class="card shadow mb-4">
				<!-- Card Header - Dropdown -->
				<div
					class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
					<h6 class="m-0 font-weight-bold text-primary">공지사항 -상위 5개(비로그인 상태는 서비스를 이용하실수 없습니다.)</h6>
					<div class="dropdown no-arrow">
						<a class="dropdown-toggle" href="#" role="button"
							id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i
							class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
						</a>
						<div
							class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
							aria-labelledby="dropdownMenuLink">
							<div class="dropdown-header">Dropdown Header:</div>
							<a class="dropdown-item" href="#">Action</a> <a
								class="dropdown-item" href="#">Another action</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Something else here</a>
						</div>
					</div>
				</div>
				<!-- Card Body -->
				<div class="card-body">
					<div class="chart-area">
						<%-- <canvas id="myAreaChart"></canvas> --%>
						<c:if test="${member != null}">
						<table class="table table-bordered" >
					<!-- 	id="dataTable" width="100%"
							cellspacing="0" -->
							<thead>
								<tr>
									<th class="text-center">번호</th>
									<th class="text-center">주제</th>
									<th class="text-center">작성자</th>
									<th class="text-center">조회수</th>
									<th class="text-center">작성일자</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${HomeNoticeList}" var="nlist">
									<tr>
										<td class="text-center"><c:out value="${nlist.notice_no}" /></td>
										<td><a href="/notice/read?notice_no=${nlist.notice_no}"><c:out
													value="${nlist.notice_title}" /></a><strong></strong></td>
										<td class="text-center"><c:out
												value="${nlist.notice_writer}" /></td>
										<td class="text-center"><c:out
												value="${nlist.notice_count}" /></td>
										<td class="text-center"><c:out
												value="${nlist.notice_regdate}" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						</c:if>
					</div>
				</div>
			</div>
		</div>

		<!-- Pie Chart -->
		<div class="col-xl-4 col-lg-5">
			<div class="card shadow mb-4">
				<!-- Card Header - Dropdown -->
				<div
					class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
					<h6 class="m-0 font-weight-bold text-primary">멤버 리스트</h6>
					<div class="dropdown no-arrow">
						<a class="dropdown-toggle" href="#" role="button"
							id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i
							class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
						</a>
						<div
							class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
							aria-labelledby="dropdownMenuLink">
							<div class="dropdown-header">Dropdown Header:</div>
							<a class="dropdown-item" href="#">Action</a> <a
								class="dropdown-item" href="#">Another action</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Something else here</a>
						</div>
					</div>
				</div>
				<!-- Card Body -->
				<div class="card-body">
					<div class="chart-pie pt-4 pb-2">
						<%-- <canvas id="myPieChart"></canvas> --%>
					</div>
					<div class="mt-4 text-center small">
						<span class="mr-2"> <i class="fas fa-circle text-primary"></i>
						
						</span> <span class="mr-2"> <i class="fas fa-circle text-success"></i>
							
						</span> <span class="mr-2"> <i class="fas fa-circle text-info"></i>
							
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>
<!-- /.container-fluid -->
</div>
<!-- End of Main Content -->

<%@include file="/WEB-INF/views/includes/footer.jsp"%>

<!-- Page level plugins -->
<script src="/resources/vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="/resources/js/demo/chart-area-demo.js"></script>
<script src="/resources/js/demo/chart-pie-demo.js"></script>