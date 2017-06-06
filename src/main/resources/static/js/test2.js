//1. create app module 
    var app = angular.module('app', []);

    //2. create controller
    app.controller("patientController", function ($scope, $http) {
    	$scope.phoneNumber = /^\+?\d{2}[- ]?\d{3}[- ]?\d{5}$/;
        //3. attach originalPatient model object
       $scope.originalnewPatient = {

         
        };

        //4. copy originalnewPatient to newPatient. newPatient will be bind to a form 
        $scope.newPatient = angular.copy($scope.originalnewPatient);

        //5. create submitnewPatientForm() function. This will be called when user submits the form
        $scope.submitPatientForm = function () {

        
            var onSuccess = function (data, status, headers, config) {
            	alert('Dane pacjenta zostały prawidłowo zapisane.');
            	
                             
            };

            var onError = function (data, status, headers, config) {
                alert('Wystąpił błąd podczas zapisywania danych.');
            }
            $http.post('patient', $scope.newPatient)
            .success(onSuccess)
            .error(onError); 
            window.location.replace('/startDoctorPage.html');
 
        };

        //6. create resetForm() function. This will be called on Reset button click.  
        $scope.resetForm = function () {
            $scope.newPatient = angular.copy($scope.originalnewPatient);
        };
});
  
