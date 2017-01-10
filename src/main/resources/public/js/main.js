/**
 * Created by Igor on 10.01.2017.
 */
var app = angular.module("RestService",[]);

app.controller("RestController",function($scope){
    $scope.currencies = [];

    $http.get('http://localhost:5533/currencies').success(function(data) {
       $scope.currencies = data;
    });
});
