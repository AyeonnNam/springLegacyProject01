<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
 <%@ taglib uri ="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
 <%@include file="../includes/header.jsp" %>
 


<form role="form" action="/board/modify" method="post">

<!-- 추가 -->
<input type='hidden' name='pageNum' value='<c:out value = "${cri.pageNum}"/>'>
<input type='hidden' name='amount' value='<c:out value = "${cri.amount}"/>'>
<input type='hidden' name='type' value='<c:out value="${cri.type}"/>'>       
 <input type='hidden' name='keyword' value='<c:out value="${cri.keyword}"/>'>
        

<div class="form-group">
	<label>Bno</label>
	<input class="form-control" name='bno'
		value = '<c:out value="${board.bno}"/>' readonly="readonly">
</div>


<div class="form-group">
	<label>Title</label>
	<input class="form-control" name='title'
		value = '<c:out value="${board.title}"/>' >
</div>

<div class="form-group">
	<label>Text area</label>
	<textarea class="form-control" rows = "3" name='content' >
	<c:out value="${board.content}"/> </textarea>
</div>


<div class="form-group">
	<label>Writer</label>
	<input class="form-control" name='writer'
		value = '<c:out value="${board.writer}"/>' readonly="readonly" >
</div>

<div class="form-group">
	<label>RegDate</label>
	<input class="form-control" name='regDate'
		value = '<fmt:formatDate pattern = "yyyy/MM/dd" value = "${board.regDate}"/>' readonly="readonly" >
</div>

<div class="form-group">
	<label>Update Date</label>
	<input class="form-control" name='upDateDate'
		value = '<fmt:formatDate pattern = "yyyy/MM/dd" value = "${board.upDateDate}"/>' readonly="readonly" >
</div>
<!--  버튼 -->
	
<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>	<!--리스트로 돌아가기 -->
<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>	<!--  제거 후 리스트로 돌아가 -->
<button type="submit" data-oper='list' class="btn btn-info">List</button>	<!-- 리스트로 돌아가기 -->

</form>


<!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
            </div>
            <!-- /.row -->
           <%@include file="../includes/footer.jsp" %>
           
           
           
	<script type = "text/javascript">
	
		$(document).ready(function() {
			
			var formObj = $("form");
			
			$('button').on("click", function(e) {
				
				e.preventDefault();
				
				var operation = $(this).data("oper");
				
				console.log(operation);
				
				if(operation === 'remove') {
					
					formObj.attr("action","/board/remove");
					
				}else if(operation === 'list'){
					
					//move to list
					formObj.attr("action","/board/list").attr("method","get");
					
					var pageNumTag = $("input[name='pageNum']").clone();
					var amountTag = $("input[name='amount']").clone();
					var keywordTag = $("input[name='keyword']").clone();
					var typeTag = $("input[name='type']").clone();
					
					formObj.empty();
					formObj.append(pageNumTag);
					formObj.append(amountTag);
					formObj.append(keywordTag);
					formObj.append(typeTag);
				}	
				formObj.submit();
				
				
			});
			
			
			
			
		});
	
	
	</script>
           
           