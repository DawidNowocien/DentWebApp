//1. create app module 
    var app = angular.module('app', []);


    app.service("VisitService",function($http, $q,$window, $location)
    { 	 
    	
    	 
    	var deferred = $q.defer();
    	$http.get('treatment/dict').then(function(data)
    	{
    		deferred.resolve(data);
    	});

    	this.getStations = function ()
    	{
    		return deferred.promise;
    	}

    	})

    	
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

    
    //2. create controller
    app.controller("visitController", function ($scope, $http, VisitService,PatientService,DoctorService, $window) {

    	
    	
      	var promise = VisitService.getStations();
    	promise.then(function(data)
    	{
    		$scope.stations = data.data;

    	});
    	
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
    	
    	//$scope.dateMeet = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/ /^\+?\d{2}[- ]?\d{2}$/;
        //3. attach originalvisit model object
        $scope.originalnewVisit = {
        		
        
        };

        //4. copy originalnewVisit to newVisit. newVisit will be bind to a form 
        $scope.newVisit = angular.copy($scope.originalnewVisit);

        //5. create submitnewVisitForm() function. This will be called when user submits the form
        $scope.submitVisitForm = function () {

            var onSuccess = function (data, status, headers, config) {
                alert('Dane wizyty zostały prawidłowo zapisane.');
                
            };

            var onError = function (data, status, headers, config) {
                alert('Wystąpił błąd podczas zapisywania danych.');
            }

            $http.post('visit', $scope.newVisit)
                .success(onSuccess)
                .error(onError);
            window.location.replace('/startDoctorPage.html');
        };

        //6. create resetForm() function. This will be called on Reset button click.  
        $scope.resetForm = function () {
            $scope.newVisit = angular.copy($scope.originalnewVisit);
        };
});
  
