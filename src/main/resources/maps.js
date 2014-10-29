function initialize() {
        var mapOptions = {
          zoom: 16,
         };
        var map = new google.maps.Map(document.getElementById("map_canvas"),
            mapOptions);
  // Try HTML5 geolocation
  if(navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(function(position) {
      var pos = new google.maps.LatLng(position.coords.latitude,position.coords.longitude);
    
	var infowindow = new google.maps.InfoWindow({
        map: map,
        position: pos,
        content: 'Location found using HTML5.'
      });

	  
      map.setCenter(pos);
	  
    }, function() {
      handleNoGeolocation(true);
    });
  } else {
    // Browser doesn't support Geolocation
    handleNoGeolocation(false);
  }


function handleNoGeolocation(errorFlag) {
  if (errorFlag) {
    var content = 'Ошибка сервиса геолокации.';
  } else {
    var content = 'Ваш броузер неn\'t поддерживает геолокацию.';
  }

  var options = {
    map: map,
    position: new google.maps.LatLng(60, 105),
    content: content
  };

  var infowindow = new google.maps.InfoWindow(options);
  map.setCenter(options.position);
}

console.log(map.getCenter());

var marker = new google.maps.Marker({
    position: map.getCenter(),
    map: map,
	title: 'Перетяни'
  });
/*
function markerMove(){
marker.setTitle(marker.getPosition().toString);
}
*/
//google.maps.event.addListener(marker, 'dragend', markerMove);

google.maps.event.addDomListener(window, 'load', initialize);            

}







function initialize() {
var mapOptions = {
         zoom: 4,
         center: new google.maps.LatLng(47.81, 35.17),
         mapTypeId: google.maps.MapTypeId.ROADMAP
         };
var map = new google.maps.Map(document.getElementById("map_canvas"),
            mapOptions);


var marker = new google.maps.Marker({
    position: map.getCenter(),
    map: map,
    draggable: true,
	title: 'Перетяни'
  });

function markerMove(){
marker.setTitle(""+marker.getPosition());
console.log(""+map.getCenter());
}

google.maps.event.addListener(marker, 'dragend', markerMove);

google.maps.event.addDomListener(window, 'load', initialize);            

}