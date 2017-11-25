app.controller('usersController', function($scope) {
    $scope.headingTitle = "User List";
});

app.controller('rolesController', function($scope) {
    $scope.headingTitle = "Roles List";
});



app.controller('projectController', function($scope){
  $scope.message = "Project List";
  $scope.selected= {};
  $scope.projects = [
		   { 	'id':1,
				'name':'Invoice Management',
				'desc': 'All bugs related to invoice'
			},
			{ 	'id':2,
				'name':'Invoice Management',
				'desc': 'All bugs related to invoice'
			}
  ];
  
  $scope.addRow = function(){	
	$scope.projects.push({ 'id':$scope.id,'name':$scope.name, 'desc':$scope.desc });
	$scope.name='';
	$scope.desc='';
	$scope.reset();
	$scope.selected.id='';
};

$scope.getTemplate = function (project) {
		if(project && 
			project.id === $scope.selected.id) {
			return 'edit';
		}
        return 'display';
    };

    $scope.editContact = function (project) {
        $scope.selected = angular.copy(project);
    };
	
	 $scope.saveContact = function (idx) {
		alert(idx);
        console.log("Saving project");
        $scope.projects[idx] = angular.copy($scope.selected);
        $scope.selected.id='';
        $scope.reset();
    };
	
	$scope.reset = function () {
        $scope.selected = {};
		
    };
$scope.removeRow = function(name){	
				alert(name);
		var index = -1;		
		var comArr = eval( $scope.projects );
		for( var i = 0; i < comArr.length; i++ ) {
			if( comArr[i].name === name ) {
				index = i;
				break;
			}
		}
		if( index === -1 ) {
			alert( "Something gone wrong" );
		}
		$scope.projects.splice( index, 1 );		
	};
});

