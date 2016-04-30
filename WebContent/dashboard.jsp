<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>Insert title here</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.11/css/jquery.dataTables.css">
<link href="css/dashboard.css" rel="stylesheet">
</head>
<body>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Nom du site</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Dashboard</a></li>
				<li><a href="#">Create a Degree</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right inline-form">
				<li><a href="login">Log Out</a></li>
			</ul>
		</div>
		</nav>
		<div id="degreeList" class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">List of degrees</h3>
			</div>
			<table id="degreeTable" class="table table-striped table-condensed">
				<thead>
					<tr>
						<th>Name</th>
						<th>Level</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>DUT</td>
						<td>BAC + 2</td>
						<td>
							<button class="btn-success">Update</button>
							<button class="btn-danger">Delete</button>
						</td>
					</tr>
					<tr>
						<td>License</td>
						<td>BAC + 3</td>
						<td>
							<button class="btn-success">Update</button>
							<button class="btn-danger">Delete</button>
						</td>
					</tr>
			</table>
		</div>
		<div id="degreeForm" class="panel panel-primary hidden">
		
		</div>
	</div>
	<script src="js/jquery-1.12.3.min.js"></script>
	<script type="text/javascript" charset="utf8"
		src="//cdn.datatables.net/1.10.11/js/jquery.dataTables.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="js/dashboard.js"></script>
</body>
</html>