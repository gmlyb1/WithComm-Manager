<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript">
//결제 대기 상태 모달을 표시하는 예시 (버튼 클릭 시)
$('#showaprvSttsModal').on('click', function () {
    $('#aprvSttsModal').modal('show');
});
</script>

<!-- 결제 대기 상태 모달 -->
<div class="modal fade" id="aprvSttsModal" tabindex="-1" role="dialog" aria-labelledby="aprvSttsModallabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header bg-primary text-white">
                <h5 class="modal-title" id="aprvSttsModallabel">📊 결제 대기 상태</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="alert alert-info" role="alert">
                    현재 다음 항목들의 결제 상태를 확인해주세요.<br> 필요에 따라 조치를 취해주시기 바랍니다.
                </div>
                <ul class="list-group">
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        <strong>회원 관리</strong>
                        <span class="badge badge-success badge-pill"><a href="/account/manage">${memberRegisterAprvSttsCnt.memberAprvCnt} 건</a></span>
                   </li>
                   <li class="list-group-item d-flex justify-content-between align-items-center">
                       <strong>1:1 문의 관리</strong>
                       <span class="badge badge-success badge-pill"><a href="/inquiry/list">${inquiryAprvSttsCnt.inquiryAprvCnt} 건</a></span>
                   </li>
                   <li class="list-group-item d-flex justify-content-between align-items-center">
                       <strong>메일 관리</strong>
                       <span class="badge badge-success badge-pill"><a href="/mail/recevMail">${mailAprvSttsCnt.mailAprvCnt} 건</a></span>
                   </li>
                   <li class="list-group-item d-flex justify-content-between align-items-center">
                       <strong>접속자 관리</strong>
                       <span class="badge badge-success badge-pill"><a href="/visit/list">${visitAprvSttsCnt.visitAprvCnt} 건</a></span>
                    </li>
                </ul>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
            </div>
        </div>
    </div>
</div>
<!-- End of 결제 대기 상태 모달 -->