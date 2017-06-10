var app = angular.module("scoreSearchPatient",[]);

app.service("scoreSearchPatientService",function($http, $q,$window, $location)
{
	

	 var searchObject = $location.absUrl();
	 var searchObject_2 = searchObject.substring(45, 91);  
	 
	
	 
	var deferred = $q.defer();
	$http.get('patient-list'+searchObject_2).then(function(data)
	{
		deferred.resolve(data);
	});

	this.getStations = function ()
	{
		return deferred.promise;
	}

	})


app.controller ("scoreSearchPatientCtrl",function($scope,scoreSearchPatientService,$http, $window)
{
	
 
     
	 
	var promise = scoreSearchPatientService.getStations();
	promise.then(function(data)
	{
		$scope.stations = data.data;

	
	});
	
	$scope.deletePatient = function(station) {
		
		$http.delete('patient/'+station.id);
		window.location.replace('/startDoctorPage.html');
	};
	

})

