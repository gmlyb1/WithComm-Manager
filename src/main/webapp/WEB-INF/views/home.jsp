<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page session="true"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<%@include file="/WEB-INF/views/includes/header.jsp"%>

<div class="container-fluid">

	<div class="d-sm-flex align-items-center justify-content-between mb-4">
	    <h1 class="h3 mb-0 text-gray-800"><strong>대쉬보드</strong></h1>
	    <!-- <a href="#" class="d-none d-sm-inline-block btn btn-lg btn-primary shadow-sm">현재 시각
	        <i class="fas fa-clock fa-lg text-white-50"></i> <span id="currentTime"></span>
	    </a> -->
	</div>

	<div class="row">
		<div class="col-xl-3 col-md-6 mb-4">
			<div class="card border-left-primary shadow h-100 py-2">
				<div class="card-body">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
								금일 자유게시판 글 수
							</div>
							
							<div class="h5 mb-0 font-weight-bold text-gray-800">${boardCnt.dayCnt}개</div>
						</div>
						<div class="col-auto">
							<i class="fas fa-calendar fa-3x text-gray-300"></i>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="col-xl-3 col-md-6 mb-4">
			<div class="card border-left-success shadow h-100 py-2">
				<div class="card-body">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div
								class="text-xs font-weight-bold text-success text-uppercase mb-1">
								금월 자유게시판 글 수</div>
							<div class="h5 mb-0 font-weight-bold text-gray-800">${boardCnt.monthCnt}개</div>
						</div>
						<div class="col-auto">
							<i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="col-xl-3 col-md-6 mb-4">
			<div class="card border-left-success shadow h-100 py-2">
				<div class="card-body">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div
								class="text-xs font-weight-bold text-success text-uppercase mb-1">
								금년 자유게시판 글 수</div>
							<div class="h5 mb-0 font-weight-bold text-gray-800">${boardCnt.yearCnt}개</div>
						</div>
						<div class="col-auto">
							<i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="col-xl-3 col-md-6 mb-4">
			<div class="card border-left-warning shadow h-100 py-2">
				<div class="card-body">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div
								class="text-xs font-weight-bold text-warning text-uppercase mb-1">
								전체 게시판 글 수</div>
							<div class="h5 mb-0 font-weight-bold text-gray-800">${boardCnt.allCnt}개</div>
						</div>
						<div class="col-auto">
							<i class="fas fa-comments fa-2x text-gray-300"></i>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="row">
		<div class="col-xl-8 col-lg-7">
			<div class="card shadow mb-4">
				<div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
					<h6 class="m-0 font-weight-bold text-primary">공지사항 -상위 6개</h6>
					<div class="dropdown no-arrow">
						<a class="btn btn-success" href="/notice/list">더보기</a>
					</div>
				</div>
				<div class="card-body">
					<div class="chart-area">
						<table class="table table-bordered">
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
										<td class="text-center">
											<c:out value="${nlist.notice_no}" />
										</td>
										<td>
											<a href="/notice/read?notice_no=${nlist.notice_no}">
												<c:out value="${nlist.notice_title}" />
											</a>
										</td>
										<td class="text-center">
											<c:out value="${nlist.notice_writer}" />
										</td>
										<td class="text-center">
											<c:out value="${nlist.notice_count}" />
										</td>
										<td class="text-center">
											<fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${nlist.notice_regdate}" />
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<div class="col-xl-4 col-lg-5">
			<div class="card shadow mb-4">
				<div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
					<h6 class="m-0 font-weight-bold text-primary">멤버 리스트</h6>
					<div class="dropdown no-arrow">
						<a class="btn btn-success" href="/account/manage">더보기</a>
					</div>
				</div>

				<div class="card-body">
					<div class="chart-area">
						<%-- <canvas id="myAreaChart"></canvas> --%>
						<c:if test="${member != null}">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th class="text-center">아이디</th>
										<th class="text-center">닉네임</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${HomeMemberList}" var="HomeMemberList">
										<tr>
											<td class="text-center"><c:out value="${HomeMemberList.me_email}" /></td>
											<td class="text-center"><c:out value="${HomeMemberList.me_name}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:if>
					</div>
				</div>

			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-xl-8 col-lg-7">
			<div class="card shadow mb-4">
				<div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
					<h6 class="m-0 font-weight-bold text-primary">자유 게시판 -상위6개</h6>
						<a class="btn btn-success" href="/member/list">더보기</a>
				</div>
				<div class="card-body">
					<div class="chart-area">
						<table class="table table-bordered">
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
										<td>
											<a href="/board/read?board_no=${list.board_no}">
												<c:out value="${list.board_title}" />
											</a>
										</td>
										<td class="text-center">
											<c:out value="${list.board_writer}" />
										</td>
										<td class="text-center">
											<c:out value="${list.board_count}" />
										</td>
										<td class="text-center">
											<fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${list.board_regdate}" />
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<div class="col-xl-4 col-lg-5">
			<div class="card shadow mb-4">
				<div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
					<h6 class="m-0 font-weight-bold text-primary">관리자 리스트</h6>
					<div class="dropdown no-arrow">
						<a class="btn btn-success" href="#">더보기</a>
					</div>
				</div>

				<div class="card-body">
					<div class="chart-area">
						<c:if test="${member != null}">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th class="text-center">아이디</th>
										<th class="text-center">닉네임</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${HomeGmList}" var="HomeGmList">
										<tr>
											<td class="text-center"><c:out value="${HomeGmList.me_email}" /></td>
											<td class="text-center"><c:out value="${HomeGmList.me_name}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>

<%@include file="/WEB-INF/views/includes/footer.jsp"%>
