//1. create app module 
    var app = angular.module('app', []);

    
    
    
    
    //2. create controller
    app.controller("visitController", function ($scope, $http) {

        //3. attach originalvisit model object
        $scope.originalnewVisit = {
        		
        
        };

        //4. copy originalnewVisit to newVisit. newVisit will be bind to a form 
        $scope.newVisit = angular.copy($scope.originalnewVisit);

        //5. create submitnewVisitForm() function. This will be called when user submits the form
        $scope.submitVisitForm = function () {

            var onSuccess = function (data, status, headers, config) {
                alert('Dane wizyty zostały prawidłowo zapisane.');
                
            };

            var onError = function (data, status, headers, config) {
                alert('Wystąpił błąd podczas zapisywania danych.');
            }

            $http.post('add-visit', $scope.newVisit)
                .success(onSuccess)
                .error(onError);
            window.location.replace('/startDoctorPage.html');
        };

        //6. create resetForm() function. This will be called on Reset button click.  
        $scope.resetForm = function () {
            $scope.newVisit = angular.copy($scope.originalnewVisit);
        };
});
  
