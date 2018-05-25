'use strict';
 
angular.module('app').factory('TicketService', ['$http', '$q', function($http, $q){
 
    var REST_SERVICE_URI = 'http://localhost:8080/';
 
    var factory = {
    	findAllTickets: findAllTickets,
        createTicket: createTicket,
        updateTicket: updateTicket,
        deleteTicket: deleteTicket
    };
 
    return factory;
 
    function findAllTickets() {
        var deferred = $q.defer();
        
        $http.get(REST_SERVICE_URI+'tickets')
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching tickets');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function createTicket(ticket) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI+'ticket', ticket)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating ticket');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
    function updateTicket(ticket) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+'ticket', ticket)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating ticket');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function deleteTicket(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+'ticket/'+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting ticket');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
}]);