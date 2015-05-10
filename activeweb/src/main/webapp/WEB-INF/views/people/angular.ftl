<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Phonebook</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular.js"></script>
    <script type="text/javascript" src="${context_path}/js/app.js"></script>
</head>
<body ng-app="phonebook">
    <div class="container" 
        ng-controller="PhonebookController"
        ng-switch on="view">
        <div class="row">
            <div class="col-lg-6">
                <div class="input-group">
                  <span class="input-group-addon">SEARCH</span>
                  <input type="text" class="form-control" ng-model="query">
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
            <pb-person-card 
                ng-repeat="person in persons | filter:query "
                person="person"></pb-person-card>  
        </div>
        <table class="table" ng-switch-when="table">
          <thead>
            <tr>
              <th>#</th>
              <th>Name</th>
              <th>Company</th>
              <th>Phone</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="p in persons | filter:query">
              <td>{{$index + 1}}</td>
              <td>{{p.name}}</td>
              <td>{{p.company}}</td>
              <td>{{p.phone}}</td>
            </tr>
          </tbody>
        </table>
    </div>
</body>
</html>