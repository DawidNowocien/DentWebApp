//1. create app module 
    var app = angular.module('app', []);

    //2. create controller
    app.controller("patientController", function ($scope, $http) {

        //3. attach originalStudent model object
        $scope.originalnewPatient = {
            name: 'James',
            surname: 'Bond',
            dateBirth: new Date('1980/01/31'),
            address: 'Górczewska 6'
        };

        //4. copy originalStudent to student. student will be bind to a form 
        $scope.newPatient = angular.copy($scope.originalnewPatient);

        //5. create submitStudentForm() function. This will be called when user submits the form
        $scope.submitPatientForm = function () {

            var onSuccess = function (data, status, headers, config) {
                alert('Patient saved successfully.');
                
            };

            var onError = function (data, status, headers, config) {
                alert('Error occured.');
            }

//            $http.post('/test', { newPatient:$scope.newPatient })
//                .success(onSuccess)
//                .error(onError);
//            $window.location.href = '/test.html';
            redirectTo: '/';
        };

        //6. create resetForm() function. This will be called on Reset button click.  
        $scope.resetForm = function () {
            $scope.newPatient = angular.copy($scope.originalnewPatient);
        };
});
  
