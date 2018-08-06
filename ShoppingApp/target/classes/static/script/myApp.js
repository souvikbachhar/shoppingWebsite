var app=angular.module('myApp',['ui.router']);

app.config(function ($StateProvider,$urlRouterProvider){
	$StateProvider
	.state('ShowData',{
		url: 'ShowData',
		templateUrl: 'Show.html'
	})
	.state('EditData',{
		url: 'EditData',
		templateUrl: 'Edit.html'
	})
});

app.factory("myFactory",function(){
	var savedData={}
	function set(data){
		saveddata=data;
	}
	function get(){
		return saveddata;
		
	}
	return {
		set: set,
		get: get
	}
});

app.controller("myCtrl",function($location){
	$location.path('ShowData');
});

app.controller("showCtrl",function($location,$scope,myFactory){
	$scope.Students=[1,2,3,4,5];
											
	
	$scope.Edit=function(d){
		myFactory.set(d);
		$location.path('/EditData');
	}
});

app.controller("editCtrl",function($location,$scope,myFactory){
	$scope.Student=myFactory.get();
	$scope.Back=function(){
		location.path('ShowData');
	}
});
