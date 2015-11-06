(function(){
	var app = angular.module('phonebook', []);

	app.controller('PhonebookController', function ($scope, JSONService ){
		var promise = JSONService.list();
		promise.then(function (data){
			$scope.persons = data;
			$scope.view = 'table';
			console.log(data);
		})
	});


	app.controller('RegisterController',["$http", function($http){

		this.register = {};
		this.doRegistration = function(user){

			$http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
			$http({
				method: "post",
				url: "people/create",
				data: $.param(user)
			}).success(function(data,status,headers,config){
				console.log("ToDo handle success");
			}).error(function(data,status,headers, config){
				console.log("ToDo handle error");
			})
		}
	}]);


	app.service('JSONService' , function ($http, $q){

		var deffered = $q.defer();
		$http.get('/Json').then(function (data){
			deffered.resolve(data.data);
		});

		this.list = function (){
			return deffered.promise;
		}
	});
})();