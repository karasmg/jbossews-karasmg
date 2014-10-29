<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?v=3&sensor=true">
</script>
<script type="text/javascript">
$(document).ready(function (){
  
function initialize() {
//действия, если геолокация доступна	
function geo_success(position){
        var mapOptions = {
          zoom: 14,
         };
        var map = new google.maps.Map(document.getElementById("map_canvas"),
            mapOptions);
      var pos = new google.maps.LatLng(position.coords.latitude,position.coords.longitude);
      map.setCenter(pos);
	  console.log(""+map.getCenter());
	  var marker = new google.maps.Marker({
    position: map.getCenter(),
    map: map,
    draggable: true,
	title: 'Перетяни'
  });
//действия после перетягивания маркера  
  function markerMove(){
	marker.setTitle(""+marker.getPosition());
	console.log(""+map.getCenter());
  }  
//листенер перетягивания маркера
	google.maps.event.addListener(marker, 'dragend', markerMove);	
	  }
//устанавливаем маркер по центру

function geo_error(error) {
     
switch(error.code) {
            case error.PERMISSION_DENIED:
			handleNoGeolocation(true);
                break;

            case error.POSITION_UNAVAILABLE:
			handleNoGeolocation(true);
                break;

            case error.TIMEOUT:
			handleNoGeolocation(true);
                break;

            case error.UNKNOWN_ERROR:
			handleNoGeolocation(true);
                break;
        }
	}
var geo_options = {
  enableHighAccuracy: false, 
  maximumAge        : 3000, 
  timeout           : 7000
};
  // Try HTML5 geolocation
   if(navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(geo_success, geo_error, geo_options);
  } else {
    // Browser doesn't support Geolocation
    handleNoGeolocation(false);
  }

function handleNoGeolocation(errorFlag) {
  if (errorFlag) {
    console.log('error geolocation');
  } else {
    console.log('error brouser geolocation');
  }

var myLatLng = new google.maps.LatLng(49.363882, 31.044922);
  var mapOptions = {
    zoom: 4,
    center: myLatLng
  };

  map = new google.maps.Map(document.getElementById('map_canvas'),
      mapOptions);
var marker = new google.maps.Marker({
    position: map.getCenter(),
    map: map,
    draggable: true,
	title: 'Перетяни'
  });
//действия после перетягивания маркера  
  function markerMove(){
	marker.setTitle(""+marker.getPosition());
	console.log(""+map.getCenter());
  }  
//листенер перетягивания маркера
	google.maps.event.addListener(marker, 'dragend', markerMove);	
}
}



google.maps.event.addDomListener(window, 'load', initialize);            
});
</script>