'use strict';
 
angular.module('app').controller('BugController', ['$scope', '$routeParams', 'BugService', function($scope, $routeParams, BugService) {
    var self = this;
    self.bug = { id: null, name:'', bugId: '', location: '', status: '',type: '',projectId: '' };
    
  
    self.bugs = [];
 
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
    
    $scope.projectId = $routeParams.ID;
    $scope.propertyName = 'location';
    $scope.reverse = true;
    $scope.friends = self.bugs;

    $scope.sortBy = function(propertyName) {
    	console.log("Test");
      $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
      $scope.propertyName = propertyName;
    };
 
    findAllBugs();
 
    function findAllBugs(){
    	/*var projectId = $routeParams.ID;*/
    	console.log("projectId : " + $scope.projectId)
    	
    	BugService.findAllBugs($scope.projectId)
            .then(
            function(d) {
                self.bugs = d.bugs;
            },
            function(errResponse){
                console.error('Error while fetching bugs');
            }
        );
    }
 
    function createBug(bug){
    	bug.projectId = $scope.projectId;
    	console.log("saving bug"+bug);
    	BugService.createBug(bug)
            .then(
            findAllBugs,
            function(errResponse){
                console.error('Error while creating bug');
            }
        );
    }
 
    function updateBug(bug){
    	BugService.updateBug(bug)
            .then(
            findAllBugs,
            function(errResponse){
                console.error('Error while updating bug');
            }
        );
    }
 
    function deleteBug(id){
    	BugService.deleteBug(id)
            .then(
            findAllBugs,
            function(errResponse){
                console.error('Error while deleting bug');
            }
        );
    }
 
    function submit() {
        if(self.bug.id===null){
            console.log('Saving New Bug', self.bug);
            createBug(self.bug);
        }else{
            updateBug(self.bug);
            console.log('Bug updated with id ', self.bug.id);
        }
        reset();
    }
 
    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.bugs.length; i++){
            if(self.bugs[i].id === id) {
                self.bug = angular.copy(self.bugs[i]);
                break;
            }
        }
    }
 
    function remove(id){
        console.log('id to be deleted', id);
        if(self.bug.id === id) {//clean form if the bug to be deleted is shown there.
            reset();
        }
        deleteBug(id);
    }
 
 
    function reset(){
        self.bug={id:null, name:'', price:0.0, bugId: '', location: '', status: '',type: ''};
        $scope.myForm.$setPristine(); //reset Form
    }
 
}]);