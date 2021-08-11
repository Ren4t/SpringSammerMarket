angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/summer/api/v1';

    $scope.loadPage = function (pageIndex = 1) {
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                'p': pageIndex
            }
        }).then(function (response) {
            $scope.productsPage = response.data;
            $scope.navList = $scope.generatePagesIndexes(1, $scope.productsPage.totalPages);
            console.log(response.data);
        });
    };


    $scope.loadCart = function () {
        $http({
            url: contextPath + '/cart',
            method: 'GET'
        }).then(function (response) {
            $scope.cart = response.data;
        });
    }

    $scope.addToCart = function (productId,amount) {
        $http({
            url: contextPath + '/cart/add/' + productId + '/' + amount,
            method: 'GET'
        }).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.deleteItem = function (productId) {
        $http({
            url: contextPath + '/cart/deleteId/' + productId,
            method: 'GET'
        }).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.clearCart = function () {
        $http({
            url: contextPath + '/cart/clear',
            method: 'GET'
        }).then(function (response) {
           // $scope.loadCart();
           $scope.cart = null;
        });
    }

    $scope.loadOrders = function () {
        $http({
            url: contextPath + '/orders',
            method: 'GET'
        }).then(function (response) {
           $scope.orders = response.data;
           console.log(response.data);
        });
    }

    $scope.createOrder = function () {
        $http({
            url: contextPath + '/orders',
            method: 'POST'
        }).then(function (response) {
           alert('Заказ создан');
           $scope.loadCart();
           $scope.loadOrders();
        });
    }

    $scope.generatePagesIndexes = function (startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    $scope.loadPage();
    $scope.loadCart();
     $scope.loadOrders();
});