app.controller('lancamentosController', function($scope, $timeout, lancamentosFactory) {

    $scope.datasourceDinamico = false;

    $scope.readLancamentosJson = function() {
        lancamentosFactory.readLancamentosJson()
        .then(function successCallback(response) {
            $scope.lancamentos = response.data.content;
        }, function errorCallback(response) {
            $scope.showToast("Unable to read record.");
        });
    };

    $scope.readLancamentos = function() {
        if(!$scope.datasourceDinamico){
            return $scope.readLancamentosJson();
        }

        lancamentosFactory.readLancamentos()
        .then(function successCallback(response) {
            $scope.lancamentos = response.data.content;
        }, function errorCallback(response) {
            $scope.showToast("Unable to read record.");
        });

        $timeout( function () {
          $scope.readLancamentos();
        }, 30000);

    };

    $scope.onChange = function(cbState) {
        $scope.datasourceDinamico = cbState;

        if( $scope.datasourceDinamico ) {
            $scope.readLancamentos();
        } else {
            $scope.readLancamentosJson();
        }
    };

});
