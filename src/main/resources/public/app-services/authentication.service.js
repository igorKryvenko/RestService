(function () {
    'use strict';

    angular
        .module('RestService')
        .factory('AuthenticationService', Service);

    function Service($http, $localStorage) {
        var service = {};

        service.Login = Login;
        service.Logout = Logout;
        service.SetCredentials = SetCredentials;

        return service;

        //function Login(username, password, callback) {
        //    return $http.post('/api/auth/login', { username: username, password: password })
        //        .then(function (response) {
        //            // login successful if there's a token in the response
        //            if (response.token) {
        //                // store username and token in local storage to keep user logged in between page refreshes
        //                $localStorage.currentUser = { username: username, token: response.token };
        //
        //                // add jwt token to auth header for all requests made by the $http service
        //                $http.defaults.headers.common.Authorization = 'Bearer ' + response.token;
        //
        //
        //
        //            }
        //            return response;
        //        });
        //}
        function Login(username, password, callback) {
             $http.post('/api/auth/login', { username: username, password: password })
                .success(function(response){
                   callback(response);
                })
                 .error(function(response){
                     callback(response);
                 });
        }
        function SetCredentials(username,token) {

                            $localStorage.currentUser = { username: username, token: token };

                            // add jwt token to auth header for all requests made by the $http service
                            $http.defaults.headers.common.Authorization = 'Bearer ' + token;
        }

        function Logout() {
            // remove user from local storage and clear http auth header
            delete $localStorage.currentUser;
            $http.defaults.headers.common.Authorization = '';
        }
    }
})();