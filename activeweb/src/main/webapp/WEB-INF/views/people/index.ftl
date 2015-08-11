<html lang="en">
<head>
<meta charset="UTF-8">
<title>Phonebook</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular.js"></script>
<script type="text/javascript" src="${context_path}/js/app.js"></script>
</head>
<body ng-app="phonebook">
	<div class="container" ng-controller="PhonebookController" ng-switch
		on="view">
		<div class="row">
			<div class="col-lg-6">
				<div class="input-group">
					<span class="input-group-addon">SEARCH</span> <input type="text"
						class="form-control" ng-model="query">
				</div>
			</div>
			<div class="col-lg-6">
				<div class="btn-group pull-right">
					<button type="button" class="btn btn-default"
						ng-click="view='list'">
						<span class="glyphicon glyphicon-th-large"></span>
					</button>
					<button type="button" class="btn btn-default"
						ng-click="view='table'">
						<span class="glyphicon glyphicon-th-list"></span>
					</button>
				</div>
			</div>
		</div>
		<div ng-switch-when="list">
			<pb-person-card ng-repeat="person in persons | filter:query "
				person="person"></pb-person-card>
		</div>
		<table class="table" ng-switch-when="table">
			<thead>
				<tr>
					<th>#</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Address</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="p in persons | filter:query">
					<td>{{$index + 1}}</td>
					<td>{{p.first_name}}</td>
					<td>{{p.last_name}}</td>
					<td>{{p.address}}</td>
				</tr>
			</tbody>
		</table>

		<form name="registerForm" ng-controller = "RegisterController as registerCtrl" 
								  ng-submit = "registerCtrl.doRegistration(user)">
			<script>
				
			</script>
			<blockquote>
				<b>{{user.first_name}} {{user.last_name}} {{user.address}}
			</blockquote>
			<input ng-model="user.first_name" type="text"  value="Victar" />
			<input ng-model="user.last_name" type="text" value="Kadol"/>
			<input ng-model="user.address" type="url" value="http://victar.me"/>
			<input type="submit" value="Register" />
		</form>
	</div>
</body>
</html>