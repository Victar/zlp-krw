var app = angular.module('phonebook', []);

app.controller('StoreController', function (){
	this.data= { name: 'Gem',
				price:3.49}
	
})

app.controller('PhonebookController', function ($scope, JSONService ){
	var promise = JSONService.list();
	promise.then(function (data){
		$scope.persons = data;
		$scope.view = 'table';
		console.log(data);
	})
})


app.controller('RegisterController', function($http){
	this.register = {};
	this.doRegistration = function(user){
		//Todo
		
		//this.register = {};
		$http.post('people/create' , user);
	}
	
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
