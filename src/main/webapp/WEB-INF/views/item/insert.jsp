<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>

<script type="text/javascript">
	$(document).ready(function(){
		console.log('ready');
	
		optionAdd();
	});
	
	function optionAdd() {
		console.log('optionadd');
		var optionIndex = 1;
		//$("#fileIndex").append("<div><input type='file' style='float:left;' name='file_"+(fileIndex++)+"'>"+"<button type='button' style='float:right;' id='fileAddBtn'>"+"추가"+"</button></div>");
		$("#optionAdd_btn")
				.on(
						"click",
						function() {
							console.log('옵션추가');
							$("#optionIndex")
									.append(
											"  <div class='form-group'><input placeholder='옵션' class='form-control input-lg' type='text' style='float:left;' name='item_option"
													
													+ "' id='item_option'>"
													+ "<input type='number' name='item_vol' id='item_vol' placeholder='수량'>"
													+ "<button type='button' style='float:right;' id='optionDelBtn' class='btn btn-danger'>"
													+ "삭제" + "</button></div>"

									);

						});

		$(document).on("click", "#optionDelBtn", function() {
			$(this).parent().remove();

		});

	};

	function fnSubmit() {

		var email_rule = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		// var tel_rule = /^\d{2,3}-\d{3,4}-\d{4}$/; 전화번호용

		if ($("#item_name").val() == null || $("#item_name").val() == "") {
			alert("상품명을 입력해주세요.");
			$("#item_name").focus();

			return false;
		}

		if ($("#item_price").val() == null || $("#item_price").val() == "") {
			alert("상품가격를 입력해주세요.");
			$("#item_price").focus();

			return false;
		}

		if ($("#item_size").val() == null || $("#item_size").val() == "") {
			alert("상품사이즈를 입력해주세요.");
			$("#item_size").focus();

			return false;
		}

		if ($("#item_color").val() == null || $("#item_color").val() == "") {
			alert("상품색상을 입력해주세요.");
			$("#item_color").focus();

			return false;
		}

		if ($("#item_vol").val() == null || $("#item_vol").val() == "") {
			alert("상품수량을 입력해주세요.");
			$("#item_vol").focus();

			return false;
		}

		if ($("#item_content").val() == null || $("#item_content").val() == "") {
			alert("상품내용을 입력해주세요.");
			$("#item_content").focus();

			return false;
		}

		if ($("#item_subcontent").val() == null
				|| $("#item_subcontent").val() == "") {
			alert("상품설명을 입력해주세요.");
			$("#item_subcontent").focus();

			return false;
		}

		if ($("#item_model").val() == null || $("#item_model").val() == "") {
			alert("모델정보를 입력해주세요.");
			$("#item_model").focus();

			return false;
		}

		if ($("#item_option").val() == null || $("#item_option").val() == "") {
			alert("상품옵션을 입력해주세요.");
			$("#item_option").focus();

			return false;
		}

		if ($("#itemMainImg").val() == null || $("#itemMainImg").val() == "") {
			alert("상품썸네일사진 등록해주세요.");
			$("#itemMainImg").focus();

			return false;
		}
		
		if ($("#itemSubImg").val() == null || $("#itemSubImg").val() == "") {
			alert("상품썸네일보조사진 등록해주세요.");
			$("#itemSubImg").focus();

			return false;
		}

		if (confirm("등록하시겠습니까?")) {

			$("#itemInsertForm").submit();

			return false;
		}
	}
	

</script>



 <form action="/item/insert" method="post"
							name="itemInsertForm" id="itemInsertForm"
							enctype="multipart/form-data">

							<div class="tab-content">
								<!-- 상품등록 -->
								<div class="tab-pane active" id="itemInsert_1">
									<div class="form-group" style="">

										<h4>대분류</h4>
										<select class="form-control" name="item_catemain"
											id="item_catemain" title="상품 대분류">
											<option value="item">일반상품</option>
											<option value="mainpage">메인페이지</option>
											<option value="popularitem">인기상품</option>
										</select>
										<h4>소분류</h4>
										<select class="form-control" name="item_catesub"
											id="item_catesub" title="상품 소분류">
											<option value="jumper">Jumper</option>
											<option value="coat">Coat</option>
											<option value="jacket">Jacket</option>
											<option value="padding">Padding</option>
											<option value="shirts">Shirts</option>
			
										</select>
									</div>
									<hr class="divider-w mt-10 mb-20">
									<div class="form-group">
										<h4>상품명</h4>
										<input class="form-control input-lg" type="text"
											placeholder="상품명" name="item_name" id="item_name" />
									</div>
									<hr class="divider-w mt-10 mb-20">
									<div class="form-group">
										<h4>판매가</h4>
										<input class="form-control input-lg" type="number"
											placeholder="판매가 / 단위 : 원" name="item_price" id="item_price" />
									</div>
									<hr class="divider-w mt-10 mb-20">

									<div class="form-group">
										<h4>사이즈</h4>
										<input class="form-control input-lg" type="text"
											placeholder="사이즈" name="item_size" id="item_size" />
									</div>
									<hr class="divider-w mt-10 mb-20">
									<div class="form-group">
										<h4>색상</h4>
										<input class="form-control input-lg" type="text"
											placeholder="색상" name="item_color" id="item_color" />
									</div>
									<hr class="divider-w mt-10 mb-20">

									<div class="form-group">
										<h4>상품설명</h4>
										<input class="form-control input-lg" type="text"
											placeholder="상품설명" name="item_subcontent"
											id="item_subcontent" />
									</div>
									<hr class="divider-w mt-10 mb-20">

									<div class="form-group">
										<h4>모델정보</h4>
										<input class="form-control input-lg" type="text"
											placeholder="모델정보" name="item_model" id="item_model" />
									</div>
									<hr class="divider-w mt-10 mb-20">

									<!-- 상품내용 에디터 -->

									<div class="form-group">
										<h4>상품내용</h4>
										<textarea class="form-control input-lg"
											placeholder="내용을 입력하세요" name="item_content" id="item_content">
											</textarea>


								</div>

								<!-- 상품등록 끝-->


								<!--  상품옵션 -->
								<div class="tab-pane" id="itemInsert_2">


									<button id="optionAdd_btn" class="btn btn-primary mb-3"
										type="button">옵션추가</button>

									<div id="optionIndex"></div>
									<br />
									<div class="form-group mt-3">
										<input class="form-control input-lg " type="text"
											placeholder="최소 1개의 옵션이 필요합니다. ex) 100 , red /// 95 , blue "
											readonly />
									</div>

								</div>
								<!--  상품옵션 끝 -->



								<!--  상품이미지 -->
								<div class="tab-pane" id="itemInsert_3">

									<div class="form-group">
										<h4>메인이미지 ( 썸네일 )</h4>
										<input class="form-control input-lg" type="file"
											name="itemMainImg" id="itemMainImg" />
									</div>
									
									<div class="form-group">
										<h4>서브이미지 ( 썸네일에 마우스 올릴시 )</h4>
										<input class="form-control input-lg" type="file"
											name="itemSubImg" id="itemSubImg" />
									</div>
									
								<c:if test="${member != null}">
									<button class="btn btn-success" type="button"
										onclick="fnSubmit(); return false;">상품등록</button>
								</c:if>
									
									<button type="button" class="btn btn-danger"
								onclick="location.href='/home'">메인페이지로 가기</button>
								</div>
						</form>
						<!--  상품이미지 끝 -->
					</div>




<%@include file="../includes/footer.jsp"%>