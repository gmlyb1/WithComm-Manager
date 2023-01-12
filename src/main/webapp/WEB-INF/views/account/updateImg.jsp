<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script type="text/javascript">
	$(document).ready(function() {
		var msg = "${msg}";
		if (msg != "") {
			alert(msg);
		}
	});
</script>
	<%@include file="../includes/header.jsp"%>

<img src="/image/${login.me_image}"
	style="max-width: 50%; height: auto;">
<br />
<div class="card">
	<form action="/account/updateImg" method="post"
		enctype="multipart/form-data">
		<input type="file" name="file"> <input type="hidden"
			name="me_id" id="me_id" value="${login.me_id}">
		<button type="submit" class="btn btn-primary">사진변경</button>
	</form>


	<%@include file="../includes/footer.jsp"%>