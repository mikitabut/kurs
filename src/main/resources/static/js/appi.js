'use strict';


var App = angular.module('example', []);

App.controller('ApiController', function ($scope, $http) {

    $scope.getAll = function () {
        $http.getAll('/api/user/all').success(function (data) {
            $scope.users = data;
        });
    };


    $scope.addUser = function () {
        $http.post('/api/user/add', $scope.user).success(function (data) {
            $scope.users = data;
            $scope.user = {};
        });
    };

    $scope.remove = function(user) {
        $http.delete('/api/user/remove', {params: {userId: user.id}}).success(function (data) {
            $scope.users = data;
        });
    };

    $scope.getById=function() {
        var s=location.href;
        var id=s.substr(s.lastIndexOf("/")+1);
        $http.get('/api/user/getById', {params: {userId: id}}).success(function (data) {
            $scope.user = data;
        });
    };

});
App.controller('UserController', function ($scope) {

    $scope.getById();

});