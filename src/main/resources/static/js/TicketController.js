'use strict';
 
angular.module('app').controller('TicketController', ['$scope', 'TicketService', '$location', function($scope, TicketService, $location) {
    var self = this;
    
    self.previousPackagesSize = 3;
    self.patchingVersionsSize = 3;
    
    self.ticket = {
		id : null,
		name : '',
		dateTime : '',
		customer : '',
		previousPackages : new Array(self.previousPackagesSize),
		patchingVersions : new Array(self.patchingVersionsSize)
	};

    self.tickets = [];
    
    self.myOptions = [
                        {a:"Quality Assurance", b:"Quality Assurance"},
                        {a:"User Acceptance", b:"User Acceptance"},
                        {a:"Production", b:"Production"}];
  

    
    

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
    self.showBugs = showBugs;
    
    $scope.propertyName = 'name';
    $scope.reverse = true;
    $scope.friends = self.tickets;

    $scope.sortBy = function(propertyName) {
      $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
      $scope.propertyName = propertyName;
    };
 
    findAllTickets();
 
    function findAllTickets(){
    	TicketService.findAllTickets()
            .then(
            function(d) {
                self.tickets = d;
            },
            function(errResponse){
                console.error('Error while fetching tickets');
            }
        );
    }
    
    function createTicket(ticket){
    	TicketService.createTicket(ticket)
            .then(
            findAllTickets,
            function(errResponse){
                console.error('Error while creating ticket');
            }
        );
    }
 
    function updateTicket(ticket){
    	TicketService.updateTicket(ticket)
            .then(
            findAllTickets,
            function(errResponse){
                console.error('Error while updating ticket');
            }
        );
    }
 
    function deleteTicket(id){
    	TicketService.deleteTicket(id)
            .then(
            findAllTickets,
            function(errResponse){
                console.error('Error while deleting ticket');
            }
        );
    }
 
    function submit() {
        if(self.ticket.id===null){
            console.log('Saving New Ticket', self.ticket);
            createTicket(self.ticket);
        }else{
            updateTicket(self.ticket);
            console.log('Ticket updated with id ', self.ticket.id);
        }
        reset();
    }
 
    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.tickets.length; i++){
            if(self.tickets[i].id === id) {
                self.ticket = angular.copy(self.tickets[i]);
                break;
            }
        }
    }
 
    function remove(id){
        console.log('id to be deleted', id);
        if(self.ticket.id === id) {//clean form if the ticket to be deleted is shown there.
            reset();
        }
        deleteTicket(id);
    }

    function showBugs(id) {
    	$location.path('/bugs/'+id);
    }
    
    function reset(){
	    self.ticket = {
			id : null,
			name : '',
			dateTime : '',
			customer: ''
		};
    	$scope.myForm.$setPristine(); //reset Form
    }
 
}]);