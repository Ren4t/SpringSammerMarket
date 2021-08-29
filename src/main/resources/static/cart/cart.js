angular.module('app').controller('cartController', function ($scope, $http, $localStorage) {
    const contextPath = 'http://localhost:8189/summer';

    $scope.loadCart = function () {
        $http({
            url: contextPath + '/api/v1/cart',
            method: 'GET'
        }).then(function (response) {
            $scope.cart = response.data;
        });
    }

    $scope.addToCart = function (productId,amount) {
        $http({
            url: contextPath + '/api/v1/cart/add/' + productId + '/' + amount,
            method: 'GET'
        }).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.deleteItemToCart = function (productId) {
        $http({
            url: contextPath + '/api/v1/cart/deleteId/' + productId,
            method: 'GET'
        }).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.clearCart = function () {
        $http({
            url: contextPath + '/api/v1/cart/clear',
            method: 'GET'
        }).then(function (response) {
           // $scope.loadCart();
           $scope.cart = null;
        });
    }

    $scope.createOrder = function () {
        $http({
            url: contextPath + '/api/v1/orders',
            method: 'POST',
            params: {
                phone: $scope.order_info.phone,
                address: $scope.order_info.address
            }
        }).then(function successCallback(response) {
            alert('Заказ создан');
            $scope.loadCart();
        }, function errorCallback(response) {
            alert(response.data.messages);
            console.log(response.data.messages);
        });
    }
    $scope.loadCart();
});