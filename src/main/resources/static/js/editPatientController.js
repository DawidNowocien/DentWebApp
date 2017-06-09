//1. create app module 
    var app = angular.module('app', []);
  
    //2. create controller
    app.controller("editPatientController", function ($scope, $http, $window, $location) {

    	
    	 var searchObject = $location.absUrl();
    	 var searchObject_2 = searchObject.substring(45, 43);  
    	 
    	
    	$http.get('patient/'+searchObject_2).success(function(data){
    		$scope.Birth = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;
    		$scope.postCode = /^\+?\d{2}[- ]?\d{3}$/;
    		$scope.originaleditPatient = data;
    		$scope.phoneNumber = /^\+?\d{3}[- ]?\d{3}[- ]?\d{3}$/;
    		
    	})
    	

        $scope.submitEditPatientForm = function () {


            $http.put('patient/'+searchObject_2, $scope.originaleditPatient);

            window.location.replace('/startDoctorPage.html');
 
        };
        
        
        


});
  
