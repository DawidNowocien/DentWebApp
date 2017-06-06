//1. create app module 
    var app = angular.module('app', []);

    //2. create controller
    app.controller("searchPatientController", function ($scope, $http) {

        //3. attach originalPatient model object
       $scope.originalsearchPatient = {

         
        };

        //4. copy originalnewPatient to newPatient. newPatient will be bind to a form 
        $scope.searchPatient = angular.copy($scope.originalsearchPatient);

        //5. create submitnewPatientForm() function. This will be called when user submits the form
        $scope.submitSearchPatientForm = function () {

        
            var onSuccess = function (data, status, headers, config) {
            	alert('Wyszukiwanie pacjenta powiodło się.');
            	
                             
            };

            var onError = function (data, status, headers, config) {
                alert('Wyszukiwanie pacjenta nie powiodło się.');
            }
            $http.get('/patient/{patientId}', $scope.searchPatient)
            .success(onSuccess)
            .error(onError); 
            window.location.replace('/scoreSearchPatient.html');
 
        };


});
  
