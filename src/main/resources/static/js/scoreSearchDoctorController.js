var app = angular.module("scoreSearchDoctor",[]);

app.service("scoreSearchDoctorService",function($http, $q,$window, $location)
{
	

	 var searchObject = $location.absUrl();
	 var searchObject_2 = searchObject.substring(45, 91);  
	 
	
	 
	var deferred = $q.defer();
	$http.get('doctor-list'+searchObject_2).then(function(data)
	{
		deferred.resolve(data);
	});

	this.getStations = function ()
	{
		return deferred.promise;
	}

	})


app.controller ("scoreSearchDoctorCtrl",function($scope,scoreSearchDoctorService,$http, $window)
{
	
 
     
	 
	var promise = scoreSearchDoctorService.getStations();
	promise.then(function(data)
	{
		$scope.stations = data.data;

	});
	
	$scope.deleteDoctor = function() {
		
		$http.delete('doctor/'+station.id);
		window.location.replace('/startAdminPage.html');
	};
	

})



