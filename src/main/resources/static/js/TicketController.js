'use strict';
 
angular.module('app').controller('TicketController', ['$scope', 'TicketService', '$location', function($scope, TicketService, $location) {
    var self = this;
    
    self.project = {
		id : null,
		name : '',
		description : '',
		dataTime : ''
	};

  
    self.projects = [];
 
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
    self.showBugs = showBugs;
    
    $scope.propertyName = 'name';
    $scope.reverse = true;
    $scope.friends = self.projects;

    $scope.sortBy = function(propertyName) {
    	console.log("Test");
      $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
      $scope.propertyName = propertyName;
    };
 
    findAllProjects();
 
    function findAllProjects(){
    	TicketService.findAllProjects()
            .then(
            function(d) {
                self.projects = d;
            },
            function(errResponse){
                console.error('Error while fetching projects');
            }
        );
    }
    
    function createProject(project){
    	TicketService.createProject(project)
            .then(
            findAllProjects,
            function(errResponse){
                console.error('Error while creating project');
            }
        );
    }
 
    function updateProject(project){
    	TicketService.updateProject(project)
            .then(
            findAllProjects,
            function(errResponse){
                console.error('Error while updating project');
            }
        );
    }
 
    function deleteProject(id){
    	TicketService.deleteProject(id)
            .then(
            findAllProjects,
            function(errResponse){
                console.error('Error while deleting project');
            }
        );
    }
 
    function submit() {
        if(self.project.id===null){
            console.log('Saving New Project', self.project);
            createProject(self.project);
        }else{
            updateProject(self.project);
            console.log('Project updated with id ', self.project.id);
        }
        reset();
    }
 
    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.projects.length; i++){
            if(self.projects[i].id === id) {
                self.project = angular.copy(self.projects[i]);
                break;
            }
        }
    }
 
    function remove(id){
        console.log('id to be deleted', id);
        if(self.project.id === id) {//clean form if the project to be deleted is shown there.
            reset();
        }
        deleteProject(id);
    }

    function showBugs(id) {
    	$location.path('/bugs/'+id);
    }
    
    function reset(){
	    self.project = {
			id : null,
			name : '',
			description : '',
			dataTime : ''
		};
    	$scope.myForm.$setPristine(); //reset Form
    }
 
}]);