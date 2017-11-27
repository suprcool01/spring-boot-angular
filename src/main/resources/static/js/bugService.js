'use strict';
 
angular.module('app').factory('BugService', ['$http', '$q', function($http, $q){
 
    var REST_SERVICE_URI = 'http://localhost:8080/';
 
    var factory = {
    	findAllBugs: findAllBugs,
        createBug: createBug,
        updateBug: updateBug,
        deleteBug: deleteBug
    };
 
    return factory;
 
    function findAllBugs(projectId) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+'project/id/'+projectId)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching bugs');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function createBug(bug) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI+'bug', bug)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating bug');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
    function updateBug(bug) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+'bug', bug)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating bug');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function deleteBug(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+'bug/'+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting bug');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
}]);