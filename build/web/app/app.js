(function (angular) {
    'use strict';
    angular.module('ngAppDemo', []).controller('ngAppDemoController', function ($scope, $http) {
        $scope.count = 0;
        $scope.date = "";
        $scope.startloc = "";
        $scope.endloc = "";
        $scope.tickets = "";
        var flightResponse = {
            "airline": "AngularJS Airline",
            "flights": [
                {
                    "flightID": "2257-1457179200000",
                    "flightNumber": "COL2257",
                    "date": "2016-03-05T13:00:00.000Z",
                    "numberOfSeats": 3,
                    "totalPrice": 180,
                    "traveltime": 120,
                    "origin": "CDG",
                    "destination": "CPH"
                },
                {
                    "flightID": "2257-1457179200000",
                    "flightNumber": "COL2257",
                    "date": "2016-03-05T13:00:00.000Z",
                    "numberOfSeats": 3,
                    "totalPrice": 180,
                    "traveltime": 120,
                    "origin": "CDG",
                    "destination": "CPH"
                },
                {
                    "flightID": "2257-1457179200000",
                    "flightNumber": "COL2257",
                    "date": "2016-03-05T13:00:00.000Z",
                    "numberOfSeats": 3,
                    "totalPrice": 180,
                    "traveltime": 120,
                    "origin": "CDG",
                    "destination": "CPH"
                }

            ]
        };

        $scope.search = function () {
            $scope.count = $scope.count + 1;
            if (
                    $scope.startloc !== "" &&
                    $scope.date !== "" &&
                    $scope.tickets !== ""
                    ) {
                if ($scope.endloc !== "") {
                    console.log(
                            '/localhost:8080/api/flights/'
                            + $scope.startloc + '/'
                            + $scope.endloc + '/'
                            + $scope.date.toISOString() + '/'
                            + $scope.tickets + '/'
                            );
                    $http({
                        method: 'GET',
                        url: '/localhost:8080/api/flights/'
                                + $scope.startloc + '/'
                                + $scope.endloc + '/'
                                + $scope.date.toISOString() + '/'
                                + $scope.tickets + '/'
                    }).then(function successCallback(response) {
                        // this callback will be called asynchronously
                        // when the response is available
                    }, function errorCallback(response) {
                        //hardcoded response to complete the rest of the program
                        $scope.fullResponse = flightResponse;
                        console.log($scope.fullResponse);
                    });
                } else {
                    console.log(
                            '/localhost:8080/api/flights/'
                            + $scope.startloc + '/'
                            + $scope.date.toISOString() + '/'
                            + $scope.tickets + '/'
                            );
                    $http({
                        method: 'GET',
                        url: '/localhost:8080/api/flights/'
                                + $scope.startloc + '/'
                                + $scope.date.toISOString() + '/'
                                + $scope.tickets + '/'
                    }).then(function successCallback(response) {
                        // this callback will be called asynchronously
                        // when the response is available
                    }, function errorCallback(response) {
                        // Test to make the rest of the program without an API
                    });
                }
            }
        };
    });
})(window.angular);

