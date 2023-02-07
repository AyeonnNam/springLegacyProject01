<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>

<!-- Page Content -->

<div class="row">

	<div class="col-lg-12">


		<div id="map" style="width: 1180px; height: 800px;"></div>

	</div>

</div>

<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=260bc248c491b390e8be01ca9c7068a2"></script>



<script>
	var container = document.getElementById('map'); // 지도를 표시할 div  
	var options = {
		center : new kakao.maps.LatLng(37.5642135, 127.0016985), // 지도의 중심좌표
		level : 6
	};

	var map = new kakao.maps.Map(container, options); // 지도를 생성합니다
</script>

<script type= "text/javascript">
console.log("뭐가 뜨긴 뜨냐?");

		
		
	

</script>








<script type="text/javascript" src="/resources/js/map.js"></script>


<%@include file="../includes/footer.jsp"%>


