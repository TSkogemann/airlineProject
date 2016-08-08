(function (angular) {
    'use strict';
    angular.module('ngApp', []).controller('ngAppDemoController', function ($scope, $http) {
        // used to search
        $scope.date = "";
        $scope.startloc = "CPH";
        $scope.endloc = "";
        $scope.tickets = "2";
        $scope.page = 0;
        // used for booking
        $scope.bookingFlightId = "";
        $scope.bookingNumberOfSeats = "";
        $scope.bookingName = "testName";
        $scope.bookingPhoneNumber = "testNumber";
        $scope.bookingEmail = "testEmail";
        $scope.passengers = [];
        $scope.ReservationResponse={};
        

        $scope.search = function () {

            if ($scope.startloc !== "" && $scope.date !== "" && $scope.tickets !== "") {
                var url = "";
                if ($scope.endloc !== "") {

                    url = 'api/flightinfo/'
                            + $scope.startloc + '/'
                            + $scope.endloc + '/'
                            + $scope.date.toISOString() + '/'
                            + $scope.tickets + '/';
                } else {

                    url = 'api/flightinfo/'
                            + $scope.startloc + '/'
                            + $scope.date.toISOString() + '/'
                            + $scope.tickets + '/';
                }
                console.log(url);
                $http({
                    method: 'GET',
                    url: url
                }).then(function successCallback(response) {
                    $scope.fullResponse = response.data;
                    $scope.page = 1;
                }, function errorCallback(response) {
                    $scope.page = 0;
                    console.log("errorCallBack search")
                    // TODO put error message and include in div 0
                    //hardcoded response to complete the rest of the program
                    //$scope.fullResponse = flightResponse;
                    //console.log($scope.fullResponse);
                });
            }
        };

        // BOOKING
        $scope.bookTemp = function (fId, numOfSeats) {
            $scope.bookingNumberOfSeats = numOfSeats;
            $scope.bookingFlightId = fId;
            console.log($scope.bookingFlightId);
            console.log(fId);

            for (var i = 0; i < numOfSeats; i++) {
                $scope.passengers[i] = {
                    firstName: i,
                    lastName: i
                };
            }
            console.log($scope.passengers);
            $scope.page = 2;
        };

        $scope.bookFlight = function (flightId) {
            var url = "";
            url = 'api/reservation/'
                    + flightId;
            console.log(flightId);
            console.log(url);
            var bookingData={};
            bookingData.flightID = $scope.bookingFlightId;
            bookingData.numberOfSeats = $scope.bookingNumberOfSeats;
            bookingData.reserveeName = $scope.bookingName;
            bookingData.reservePhone = $scope.bookingPhoneNumber;
            bookingData.reserveeEmail = $scope.bookingEmail;
            bookingData.passengers = $scope.passengers;
            
            $http({
                method: 'POST',
                data: bookingData,
                url: url
            }).then(function successCallBack(response) {
            console.log("succesCallBack flight succesfully booked");    
            console.log(response);
            $scope.ReservationResponse = response;
            $scope.page = 3;
                //$scope.page = 0;
            }, function errorCallback(bookingResponse) {
                console.log(bookingData);
                console.log('errorBookFlight');
               // $scope.page = 0;
            });
            //skal ramme backend på url og husk at sætte scope.page=2
        };


    });


})(window.angular);

