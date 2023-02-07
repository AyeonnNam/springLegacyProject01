<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Typography</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<c:forEach items="${showMap}" var="map">

	<!-- /.col-lg-4 -->
	<div class="col-lg-4">
		<div class="panel panel-default">
			<div class="panel-heading"><c:out value="${map.name} "/></div>
			<div class="panel-body">
			
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-4 -->
	<!-- /.col-lg-4 -->

</c:forEach>



<!-- <div class="col-lg-4">
	<div class="panel panel-default">
		<div class="panel-heading">Emphasis Classes</div>
		<div class="panel-body">
			<p class="text-muted">This is an example of muted text.</p>
			<p class="text-primary">This is an example of primary text.</p>
			<p class="text-success">This is an example of success text.</p>
			<p class="text-info">This is an example of info text.</p>
			<p class="text-warning">This is an example of warning text.</p>
			<p class="text-danger">This is an example of danger text.</p>
		</div>
		/.panel-body
	</div>
	/.panel
</div>
/.col-lg-4
 -->


<%@include file="../includes/footer.jsp"%>