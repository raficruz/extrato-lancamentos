app.factory("lancamentosFactory", function($http){
 
    var factory = {};
 
    factory.readLancamentos = function(){
        return $http({
            method: 'GET',
            url: 'http://localhost:8080/lancamentos'
        });
    };

    factory.readLancamentosJson = function(){
        return $http({
            method: 'GET',
            url: 'http://localhost:8080/lancamentos/json'
        });
    };

    return factory;
});