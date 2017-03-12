(function () {
    'use strict';

    angular
        .module('RestService')
        .factory('CurrencyService', Service);

    function Service($http, $localStorage) {
        var service = {};

        service.getCurrency = getCurrency;


        return service;

        function getCurrency() {
                    return $http.get('http://localhost:5533/currencies')
                        .then(function(response){

                           return response.data;
                        });
            }



    }
})();