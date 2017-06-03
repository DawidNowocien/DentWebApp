//1. create app module 
    var app = angular.module('app', []);

    //2. create controller
    app.controller("editPatientController", function ($scope, $http) {

        //3. attach originalPatient model object
//       $scope.originaleditPatient = {
//name:'judasz',
//city: 'warszawa'
//         
//        };

    	 $scope.originaleditPatient = $http.get('data/dane.json');
    	
        //4. copy originalnewPatient to newPatient. newPatient will be bind to a form 
        $scope.editPatient = angular.copy($scope.originaleditPatient);

        //5. create submitnewPatientForm() function. This will be called when user submits the form
        $scope.submitEditPatientForm = function () {

        
            var onSuccess = function (data, status, headers, config) {
            	alert('Patient saved successfully.');
            	
                             
            };

            var onError = function (data, status, headers, config) {
                alert('Error occured.');
            }
            $http.post('edit-patient', $scope.editPatient)
            .success(onSuccess)
            .error(onError); 
            window.location.replace('/startDoctorPage.html');
 
        };

        //6. create resetForm() function. This will be called on Reset button click.  
        $scope.resetForm = function () {
            $scope.editPatient = angular.copy($scope.originaleditPatient);
        };
});
  
