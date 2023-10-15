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
	<h1 class="h3 mb-2 text-gray-800">자유 게시판</h1>
	<p class="mb-4">
		<a><strong>저희 소프트홈페이지의 고객 게시판을 찾아 주셔서 감사합니다.</strong></a>
	</p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">고객 게시판 리스트</h6>
			<br>
			<c:if test="${member == null}">
				<span style="color: red"><strong> 현재 페이지의 글쓰기,수정,삭제는
						회원만 이용 가능합니다.</strong></span>
			</c:if>

			<c:if test="${member != null }">
				<a href="/board/mypage" class="btn btn-success">마이페이지로 이동</a>
			</c:if>
			<form>
				<input type="button" class="btn btn-warning" value="페이지 새로 고침"
					onClick="window.location.reload()">
			</form>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<!-- <th><input class="form-check-input" id="allCheck" type="checkbox" name="allCheck"/></th> -->
							<th class="text-center">번호</th>
							<th class="text-center">주제</th>
							<th class="text-center">작성자</th>
							<th class="text-center">조회수</th>
							<th class="text-center">작성일자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${boardList}" var="list">
								<%-- <td><input name="RowCheck" type="checkbox" value="${list.board_no}"/></td> --%>
							<tr data-regdate = "${list.board_regdate}">
								<td class="text-center"><c:out value="${list.board_no}" /></td>
								<td><a href="/board/read?board_no=${list.board_no}"><c:out
											value="${list.board_title}" /></a>
								</td>
								<td class="text-center"><c:out value="${list.board_writer}" /></td>
								<td class="text-center"><c:out value="${list.board_count}" /></td>
								<td class="text-center"><fmt:formatDate pattern="yyyy-MM-dd hh:mm"
										value="${list.board_regdate}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<c:if test="${member != null}">
					<button type="button" onclick="location.href='/board/create';" class="btn btn-success">글쓰기</button>
					<input type="button" value="선택삭제" class="btn btn-outline-info" onclick="deleteValue();"/>	
				</c:if>
			</div>
		</div>
	</div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->
<%@include file="../includes/footer.jsp"%>
