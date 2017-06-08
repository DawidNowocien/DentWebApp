//1. create app module 
    var app = angular.module('app', []);

    //2. create controller
    app.controller("editDoctorController", function ($scope, $http) {

    	var searchObject = $location.absUrl();
   	 var searchObject_2 = searchObject.substring(45, 43);
    	
   	$http.get('doctor/'+searchObject_2).success(function(data){
		$scope.Birth = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;
		$scope.postCode = /^\+?\d{2}[- ]?\d{3}$/;
		$scope.originaleditPatient = data;
		$scope.phoneNumber = /^\+?\d{3}[- ]?\d{3}[- ]?\d{3}$/;
		
	})
    	
        //3. attach originalDoctor model object
//        $scope.originaleditDoctor = {
//           
//        };

        //4. copy originalnewDoctor to newDoctor. newDoctor will be bind to a form 
       // $scope.editDoctor = angular.copy($scope.originaleditDoctor);

        //5. create submitnewDoctorForm() function. This will be called when user submits the form
        $scope.submitEditDoctorForm = function () {


   	 $http.put('doctor/'+searchObject_2, $scope.originaleditPatient);
   	window.location.replace('/startAdminPage.html');
        };


});
  
