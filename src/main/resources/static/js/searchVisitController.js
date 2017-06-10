//1. create app module 
    var app = angular.module('app', []);
    
    app.service("PatientService",function($http, $q,$window, $location)
    	    { 	 
    	    	
    	    	 
    	    	var deferred = $q.defer();
    	    	$http.get('patient-list').then(function(data)
    	    	{
    	    		deferred.resolve(data);
    	    	});

    	    	this.getPatients = function ()
    	    	{
    	    		return deferred.promise;
    	    	}

    	    	})
    	    	
    	    	app.service("DoctorService",function($http, $q,$window, $location)
    	    { 	 
    	    	
    	    	 
    	    	var deferred = $q.defer();
    	    	$http.get('doctor-list').then(function(data)
    	    	{
    	    		deferred.resolve(data);
    	    	});

    	    	this.getDoctors = function ()
    	    	{
    	    		return deferred.promise;
    	    	}

    	    	})


    app.controller("searchVisitController", function ($scope, $http,PatientService,DoctorService) {
    	

    	var promise_2 = PatientService.getPatients();
    	promise_2.then(function(data)
    	{
    		$scope.patients = data.data;

    	});
    	
    	var promise_3 = DoctorService.getDoctors();
    	promise_3.then(function(data)
    	{
    		$scope.doctors = data.data;

    	});
    	
    	
        $scope.originalsearchVisit = {
        
        };

        $scope.newVisit = angular.copy($scope.originalsearchVisit);

       
});
  
