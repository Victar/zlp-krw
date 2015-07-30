<html ng-app="SimpleModule">
<head>
<meta charset="UTF-8" />
<title>Sample module</title>
	<script type="text/javascript"	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular.js"></script>
</head>
<body ng-controller="MyController">
	<h1>Demo {{title}}</h1>
	<div>
		<p>
			<label for="valA">Input A:</label><input type="number" id="valA"
				ng-model=" valA" />
		</p>
		<p>
			<label for="valB">Input B:</label><input type="number" id="valB"
				ng-model=" valB" />
		</p>
		<p>Sum: {{result}}</p>
		<p>
			<button ng-click="add(valA,valB);">Sum</button>
			<button ng-click="multiple(valA,valB);">Mult</button>
		</p>
		</div>
</body>
</html>
<script type="text/javascript">

	var myApp = angular.module('SimpleModule', []);
	
	myApp.controller('MyController', ['$scope', function($scope) {
			$scope.title = 'Simple module'; 
			$scope.result = 0; 
			$scope.add = function(a,b) { $scope.result = a + b; }; 
			$scope.multiple = function(a,b) { $scope.result = a * b; }; 
		}
	]);
	
</script>