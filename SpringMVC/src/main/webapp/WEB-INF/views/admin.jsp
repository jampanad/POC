
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
           
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="/js/jquery-3.1.1.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="/js/bootstrap.min.js"></script>

 <script src = "/js/angular.min.js"></script>
 
<script src = "/js/controllers/student.js"> </script>
 <link rel="icon" href="favicon.png" type="image/png"/>
 </head>
 
<div class="col-md-6 col-md-offset-3">
<body ng-app="Student" ng-controller="StudentController" data-ng-init="refresh()">

	 <input type="hidden" name="serviceUrlHome" value="${serviceMessage}" >
	 <br>
	<form class="form-horizontal" name="myForm" novalidate ng-submit="myForm.$valid && submitStudent()">
	  <div class="form-group" >
	    <label class="control-label col-sm-2">Name:</label>
	    <div class="col-sm-5">
	      <input type="text" name="name" class="form-control" ng-model="form.name" placeholder="Enter name" required>
	      <span style="color:red" ng-show="myForm.name.$invalid && myForm.$touched">Name is required.</span>
	    </div>
	  </div>
	  <div class="form-group" >
	    <label class="control-label col-sm-2">Section:</label>
	    <div class="col-sm-5">
	      <input type="text" name="section" class="form-control" ng-model="form.section" placeholder="Enter section" required>
	      <span style="color:red" ng-show="myForm.section.$invalid && myForm.$touched">Section is required.</span>
	    </div>
	  </div>
	  <div class="form-group" >
	    <label class="control-label col-sm-2">Age:</label>
	    <div class="col-sm-5">
	      <input type="number"  class="form-control" name="age" ng-model="form.age" ng-pattern="/^[0-9]{2}$/" placeholder="Enter age" required>
	      <span style="color:red" ng-show="myForm.age.$invalid && myForm.$touched">Age is required.</span>
	      <span style="color:red" ng-show="myForm.age.$error.pattern && (myForm.$submitted || !myForm.$pristine)">Invalid Input</span>
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="control-label col-sm-2" for="pwd">Address:</label>
	    <div class="col-sm-5"> 
	      <input type="textarea" name="address" class="form-control"  ng-model="form.address" placeholder="Enter address" required>
	      <span style="color:red" ng-show="myForm.address.$invalid && myForm.$touched">Address is required.</span>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-5"> 
	      <input type="submit" class="form-control btn btn-primary" value="Submit" />
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
    <td><input type="button" ng-click="delete(i._links.self.href,$index)" class="btn btn-primary" value="Delete" />
    	<input type="button" ng-click="update(i._links.self.href)" class="btn btn-primary" value="Update" /></td>
    </tr>
  </tbody>
</table>

	<a href="/logout">logout</a>
	  
</body>	
</div>
</html>
