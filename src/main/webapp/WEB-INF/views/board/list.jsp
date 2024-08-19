<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		// new 스티커 처리
		var currentTime = new Date().getTime();
		
		$("table tr").each(function() {
			var regdate = new Date($(this).data("regdate")).getTime();
			var isNewPost = (currentTime - regdate < 24 * 60 * 60 * 1000);
			
			if(isNewPost) {
				$(this).find("td:eq(1)").append('<span class="badge badge-success">New</span>');
				
				setTimeout(function() {
					$sticker.find(".badge").remove();
				},24 * 60 * 60 * 1000);
			}
		});
		
		/* var chkObj = document.getElementByName("RowCheck");
		var rowCnt = chkObj.length;
		
		$("input[name = 'allCheck']").click(function() {
			var chk_listArr = $("input[name='RowCheck']");
			
			for(var i=0; i<chk_listArr; i++) {
				chk_listArr[i].checked = this.checked;	
			}
		});
		
		$("input[name='RowCheck']").click(function() {
			if($("input[name='RowCheck']:checked").length == rowCnt) {
				$("input[name='allCheck']")[0].checked = true;
			} else {
				$("input[name='allCheck']")[0].checked = false;
			}
		});
		
		function deleteValue() {
			var url = "/board/delete";
			var valueArr = new Array();
			var list = $("input[name='RowCheck']");
			
			for(var i = 0; i < list.length; i++) {
				if(list[i].checked) {
					valueArr.push(list[i].value);
				}
			}
			
			if(valueArr.length == 0) {
				alert("선택된 게시글이 없습니다.");
			}else {
				var chk = confirm("정말 삭제 하시겠습니까?");
				$.ajax({
					url : url,
					type : 'POST',
					tranditional : true,
					data : {
						valueArr : valueArr
					},
					success : function(jdata) {
						if(jdata = 1) {
							alert("게시글의 삭제를 완료하였습니다.");
							location.replace("/board/list");
						}else {
							alert("게시글 삭제중 오류가 발생했습니다.");
						}
					}
				});				
			}
		} */
		//끝
	});

</script>


<%@include file="../includes/header.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">게시판 관리</h1>
	
	<!-- Search Form -->
	<div class="card mb-4">
		<div class="card-header">
			<h6 class="m-0 font-weight-bold text-primary">검색 조건</h6>
		</div>
		<div class="card-body">
			<form id="searchForm" action="/board/list" method="GET">
				<div class="form-row">
					<div class="col-md-4 mb-3">
						<label for="board_writer">작성자</label>
						<input type="text" class="form-control" id="board_writer" name="board_writer" placeholder="작성자" value="${param.board_writer}">
					</div>
					<div class="col-md-4 mb-3">
						<label for="board_title">제목</label>
						<input type="text" class="form-control" id="board_title" name="board_title" placeholder="제목" value="${param.board_title}">
					</div>
				 	<div class="col-md-4 mb-3">
			            <label for="startDate">시작 날짜</label>
			            <input type="date" class="form-control" id="startDate" name="startDate" value="${param.startDate}">
			        </div>
			        <div class="col-md-4 mb-3">
			            <label for="endDate">종료 날짜</label>
			            <input type="date" class="form-control" id="endDate" name="endDate" value="${param.endDate}">
			        </div>
				</div>
				<button type="submit" id="searchBtn" class="button-container btn btn-primary">조회</button>
			</form>
		</div>
	</div>
	
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
					<thead>
						<tr>
							<th class="text-center">번호</th>
							<th class="text-center">제목</th>
							<th class="text-center">작성자</th>
							<th class="text-center">등록일자</th>
							<th class="text-center">수정일자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${boardList}" var="list">
							<tr>
								<td class="text-center">${list.board_no}</td>
								<td class="text-center">${list.board_title}</td>
								<td class="text-center">${list.board_writer}</td>
								<td class="text-center">
									<fmt:formatDate value="${list.board_regdate}" pattern="yyyy-MM-dd" />
								</td>
								<td class="text-center">
									<fmt:formatDate value="${list.board_updateDate}" pattern="yyyy-MM-dd" />
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<%@include file="../includes/footer.jsp"%>
