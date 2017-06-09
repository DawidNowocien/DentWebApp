//1. create app module 
    var app = angular.module('app', []);

    //2. create controller
    app.controller("searchPatientController", function ($scope, $http) {


       $scope.originalsearchPatient = {

         
        };


        $scope.searchPatient = angular.copy($scope.originalsearchPatient);




});
  