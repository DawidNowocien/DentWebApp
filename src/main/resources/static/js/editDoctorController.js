//1. create app module 
    var app = angular.module('app', []);

    //2. create controller
    app.controller("editDoctorController", function ($scope, $http) {

    	$http.get('data/dane2.json').success(function(data){
    		$scope.originaleditDoctor = data;
    	})
    	
        //3. attach originalDoctor model object
//        $scope.originaleditDoctor = {
//           
//        };

        //4. copy originalnewDoctor to newDoctor. newDoctor will be bind to a form 
        $scope.editDoctor = angular.copy($scope.originaleditDoctor);

        //5. create submitnewDoctorForm() function. This will be called when user submits the form
        $scope.submitEditDoctorForm = function () {

            var onSuccess = function (data, status, headers, config) {
                alert('Dane lekarza zostały prawidłowo zapisane.');
                
            };

            var onError = function (data, status, headers, config) {
                alert('Wystąpił błąd podczas zapisywania danych.');
            }

            $http.post('edit-doctor', $scope.editDoctor)
                .success(onSuccess)
                .error(onError);
            window.location.replace('/startAdminPage.html');
        };


});
  
