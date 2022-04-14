<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	var msg = "${msg}";
	if( msg != "") {
		alert(msg);
	}
});
</script>
				<%@include file="../includes/header.jsp" %>

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Tables</h1>
                    <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                        For more information about DataTables, please visit the <a target="_blank"
                            href="https://datatables.net">official DataTables documentation</a>.</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th class="text-center">번호</th>
                                            <th class="text-center">제목</th>
                                            <th class="text-center">내용</th>
                                            <th class="text-center">작성자</th>
                                            <th class="text-center">등록일</th>
                                        </tr>
									<c:forEach var="list" items="${boardList}">
										<tr>
											<td class="text-center">${list.board_idx}</td>
											<td class="text-center">${list.board_title}</td>
											<td class="text-center">${list.board_content}</td>
											<td class="text-center">${list.board_writer}</td>
											<td class="text-center">${list.board_regdate}</td>
										</tr>
									</c:forEach>
                                    </thead>
                                    </tbody>
                                </table>
                                <a href="/board/create" class="btn btn-primary">글쓰기</a>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->
				<%@include file="../includes/footer.jsp" %>
            