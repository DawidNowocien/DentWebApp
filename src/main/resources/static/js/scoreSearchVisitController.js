var app = angular.module("scoreSearchVisit",[]);

app.service("scoreSearchVisitService",function($http, $q,$window, $location)
{
	

	//var searchObject = $location.absUrl();
	 //var searchObject_2 = searchObject.substring(44, 150);  
	 
	
	 
	var deferred = $q.defer();
	$http.get('visit-list').then(function(data)
	{
		deferred.resolve(data);
	});

	this.getStations = function ()
	{
		return deferred.promise;
	}

	})


app.controller ("scoreSearchVisitCtrl",function($scope,scoreSearchVisitService,$http, $window)
{
	
 
     

	var promise = scoreSearchVisitService.getStations();
	promise.then(function(data)
	{
		$scope.stations = data.data;

	});

	

})



