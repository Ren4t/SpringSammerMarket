angular.module('app', []).controller('indexController', function ($scope, $http) {
    $scope.loadProducts = function () {
        $http({
            url: 'http://localhost:8189/summer/products',
            method: 'GET',
            params: {}
        }).then(function (response) {
            console.log(response);
            //$scope.products = response.data;
            $scope.loadPage($scope.page);
        });
    };

    $scope.page = 1;

    $scope.loadPage = function (pageIndex) {
        $scope.page = pageIndex;
        $http({
            url: 'http://localhost:8189/summer/page',
            method: 'GET',
            params: {
                'p': pageIndex
            }
        }).then(function (response) {
            console.log(response);
            $scope.products = response.data.content;
        });
    };


    $scope.showProductInfo = function (productIndex) {
        $http({
            url: 'http://localhost:8189/summer/product/' + productIndex,
            method: 'GET'
        }).then(function (response) {
            alert(response.data.title);
        });
    };

    $scope.deleteProduct = function (productIndex) {
            $http({
                url: 'http://localhost:8189/summer/delete/' + productIndex,
                method: 'GET'
            }).then(function (response) {
                $scope.loadProducts();
            });
        };

    $scope.loadProducts();
});