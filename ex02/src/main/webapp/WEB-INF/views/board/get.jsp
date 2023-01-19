<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Read</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">

			<!-- /.panel-heading -->
			<div class="panel-body">

				<div class="form-group">
					<label>Bno</label> <input class="form-control" name='bno'
						value='<c:out value="${board.bno}"/>' readonly="readonly">
				</div>

				<div class="form-group">
					<label>Title</label> <input class="form-control" name='title'
						value='<c:out value="${board.title}"/>' readonly="readonly">
				</div>

				<div class="form-group">
					<label>Text area</label>
					<textarea class="form-control" rows="3" name='content'
						readonly="readonly"><c:out value="${board.content}" /></textarea>
				</div>

				<div class="form-group">
					<label>Writer</label> <input class="form-control" name='writer'
						value='<c:out value="${board.writer}"/>' readonly="readonly">
				</div>
				<!--  버튼  -->
				<button data-oper='modify' class="btn btn-default">Modify</button>
				<button data-oper='list' class="btn btn-info">List</button>

				<form id='openForm' action="/board/modify" method="get">
					<input type='hidden' id='bno' name='bno'
						value='<c:out value="${board.bno}"/>'> <input
						type='hidden' name='pageNum'
						value='<c:out value="${cri.pageNum}"/>'> <input
						type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
					<input type='hidden' name='keyword'
						value='<c:out value="${cri.keyword}"/>'> <input
						type='hidden' name='type' value='<c:out value="${cri.type}"/>'>

				</form>



			</div>
			<!-- end panel-body -->
		</div>
		<!-- end panel-body -->
	</div>
	<!-- end panel -->
</div>
<!-- /.row -->

<div class='row'>
	<div class="col-lg-12">
		<!-- /.panel -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<i class="fa fa-comments fa-fw"></i> Reply
				<button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>New
					Reply</button>
			</div>

			<!-- /.panel-heading -->
			<div class="panel-body">
				<ui class="chat"> <!-- start reply -->
				<li class="left clear fix" data-rno='42'>
					<div>
						<div class="header">
							<strong class="primary font">user00</strong> <small
								class="pull-right text-muted">2022-01-15 02:54</small>
						</div>
						<p>Good Job!</p>
					</div>
				</li>
				<!--  end reply --> </ui>
				<!--./ end ui -->
			</div>
			<!--  /.panel .chat-panel -->
		</div>
	</div>
	<!-- ./ end row -->

</div>

<%@include file="../includes/footer.jsp"%>
<!--  댓글 달기 모달  -->
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Reply Modal</h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label>Reply</label> <input class="form-control" name='reply'
						value='New Reply !!!!'>
				</div>
				<div class="form-group">
					<label>Replyer</label> <input class="form-control" name='replyer'
						value='replyer'>
				</div>
				<div class="form-group">
					<label>Reply Date</label> <input class="form-control"
						name='replyDate' value=''>
				</div>

			</div>

			<div class="modal-footer">
				<button id='modalModBtn' type="button" class="btn btn-warning">Modify</button>
				<button id='modalRemoveBtn' type="button" class="btn btn-danger">Remove</button>
				<button id = 'modalRegisterBtn' type="button" class="btn btn-default" data-dismiss="modal">Register</button>
				
				<button id='modalCloseBtn' type="button" class="btn btn-default"
					data-dismiss="modal">Close</button>
				

			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->




<script type="text/javascript" src="/resources/js/reply.js"></script>

