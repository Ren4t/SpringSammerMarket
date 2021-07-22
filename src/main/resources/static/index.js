angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/summer'
    // $scope.loadProducts = function () {
    //     $http({
    //         url: contextPath + '/api/v1/products',
    //         method: 'GET',
    //         params: {}
    //     }).then(function (response) {
    //         console.log(response);
    //         //$scope.products = response.data;
    //         $scope.loadPage($scope.page);
    //     });
    // };

    $scope.loadPage = function (pageIndex) {
        $scope.page = pageIndex;
        $http({
            url: contextPath +  '/api/v1/products',
            method: 'GET',
            params: {
                'p': pageIndex
            }
        }).then(function (response) {
            console.log(response);
            $scope.productsPage = response.data;
            $scope.navList = $scope.generatePagesIndexes(1,$scope.productsPage.totalPages)
        });
    };


    $scope.showProductInfo = function (productIndex) {
        $http({
            url: contextPath + '/api/v1/products/' + productIndex,
            method: 'GET'
        }).then(function (response) {
            alert(response.data.title);
        });
    };

    $scope.deleteProduct = function (productIndex) {
            $http({
                url: contextPath + '/api/v1/products/' + productIndex,
                method: 'DELETE'
            }).then(function (response) {
                $scope.loadPage();
            });
        };

    $scope.generatePagesIndexes = function(startPage, endPage){
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);        
        }
        return arr;
    }

    $scope.loadPage();
});