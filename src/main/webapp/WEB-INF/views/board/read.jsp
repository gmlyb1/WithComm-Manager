<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var formObj = $("form[name='readForm']");
		
		//수정
		$('.update_btn').on("click",function() {
			formObj.attr("action", "/board/update");
			formObj.attr("method", "get");
			formObj.submit();
		})
		
		//삭제
		$('.delete_btn').on("click",function() {
			formObj.attr("action", "/board/delete");
			formObj.attr("method", "post");
			formObj.submit();
		})
		
		//취소
		$(".list_btn").on("click",function() {
			
			location.href= "/board/list";
		})
	})
</script>




<div class="row" style="margin-bottom:20px; margin-left:1px;">
<div class="col-lg-12">
<h1 class="page-header">상세 페이지</h1>
</div>
</div>

<div class="panel" style="margin-left:1px;">
<div id="contAreaBox">
<div class="panel">
<div class="panel-body">
<form name="readForm" role="form" method="post">
	<input type="hidden" id="board_no" name="board_no" value=${read.board_no}"/>
<div class="table-responsive" style="text-align:center;">
<table id="datatable-scroller"
	class="table table-bordered tbl_Form">
	<caption></caption>
	<colgroup>
		<col width="250px" />
		<col width=""/>
	</colgroup>
	<tbody>
		<tr>
			<th class="active">작성자</th>
			<td>
					${read.board_writer}
			</td>
		</tr>
		<tr>
			<th class="active">제목</th>
			<td>
					${read.board_title}
			</td>
		</tr>
		<tr>
			<th class="active">내용</th>
			<td>
					${read.board_content}
			</td>
		</tr>
	</tbody>
</table>
</div>
<div style="margin-left:1px;">
	<c:if test="${member != null}">
	<button type="submit" class="btn btn-success">수정</button>
	<button type="submit" class="btn btn-default">삭제</button>
	</c:if>
	<button type="button" onclick="location.href='/board/list';" class="btn btn-primary">목록</button>
</div>
</form>
</div>
</div>
</div>
</div>


<%@include file="../includes/footer.jsp"%>