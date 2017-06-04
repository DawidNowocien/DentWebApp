//1. create app module 
    var app = angular.module('app', []);

    //2. create controller
    app.controller("editPatientController", function ($scope, $http) {


    	$http.get('data/dane.json').success(function(data){
    		$scope.originaleditPatient = data;
    	})
    	
    	//3. attach originalPatient model object
//       $scope.originaleditPatient = {
//name:'judasz',
//city: 'warszawa'
//         
//        };

    	 //$scope.originaleditPatient = $http.get('data/dane.json');
    	
        //4. copy originalnewPatient to newPatient. newPatient will be bind to a form 
        $scope.editPatient = angular.copy($scope.originaleditPatient);

        //5. create submitnewPatientForm() function. This will be called when user submits the form
        $scope.submitEditPatientForm = function () {

        
            var onSuccess = function (data, status, headers, config) {
            	alert('Dane pacjenta zostały prawidłowo zapisane.');
            	
                             
            };

            var onError = function (data, status, headers, config) {
                alert('Wystąpił błąd podczas zapisywania danych.');
            }
            $http.post('edit-patient', $scope.editPatient)
            .success(onSuccess)
            .error(onError); 
            window.location.replace('/startDoctorPage.html');
 
        };


});
  
