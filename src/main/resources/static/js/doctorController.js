//1. create app module 
    var app = angular.module('app', []);

    //2. create controller
    app.controller("doctorController", function ($scope, $http) {

        //3. attach originalDoctor model object
        $scope.originalnewDoctor = {
            name: 'James',
            surename: 'Bond',
            dateBirth: new Date('1980/01/31'),
            address: 'Górczewska 6'
        };

        //4. copy originalnewDoctor to newDoctor. newDoctor will be bind to a form 
        $scope.newDoctor = angular.copy($scope.originalnewDoctor);

        //5. create submitnewDoctorForm() function. This will be called when user submits the form
        $scope.submitDoctorForm = function () {

            var onSuccess = function (data, status, headers, config) {
                alert('Patient saved successfully.');
                
            };

            var onError = function (data, status, headers, config) {
                alert('Error occured.');
            }

            $http.post('add-doctor', $scope.newDoctor)
                .success(onSuccess)
                .error(onError);
//            $window.location.href = '/test.html';
//            redirectTo: '/';
        };

        //6. create resetForm() function. This will be called on Reset button click.  
        $scope.resetForm = function () {
            $scope.newDoctor = angular.copy($scope.originalnewDoctor);
        };
});
  
