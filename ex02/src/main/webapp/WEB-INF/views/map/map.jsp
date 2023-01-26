<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


<!-- Page Content -->

<div class="row">
	<div class="col-lg-12">

		<div id="map" style="width: 1180px; height: 800px;"></div>
		<script type="text/javascript"
			src="//dapi.kakao.com/v2/maps/sdk.js?appkey=260bc248c491b390e8be01ca9c7068a2"></script>
		<script>
		var container = document.getElementById('map');	// 지도를 표시할 div  
		var options = {
			center: new kakao.maps.LatLng(37.5642135, 127.0016985), // 지도의 중심좌표
			level: 6
		};

		var map = new kakao.maps.Map(container, options);  // 지도를 생성합니다
		
		
	// 마커를 표시할 위치와 title 객체 배열입니다 
	var positions = [
	    {
	        title: '카카오', 
	        latlng: new kakao.maps.LatLng(33.450705, 126.570677)
	    },
	    {
	        title: '생태연못', 
	        latlng: new kakao.maps.LatLng(33.450936, 126.569477)
	    },
	    {
	        title: '텃밭', 
	        latlng: new kakao.maps.LatLng(33.450879, 126.569940)
	    },
	    {
	        title: '근린공원',
	        latlng: new kakao.maps.LatLng(33.451393, 126.570738)
	    }
	];

	// 마커 이미지의 이미지 주소입니다
	var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
	    
	for (var i = 0; i < positions.length; i ++) {
	    
	    // 마커 이미지의 이미지 크기 입니다
	    var imageSize = new kakao.maps.Size(24, 35); 
	    
	    // 마커 이미지를 생성합니다    
	    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
	    
	    // 마커를 생성합니다
	    var marker = new kakao.maps.Marker({
	        map: map, // 마커를 표시할 지도
	        position: positions[i].latlng, // 마커를 표시할 위치
	        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
	        image : markerImage // 마커 이미지 
	    });
	}
		
		
	</script>
	
	

	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<script>
	console.log("---------------");
	console.log("JS TEST");
	
	mapService.getList( function(list) {
		
		for (var i = 0, len = list.length || 0; i < len; i++) {
			console.log(list[i]);
		}
		
	});
	
	</script>





<%@include file="../includes/footer.jsp"%>


<script type="text/javascript" src="/resources/js/map.js"></script>