<!-- 댓글 목록 처리 -->
<script>
	$(document)
			.ready(
					function() {

						var bnoValue = '<c:out value = "${board.bno}"/>';
						var replyUL = $(".chat");

						showList(1);

						function showList(page) {

							replyService
									.getList(
											{
												bno : bnoValue,
												page : page || 1
											},
											function(list) {
												var str1 = "아직 댓글이 없습니다.";
												var str = "";
												if (list == null
														|| list.length == 0) {

													replyUL.html(str1);

													return;
													
												}
												
												for (var i = 0, len = list.length || 0; i < len; i++) {

													str += "<li class ='left clearfix' data-rno='"+list[i].rno+"'>";
													str += "  <div><div class='header'><strong class='primary-font'>"
															+ list[i].replyer
															+ "</strong>";
													str += "     <small class='pull-right text-muted'>"
															+ replyService
																	.displayTime(list[i].replyDate)
															+ "</small></div>";
													str += "       <p>"
															+ list[i].reply
															+ "</p></div></li>";
															
															

												}
												
												replyUL.html(str);

											});//end function

						}//end showList
						
						var modal  = $(".modal");
						var modalInputReply = modal.find("input[name = 'reply']");
						var modalInputReplyer = modal.find("input[name = 'replyer']");
						var modalInputReplyDate = modal.find("input[name = 'replyDate']");
						
						var modalModBtn = $("#modalModBtn");
						var modalRemoveBtn = $("#modalRemoveBtn");
						var modalRegisterBtn = $("#modalRegisterBtn");
						
						$("#addReplyBtn").on("click", function(e){
							
							modal.find("input").val("");
							modalInputReplyDate.closest("div").hide();
							modal.find("button[id != 'modalCloseBtn']").hide();
							
							modalRegisterBtn.show();
							
							$(".modal").modal("show");
							
						});
				
					
					
						modalRegisterBtn.on("click", function(e){
							
							var reply = {
								reply : modalInputReply.val(),
								replyer : modalInputReplyer.val(),
								bno : bnoValue
							};
					
							
						replyService.add(reply, function(result){
						
						alert(result);
						
						modal.find("input").val("");
						modal.modal("hide");
						
						showList(1);
						
							
							
						});	
						
						});
		//댓글 조회 클릭 이벤트 처리 	
		$(".chat").on("click", "li", function(e){
			
			var rno = $(this).data("rno");
			
			//console.log(rno);
			
			replyService.get(rno, function(reply){
				
				modalInputReply.val(reply.reply);
				modalInputReplyer.val(reply.replyer);
				modalInputReplyDate.val(replyService.displayTime(reply.replyDate)).attr("readonly","readonly");
				modal.data("rno",reply.rno);
				
				modal.find("button[id! ='modalCloseBtn']").hide();
				modalModBtn.show();	//수정버튼 
				modalRemoveBtn.show();	//제거버튼 
				
				$(".modal").modal("show");
				
			});
			
		});				
						
						

					});
</script>


<script>
console.log("=============");
console.log("JS TEST");

var bnoValue = '<c:out value = "${board.bno}"/>';

 //댓글 목록 조회 
replyService.getList({
	bno : bnoValue,
	page : 1
}, function(list) {

	for (var i = 0, len = list.length || 0; i < len; i++) {
		console.log(list[i]);
	}

}); 

</script>

<!-- <script>
	console.log("=============");
	console.log("JS TEST");

	var bnoValue = '<c:out value = "${board.bno}"/>';

	/* //댓글 목록 조회 
	replyService.getList({
		bno : bnoValue,
		page : 1
	}, function(list) {

		for (var i = 0, len = list.length || 0; i < len; i++) {
			console.log(list[i]);
		}

	}); */

	//댓글 추가 
	replyService.add({
		reply : "JS Test",
		replyer : "tester",
		bno : bnoValue
	}, function(result) {
		alert("RESULT : " + result);

	}

	);

	//댓글 삭제 
	replyService.remove(71, function(count) {

		console.log(count);

		if (count === "success") {
			alert("REMOVED");
		}
	}, function(err) {
		alert('ERROR.......');

	});

	//댓글 업데이트 
	replyService.update({
		rno : 73,
		bno : bnoValue,
		reply : "Modified Reply....."
	}, function(result) {
		alert("수정 완료");
	});
	
	//댓글 조회 
	replyService.get(73, function(data) {
		console.log(data);
	}
				
	);
	
</script>
 -->


<script type="text/javascript">
	$(document).ready(function() {

		var openForm = $("#openForm");

		$("button[data-oper='modify']").on("click", function(e) {

			openForm.attr("action", "/board/modify").submit();

		});

		$("button[data-oper='list']").on("click", function(e) {

			openForm.find("#bno").remove();

			openForm.attr("action", "/board/list")

			openForm.submit();
		});

	});
</script>






