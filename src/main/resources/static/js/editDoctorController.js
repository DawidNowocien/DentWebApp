//1. create app module 
    var app = angular.module('app', []);
  
    app.service("SpecializationService",function($http, $q,$window, $location)
    	    { 	 
    	    	
    	    	 
    	    	var deferred = $q.defer();
    	    	$http.get('doctor/specialization/dict').then(function(data)
    	    	{
    	    		deferred.resolve(data);
    	    	});

    	    	this.getSpecializations = function ()
    	    	{
    	    		return deferred.promise;
    	    	}

    	    	})
    
    //2. create controller
    app.controller("editDoctorController", function ($scope, $http, $window, $location,SpecializationService) {

    	
    	 var searchObject = $location.absUrl();
    	 var searchObject_2 = searchObject.substring(44, 42);  
    	 
    	
    	$http.get('doctor/'+searchObject_2).success(function(data){
    		$scope.Birth = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;
    		$scope.postCode = /^\+?\d{2}[- ]?\d{3}$/;
    		$scope.originaleditDoctor = data;
    		$scope.phoneNumber = /^\+?\d{3}[- ]?\d{3}[- ]?\d{3}$/;
    		
    		var promise = SpecializationService.getSpecializations();
        	promise.then(function(data)
        	{
        		$scope.specializations = data.data;

        	});
    		
    	})
    	

        $scope.submitEditDoctorForm = function () {


            $http.put('doctor/'+searchObject_2, $scope.originaleditDoctor);

            window.location.replace('/startAdminPage.html');
 
        };
        
        
        


});
  
