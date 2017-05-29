//1. create app module 
    var app = angular.module('app', []);

    //2. create controller
    app.controller("visitController", function ($scope, $http) {

        //3. attach originalvisit model object
        $scope.originalnewVisit = {
            name: 'James',
            surename: 'Bond',
            dateBirth: new Date('1980/01/31'),
            address: 'Górczewska 6'
        };

        //4. copy originalnewVisit to newVisit. newVisit will be bind to a form 
        $scope.newVisit = angular.copy($scope.originalnewVisit);

        //5. create submitnewVisitForm() function. This will be called when user submits the form
        $scope.submitVisitForm = function () {

            var onSuccess = function (data, status, headers, config) {
                alert('Visit saved successfully.');
                
            };

            var onError = function (data, status, headers, config) {
                alert('Error occured.');
            }

            $http.post('add-visit', $scope.newVisit)
                .success(onSuccess)
                .error(onError);
//            $window.location.href = '/test.html';
//            redirectTo: '/';
        };

        //6. create resetForm() function. This will be called on Reset button click.  
        $scope.resetForm = function () {
            $scope.newVisit = angular.copy($scope.originalnewVisit);
        };
});
  
