<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">
			메인 게시판

			<button id='regBtn' type="button" class="btn btn-primary  pull-right">새로운
				글 등록</button>
		</h1>

	</div>
	<!-- /.col-lg-12 -->
</div>
<c:forEach items="${showMap}" var="map">

	<!-- /.col-lg-4 -->
	<div class="col-lg-4">
		<div class="panel panel-default">
			<div class="panel-heading">
				<c:out value="${map.name} " />
			</div>
			<div class="panel-body"></div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-4 -->

</c:forEach>

<!--  페이지 처리 -->
<div class='pull-right'>
	<ul class="pagination">

		<form id='actionForm' action="/main/showMap" method='get'>
			<input type='hidden' name='pageNum'
				value='${pageMaker.mapCri.pageNum}'> <input type='hidden'
				name='amount' value='${pageMaker.mapCri.amount}'>

		</form>


		<c:if test="${pageMaker.prev}">
			<li class="paginate_button previous"><a
				href="${pageMaker.startPage -1}">Previous</a></li>
		</c:if>

		<c:forEach var="num" begin="${pageMaker.startPage}"
			end="${pageMaker.endPage}">
			<li class="paginate_button ${pagemaker.mapCri.pageNum == num ? "active" : " " } "><a
				href="${num}">${num}</a></li>

		</c:forEach>

		<c:if test="${pageMaker.next}">
			<li class="paginate_button next"><a
				href="${pageMaker.endPage + 1}">Next</a></li>
		</c:if>

	</ul>
	<!-- end Pagination -->
</div>

<script type="text/javascript" src="/resources/js/map.js"></script>
<script type="text/javascript">
								$(document).ready(function(){
									
									
									var actionForm = $("#actionForm");
									
									$(".paginate_button a").on("click", function(e){
										
										e.preventDefault();
										
										console.log('click');
										
										actionForm.find("input[name ='pageNum']").val($(this).attr("href"));
										actionForm.submit();
										
									});
									
									
									$("#regBtn").on("click", function(e){
										
										
										
										
									});
									
									
								});
								
								
								</script>

<!--  댓글 달기 모달  -->
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">게시글 등록</h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label>Name</label> <input class="form-control" name='name'
						value='name !!!!'>
				</div>
				<div class="form-group">
					<label>type</label> <input class="form-control" name='type'
						value='type'>
				</div>
				<div class="form-group">
					<label>regDate</label> <input class="form-control"
						name='regDate' value=''>
				</div>

			</div>

			<div class="modal-footer">
				<button id='modalModBtn' type="button" class="btn btn-warning">Modify</button>
				<button id='modalRemoveBtn' type="button" class="btn btn-danger">Remove</button>
				<button id='modalRegisterBtn' type="button" class="btn btn-default"
					data-dismiss="modal">Register</button>

				<button id='modalCloseBtn' type="button" class="btn btn-default"
					data-dismiss="modal">Close</button>


			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<%@include file="../includes/footer.jsp"%>