'use strict';
 
angular.module('app').factory('ProjectService', ['$http', '$q', function($http, $q){
 
    var REST_SERVICE_URI = 'http://localhost:8080/';
 
    var factory = {
    	findAllProjects: findAllProjects,
        createProject: createProject,
        updateProject: updateProject,
        deleteProject: deleteProject
    };
 
    return factory;
 
    function findAllProjects() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+'projects')
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching projects');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function createProject(project) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI+'project', project)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating project');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
    function updateProject(project) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+'project', project)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating project');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function deleteProject(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+'project/'+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting project');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
}]);