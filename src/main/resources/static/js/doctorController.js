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
    app.controller("doctorController", function ($scope, $http,SpecializationService) {
    	$scope.phoneNumber = /^\+?\d{3}[- ]?\d{3}[- ]?\d{3}$/;
    	$scope.Birth = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;
    	$scope.postCode = /^\+?\d{2}[- ]?\d{3}$/;
    	
    	
    	
    	var promise = SpecializationService.getSpecializations();
    	promise.then(function(data)
    	{
    		$scope.specializations = data.data;

    	});
        //3. attach originalDoctor model object
        $scope.originalnewDoctor = {
           
        };

        //4. copy originalnewDoctor to newDoctor. newDoctor will be bind to a form 
        $scope.newDoctor = angular.copy($scope.originalnewDoctor);

        //5. create submitnewDoctorForm() function. This will be called when user submits the form
        $scope.submitDoctorForm = function () {

            var onSuccess = function (data, status, headers, config) {
                alert('Dane lekarza zostały prawidłowo zapisane.');
                
            };

            var onError = function (data, status, headers, config) {
                alert('Wystąpił błąd podczas zapisywania danych.');
            }

            $http.post('doctor', $scope.newDoctor)
                .success(onSuccess)
                .error(onError);
            window.location.replace('/startAdminPage.html');
        };

        //6. create resetForm() function. This will be called on Reset button click.  
        $scope.resetForm = function () {
            $scope.newDoctor = angular.copy($scope.originalnewDoctor);
        };
});
  
