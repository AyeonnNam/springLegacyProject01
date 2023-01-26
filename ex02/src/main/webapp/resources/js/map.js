console.log("Map Module.........");
	
		
var mapService = (function() {
	
		function getList(callback, error) {
			
		$.getJSON("/main/map" + ".json",
		function(data) {
			if (callback) {
				callback(data);
			}
		
		}).fail(function(xhr, status, err) {
			if(error) {error();}
			
		});
		
	}


return {
	getList : getList
	

};
})();