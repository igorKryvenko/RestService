(function () {
    'use strict';

    angular
        .module('RestService')
        .factory('RegistrationService', Service);

    function Service($http, $localStorage) {
        var service = {};

        service.Registration = Registration;


        return service;

        function Registration(user, callback) {
            console.log("service");
            return $http.post('/api/auth/registration', user).then(function(response) {
                return response;
            })

        }


    }
})();