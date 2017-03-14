(function () {
    'use strict';

    angular
        .module('RestService')
        .controller('Registration.IndexController', Controller);

    function Controller($location, RegistrationService,FlashService) {
        var vm = this;

        vm.registration = registration;





        function registration() {



            RegistrationService.Registration(vm.user).then(function(response) {

                if(response.status ==200) {
                    FlashService.Success('Registration successful', true);
                    $location.path('/login');

                } else {
                    FlashService.Error(response.data.message);
                }
            })
        };
    }

})();