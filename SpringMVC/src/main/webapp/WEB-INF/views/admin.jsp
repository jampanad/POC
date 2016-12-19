
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
           
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

 <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
 
<script type="text/javascript">
            var app = angular.module("Student", []);
         
            //Controller Part
            app.controller("StudentController", function($scope, $http,$window) {
            
            $scope.action = "create";
            $scope.updateUrl = {};
            //update the student
            $scope.update = function (studentUrl){
		        $http.get(studentUrl).success(function(data) {
		        		$scope.form={};
            			$scope.form.name=data.name;
            			$scope.form.section=data.section;
            			$scope.form.age=data.age;
						$scope.form.address=data.address;
						$scope.action = "update";
						$scope.updateUrl = studentUrl;
					});
		    }
            
            //Deleting students
           $scope.delete = function (studentUrl){
		        $http.delete(studentUrl).success(function(data) {
						$window.location.href = '/'
					});
		    }
                    var url = angular.element(document.getElementsByName('serviceUrlHome')[0]).val();
               console.log("url value is "+url);
               //Loading all the students
            	$scope.refresh = function (){
            	//alert(0);
            	$http.get(url).success(function(data) {
						$scope.students = data._embedded.students;
				});
				}
				
				//Adding a student
                $scope.submitStudent = function() {
                
                	if($scope.action == 'create') {
                     $http.post(url,angular.toJson($scope.form)).
                     then(function(response){
                     console.log(response);
					 $window.location.href = '/'
                     });
                     }
                     else {
                     	$http.put($scope.updateUrl,angular.toJson($scope.form)).
                     then(function(response){
					 $window.location.href = '/'
                     });
                     }
                   
                };
                });
 </script>
 </head>
 
<div class="col-md-6 col-md-offset-3">
<body ng-app="Student" ng-controller="StudentController" data-ng-init="refresh()">

	 <input type="hidden" name="serviceUrlHome" value="${serviceMessage}" >
	<form class="form-horizontal" ng-submit="submitStudent()">
	  <div class="form-group" >
	    <label class="control-label col-sm-2">Name:</label>
	    <div class="col-sm-5">
	      <input type="text" class="form-control" ng-model="form.name" placeholder="Enter name">
	    </div>
	  </div>
	  <div class="form-group" >
	    <label class="control-label col-sm-2">Section:</label>
	    <div class="col-sm-5">
	      <input type="text" class="form-control" ng-model="form.section" placeholder="Enter section">
	    </div>
	  </div>
	  <div class="form-group" >
	    <label class="control-label col-sm-2">Age:</label>
	    <div class="col-sm-5">
	      <input type="text" class="form-control" ng-model="form.age" placeholder="Enter age">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-2" for="pwd">Address:</label>
	    <div class="col-sm-5"> 
	      <input type="text" class="form-control"  ng-model="form.address" placeholder="Enter address">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-5"> 
	      <input type="submit" class="form-control" value="Submit" />
	    </div>
	  </div>
	  </form>
	  
	<table ng-table="tableParams" class="table table-bordered">
    <thead>
      <tr>
        <th>No</th>
        <th>Name</th>
        <th>Section</th>
        <th>Age</th>
        <th>Address</th>
        <th></th>
      </tr>
    </thead>
  <tbody ng:repeat="i in students">
    <tr>
    <td>{{$index + 1}}</td>
    <td>{{i.name}}</td>
    <td>{{i.section}}</td>
    <td>{{i.age}}</td>
    <td>{{i.address}}</td>
    <td><input type="button" ng-click="delete(i._links.self.href)" class="btn btn-primary" value="Delete" />
    	<input type="button" ng-click="update(i._links.self.href)" class="btn btn-primary" value="Update" /></td>
    </tr>
  </tbody>
</table>
	  
</body>	
</div>
</html>
