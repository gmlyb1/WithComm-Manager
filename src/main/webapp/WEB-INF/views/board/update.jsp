<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

		$(".cancel_btn").on("click", function() {
			event.preventDefault();
			location.href = "/board/list";
		})
	})

	function _onSubmit() {
		if (!confirm("수정 하시겠습니까?")) {
			return false;
		}
	}
</script>

<%@include file="../includes/header.jsp"%>

<div class="row" style="margin-bottom: 20px; margin-left: 1px;">
	<div class="col-lg-12">
		<h1 class="page-header">글수정</h1>
	</div>
</div>

<div class="panel" style="margin-left: 1px;">
	<div id="contAreaBox">
		<div class="panel">
			<div class="panel-body">
				<form action="/board/update" role="form" method="post"
					name="updateForm" onsubmit="return _onSubmit();">
					<input type="hidden" name="board_no" value="${update.board_no}"
						readonly="readonly" />
					<div class="table-responsive" style="text-align: center;">
						<table id="datatable-scroller"
							class="table table-bordered tbl_Form">
							<caption></caption>
							<colgroup>
								<col width="250px" />
								<col />
							</colgroup>
							<tbody>
								<tr>
									<td class="form-inline"><label for="board_writer">작성자:</label><input
										type="text" id="board_writer" name="board_writer"
										style="width: 200px" value="${update.board_writer}" disabled />
									</td>
								</tr>
								<tr>
									<td class="form-inline"><label for="board_title">제목:</label><input
										type="text" id="board_title" name="board_title"
										style="width: 840px" value="${update.board_title}" /></td>
								</tr>
								<tr>
									<td class="form-inline"><label for="board_content">내용:</label>
										<textarea id="board_content" name="board_content" cols="130"
											rows="20"><c:out value="${update.board_content}" /></textarea>
								</tr>
							</tbody>
						</table>
					</div>
					</tbody>
					</table>
			</div>
			<div style="margin-left: 1px;">
				<button type="submit" class="btn btn-primary">수정</button>
				<a href="/board/list" class="btn btn-danger">취소</a>
			</div>
			</form>
		</div>
	</div>
</div>
</div>

<%@include file="../includes/footer.jsp"%>