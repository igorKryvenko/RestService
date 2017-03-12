(function () {
    'use strict';

    angular
        .module('RestService')
        .controller('Registration.IndexController', Controller);

    function Controller($location, RegistrationService,AuthenticationService) {
        var vm = this;

        vm.registration = registration;





        function registration() {


            //RegistrationService.Registration(vm.user, function (result) {
            //    vm.loading=true;
            //
            //    if (result === true) {
            //        console.log("heelo");
            //        AuthenticationService.Login(vm.user.email, vm.user.password, function (result) {
            //            if (result === true) {
            //                $location.path('/currency');
            //            } else {
            //                vm.error = 'Username or password is incorrect';
            //                vm.loading = false;
            //            }
            //        });
            //    } else {
            //        vm.error = 'Username or password is incorrect';
            //        vm.loading = false;
            //    }
            //});
            RegistrationService.Registration(vm.user).then(function(response) {
                console.log("hello");
                if(response === true) {
                    console.log("hello");
                }
            })
        };
    }

})();