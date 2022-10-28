<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<%@include file="../includes/header.jsp"%>

<button type="button" class="btn btn-dark ml-3"
	onclick="location.href='/board/mypage?select=log&memberId=${memberId}'">활동기록</button>
<button type="button" class="btn btn-dark"
	onclick="location.href='/board/mypage?select=write&memberId=${memberId}'">작성한
	게시글</button>
<button type="button" class="btn btn-dark"
	onclick="location.href='/board/mypage?select=reply&memberId=${memberId}'">작성한
	댓글</button>
<button type="button" class="btn btn-dark"
	onclick="location.href='/board/mypage?select=scrap&memberId=${memberId}'">스크랩</button>


<c:forEach items="${log}" var="log">


	<div class="col-sm-9">
		<div class="card shadow mt-2 mb-1">
			<!--   <i class="fa fa-comment-o"></i>    -->
			<div class="row ml-1">

				<span> <span style="font-size: 20px"> <c:if
							test="${log.categori == 1 }">
							<i class="fas fa-edit mr-2" style="color: blue"></i>
            	#${log.bno} 게시글을 작성 했습니다.
					</c:if> <c:if test="${log.categori == 2 }">
							<i class="far fa-thumbs-up mr-2" style="color: red"></i>
            	#${log.bno} &nbsp; 게시글을 추천 했습니다.
					</c:if> <c:if test="${log.categori == 3 }">
							<i class="far fa-thumbs-down mr-2" style="color: dark"></i>
            	#${log.bno} &nbsp; 게시글을 반대 했습니다.
					</c:if> <c:if test="${log.categori == 4 }">
							<i class="fa fa-bolt mr-3" style="color: yellow"></i>
            	#${log.bno} &nbsp; 게시글을 DEV 했습니다.
					</c:if> <c:if test="${log.categori == 5 }">
							<i class="fas fa-check-double mr-2" style="color: green"></i>
            	#${log.bno} &nbsp; 게시글을 스크랩 했습니다.
					</c:if> <c:if test="${log.categori == 6 }">
							<i class="fa fa-comment-o mr-2" style="color: blue"></i>
            	#${log.bno} &nbsp;게시글에 #${log.rno} 댓글을 작성 했습니다.
					</c:if> <c:if test="${log.categori == 7 }">
							<i class="far fa-thumbs-up mr-2" style="color: red"></i>
            	#${log.bno} &nbsp;게시글에 #${log.rno} 댓글을 추천 했습니다.
					</c:if> <c:if test="${log.categori == 8 }">
							<i class="far fa-thumbs-down mr-2" style="color: dark"></i>
            	#${log.bno} &nbsp;게시글에 #${log.rno} 댓글을 반대 했습니다.
					</c:if> <c:if test="${log.categori == 9 }">
							<i class="fa fa-bolt mr-3" style="color: yellow"></i>
            	#${log.bno} &nbsp;게시글에 #${log.rno} 댓글을 DEV 했습니다.
					</c:if> <c:if test="${log.categori == 10 }">
							<i class="fa fa-bolt mr-3" style="color: red"></i>
            	#${log.bno} &nbsp;질문글에 #${log.rno} 댓글 답변자 ${log.questionId}님을 채택 했습니다.
					</c:if> <c:if test="${log.categori == 11 }">
							<i class="fa fa-bolt mr-3" style="color: red"></i>
            	#${log.bno} &nbsp;질문글에 #${log.rno} 댓글이 채택 되었습니다.
					</c:if>



				</span> 
				<span style="font-size: 13px"><fmt:formatDate
							value="${log.logdate}" pattern="YY-MM-dd  hh:mm:ss" /> </span>
				</span>
			</div>
			<div class="ml-5">
				<h5>
					<a href="/board/read?board_no=${log.board_no}&bgno=${log.boardVO.bgno}">${log.boardVO.board_title}</a>

					<span style="font-size: 15px"> ${log.boardVO.board_writer} </span>
				</h5>
			</div>

		</div>
	</div>
</c:forEach>
<%@include file="../includes/footer.jsp"%>