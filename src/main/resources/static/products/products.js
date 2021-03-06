angular.module('app').controller('productsController', function ($scope, $http, $localStorage) {
    const contextPath = 'http://localhost:8189/summer';

    $scope.loadPage = function (pageIndex = 1) {
        $http({
            url: contextPath + '/api/v1/products',
            method: 'GET',
            params: {
                'p': pageIndex,
                'min_price': $scope.product_filter ? $scope.product_filter.minPrice : null,
                'title': $scope.product_filter ? $scope.product_filter.title : null
            }
        }).then(function (response) {
            $scope.productsPage = response.data;
            $scope.navList = $scope.generatePagesIndexes(1, $scope.productsPage.totalPages);
            console.log(response.data);
        });
    };

    $scope.addToCart = function (productId,amount) {
        $http({
            url: contextPath + '/api/v1/cart/add/' + productId + '/' + amount,
            method: 'GET'
        }).then(function (response) {
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
});