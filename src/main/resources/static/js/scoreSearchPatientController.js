var app = angular.module("scoreSearchPatient",[]);

app.service("scoreSearchPatientService",function($http, $q)
{
	
	var deferred = $q.defer();
	$http.get('/patient-list').then(function(data)
	{
		deferred.resolve(data);
	});

	this.getStations = function ()
	{
		return deferred.promise;
	}

	})


app.controller ("scoreSearchPatientCtrl",function($scope,scoreSearchPatientService)
{
	
 
     
	 
	var promise = scoreSearchPatientService.getStations();
	promise.then(function(data)
	{
		$scope.stations = data.data;

	});
	
	


})



