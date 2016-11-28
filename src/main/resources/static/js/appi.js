'use strict';

var App = angular.module('example', [angularDragula(angular)]);

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

    $scope.userGetById=function() {
        var s=location.href;
        var id=s.substr(s.lastIndexOf("/")+1);
        $http.get('/api/user/getById', {params: {userId: id}}).success(function (data) {
            $scope.user = data;
        });
    };

    $scope.creativeGetById=function() {
        var s=location.href;
        var id=s.substr(s.lastIndexOf("/")+1);
        $http.get('/api/creative/getByUserId', {params: {userId: id}}).success(function (data) {
            $scope.creatives = data;
        });
    };
    $scope.chaptersGetById=function(creative) {
        var s=location.href;
        var id=s.substr(s.lastIndexOf("/")+1);
        $http.get('/api/chapter/getByCreativeId', {params: {creativeId: creative.id}}).success(function (data) {
            creative.chapters = data;
        });
    };


});
App.controller('UserController', function ($scope) {

    $scope.userGetById();
    $scope.creativeGetById();


});
App.controller('ChaptersController', function ($scope) {
    $scope.chaptersGetById($scope.creative);
});