

//var app = angular.module("RestService",['ngRoute','ngCookies']);
//
//
//app.config(function($routeProvider,$httpProvider) {
//        $routeProvider
//            .when('/login',{
//                templateUrl: '/index.view.html',
//                controller: 'LoginController'
//            })
//            .when('/currency',{
//                templateUrl: '/index.view.html',
//                controller: 'RestController'
//            })
//            .when('/registration',{
//                templateUrl: '/index.view.html',
//                controller: 'RegistrationController'
//            });
//    console.log($httpProvider);
//
//
//
//
//    });


//app.controller("RestController",function($scope,$http){
//    $scope.currencies = [];
//
//    $http.get('http://localhost:5533/currencies').success(function(data) {
//       $scope.currencies = data;
//    });
//});
//
//app.controller("RegistrationController",function($scope,$http) {
//
//    $scope.submit = function() {
//        console.log($scope.user.firstName);
//
//        $http({
//            method:'post',
//            url:'http://localhost:5533/user/registration',
//
//
//            data:$scope.user
//        }).success(function(){
//
//        });
//    };
//});
//app.factory('csrfResponseInterceptor', [function () {
//    var token = null;
//
//    return{
//        request: function(config){
//            if(token){
//                config.headers['X-CSRF-TOKEN'] = token;
//            }
//            return config;
//        },
//        response: function(response){
//            token = response.headers('X-CSRF-TOKEN');
//            return response;
//        }
//    }
//}])

//app.service('AuthSharedService', function($rootScope, $http) {
//    return {
//        login: function(userName, password) {
//            var config = {
//                params: {
//                    username: userName,
//                    password: password
//
//                },
//                ignoreAuthModule: 'ignoreAuthModule'
//            };
//
//        }
//    };
//});
//app.controller('LoginController', function($rootScope, $scope, $http,$window) {
//
//    $scope.submit = function() {
//        console.log($scope.user.email);
//
//        $http({
//            method:'post',
//            url:'http://localhost:5533/api/auth/login',
//
//
//            data:{username:$scope.user.email,password:$scope.user.password}
//        }).success(function(result,status,headers){
//            $scope.authenticated = true;
//
//            $http.defaults.header.common['X-Auth-Token'] = token;
//        });
//    };
//
//
//});




(function () {
    'use strict';

    angular
        .module('RestService', ['ui.router', 'ngMessages', 'ngStorage'])
        .config(config)
        .run(run);

    function config($stateProvider, $urlRouterProvider) {
        // default route
        $urlRouterProvider.otherwise("/");

        // app routes
        $stateProvider
            .state('registration', {
                url: '/registration',
                templateUrl: 'registration/index.view.html',
                controller: 'Registration.IndexController',
                controllerAs: 'vm'
            })
            .state('login', {
                url: '/login',
                templateUrl: 'login/index.view.html',
                controller: 'Login.IndexController',
                controllerAs: 'vm'
            })
            .state('currency',{
                url:'/currency',
                templateUrl: 'currency/index.view.html',
                controller: 'Currency.IndexController',
                controllerAs: 'vm'
            });
    }

    function run($rootScope, $http, $location, $localStorage) {
        // keep user logged in after page refresh
        if ($localStorage.currentUser) {
            $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.currentUser.token;
        }

        // redirect to login page if not logged in and trying to access a restricted page
        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            var publicPages = ['/login','/registration'];
            var restrictedPage = publicPages.indexOf($location.path()) === -1;
            if (restrictedPage && !$localStorage.currentUser) {
                $location.path('/login');
            }
        });
    }
})();
