var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/users',{
            templateUrl: '/views/users.html',
            controller: 'usersController'
        })
        .when('/roles',{
            templateUrl: '/views/roles.html',
            controller: 'rolesController'
        })
        .when('/projects',{
            templateUrl: '/views/projects.html',
            controller: 'projectController'
        })
        .when('/new_projects',{
            templateUrl: '/views/new_project.html',
            controller: 'ProjectController'
        })
        .when('/bugs/:ID',{
            templateUrl: '/views/bugs.html',
            controller: 'BugController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});

