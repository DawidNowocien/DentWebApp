//1. create app module 
    var app = angular.module('app', []);

    //2. create controller
    app.controller("searchPatientController", function ($scope, $http) {
    	//$scope.Date = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;

       $scope.originalsearchPatient = {

         
        };


        $scope.searchPatient = angular.copy($scope.originalsearchPatient);




});
  