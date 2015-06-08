var app = angular.module('phonebook', []);

app.controller('PhonebookController', function ($scope, JSONService ){
	var promise = JSONService.list();
	promise.then(function (data){
		$scope.persons = data;
		$scope.view = 'table';
		console.log(data);
	})
})
app.service('JSONService' , function ($http, $q){
	
	var deffered = $q.defer();
	$http.get('/Json').then(function (data){
		deffered.resolve(data.data);
	});
	
	this.list = function (){
		return deffered.promise;
	}
});
