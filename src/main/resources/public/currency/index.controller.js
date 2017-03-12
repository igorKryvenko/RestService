(function () {
    'use strict';

    angular
        .module('RestService')
        .controller('Currency.IndexController', Controller);

    function Controller($location, CurrencyService) {
        var vm = this;

        vm.items = {};




        var init = function() {
            console.log("init method");
            CurrencyService.getCurrency().then(function(data) {
                vm.items = data;
            })

        }
        init();
    }

})();
