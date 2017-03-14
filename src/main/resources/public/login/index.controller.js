(function () {
    'use strict';

    angular
        .module('RestService')
        .controller('Login.IndexController', Controller);



    function Controller($location, AuthenticationService,FlashService) {
        var vm = this;

        vm.login = login;

        initController();

        function initController() {
            // reset login status
            AuthenticationService.Logout();
        };

        function login() {

            AuthenticationService.Login(vm.email, vm.password,function(response) {
                if(response.token){
                    AuthenticationService.SetCredentials(vm.email,response.token);
                    $location.path('/currency');
                } else {
                    FlashService.Error(response.message);
                }

            });

        };
    }

})();
