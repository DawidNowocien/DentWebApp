//1. create app module 
    var app = angular.module('app', []);

    //2. create controller
    app.controller("editDoctorController", function ($scope, $http) {

        //3. attach originalDoctor model object
        $scope.originaleditDoctor = {
           
        };

        //4. copy originalnewDoctor to newDoctor. newDoctor will be bind to a form 
        $scope.editDoctor = angular.copy($scope.originaleditDoctor);

        //5. create submitnewDoctorForm() function. This will be called when user submits the form
        $scope.submitEditDoctorForm = function () {

            var onSuccess = function (data, status, headers, config) {
                alert('Patient saved successfully.');
                
            };

            var onError = function (data, status, headers, config) {
                alert('Error occured.');
            }

            $http.post('edit-doctor', $scope.editDoctor)
                .success(onSuccess)
                .error(onError);
            window.location.replace('/startAdminPage.html');
        };

        //6. create resetForm() function. This will be called on Reset button click.  
        $scope.resetForm = function () {
            $scope.editDoctor = angular.copy($scope.originaleditDoctor);
        };
});
  
