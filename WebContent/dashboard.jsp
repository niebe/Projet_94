<%@page import="model.Degree"%>
<%@page import="model.Field"%>
<%@page import="java.util.List"%>
<%@page import="model.Template"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>Easy Web Input - Dashboard</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.11/css/jquery.dataTables.css">
<link href="css/dashboard.css" rel="stylesheet">
</head>
<body>
<body>
	<% Integer profileId = (Integer) request.getAttribute("profileId");%>
	<div class="container">
		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Easy Web Input</a>
			</div>
			<ul class="nav navbar-nav">			
				<li class="active"><a id="templateBtn" href="#"><% if(profileId == 1)out.print("Template");else{ out.print("Degrees");}%></a></li>
				<li><a href="#" id="btnCreateTemplate">Create a <% if(profileId == 1)out.print("Template");else{ out.print("Degree");}%></a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right inline-form">
				<li><a href="logout">Log Out</a></li>
			</ul>
		</div>
		</nav>		
		<% if(profileId == 1){%>
			<div id="templateList" class="panel panel-primary listElement">			
				<div class="panel-heading">
					<h3 class="panel-title">Template</h3>
				</div>
				<% if(request.getAttribute("template") != null) { model.Template template = (model.Template) request.getAttribute("template");%>
					<div class="panel-body">
						<h3 id="templateTitle"><%out.print("Title : " + template.getTitle());%></h3>
						<%
							List<Field> fields =(List<Field>) request.getAttribute("fields");
							for(int i = 0; i < fields.size();i++)
								out.print("<div>"+fields.get(i).getName() + " : <input value='" + fields.get(i).getType() +"...' type='text' disabled/></div>");					
						%>
					</div>
					<input type="text" class="hidden" id="templateId" value="<%out.print(template.getId());%>" />
				<% } %>
			</div>
			<div id="templateForm" class="panel panel-primary elementForm">
				<form action="template" method="post">
					<div class="form-group">
				    	<label for="templateName">Template Name : </label>
		    			<input type="text" class="form-control" name="templateName" required>
					</div>
					<div class="form-group form-inline fieldInput">
						<input name='fieldLabel' class='form-control' type='text' placeholder='Label of field' />					
						<select class='form-control' name='fieldType'>
							<option value="number">Number</option>
							<option value="text">Text</option>
							<option value="date">Date</option>
						</select>
					</div>
					<button id="addFieldBtn" class="btn btn btn-primary"><i class="fa fa-plus"></i> Add a field</button>
					<button id="saveModifTemplate" type="submit" class="btn btn btn-success pull-right">Send</button>
				</form>
			</div>
		<% }else{ List<Degree> degrees =(List<Degree>) request.getAttribute("degrees"); %>
			<div id="degreeList" class='listElement'>
				<div class="panel-heading">
						<h3 class="panel-title">Degrees</h3>
				</div>
				<div class="panel-body">
				<table id="degreeTable" class="table table-striped table-condensed">
					<thead>
						<tr>
							<th>Degree (code)</th>
							<th>Template</th>							
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
					<% for(int i = 0; i < degrees.size(); i++){ %>	
						<tr>
							<td><% out.print(degrees.get(i).getCodTitle()); %></td>
							<td><% out.print(degrees.get(i).getTemplate().getTitle()); %></td>							
							<td>
								<button class="btn-success">Update</button>
								<button class="btn-danger">Delete</button>
							</td>
						</tr>
					<% } %>
				</table>			
				</div>			
			</div>
			<div id="degreeForm" class="elementForm">
				<% if(request.getAttribute("template") != null) { 
					model.Template model = (model.Template) request.getAttribute("template");
					List<Field> questions =(List<Field>) request.getAttribute("fields");
				%>
				<form action="degree" method="post">
					<div class="form-group">
				    	<h3><% out.print(model.getTitle());%></h3>
					</div>
		    		<input type="text" class="form-control" name="degreeId" style="display:none">
					<div class="form-group form-inline">
				    	<label for="degreeCodTitle">Degree ID : </label>
		    			<input type="text" class="form-control" name="degreeCodTitle" class="hidden">
					</div>
					<% for(int i = 0 ; i < questions.size(); i++){ %>
						<div class="form-group form-inline degreeFieldInput">
							<label><% out.print(questions.get(i).getName() + " : "); %></label>
							<% if(questions.get(i).getType().toLowerCase().equals("number")){ %>
								<input name='value_<% out.print(questions.get(i).getId());%>' class='form-control' type='text' placeholder='Enter a number...' />					
							<% }else if(questions.get(i).getType().toLowerCase().equals("text")){ %>
								<input name='value_<% out.print(questions.get(i).getId());%>' class='form-control' type='text' placeholder='Please complete...' />
							<% }else if(questions.get(i).getType().toLowerCase().equals("date")){ %>	
								<input name='value_<% out.print(questions.get(i).getId());%>' class='form-control' type='text' placeholder='Choose a date...' />
							<% } %>	
						</div>
					<% }%>
					<button id="saveDegree" type="submit" class="btn btn btn-success pull-right">Send</button>
				</form>
				<% }else{%>
					<h3>No template available</h3>
				<% }%>
			</div>
		<% } %>
	</div>
	<script src="js/jquery-1.12.3.min.js"></script>
	<script type="text/javascript" charset="utf8"
		src="//cdn.datatables.net/1.10.11/js/jquery.dataTables.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="js/dashboard.js"></script>
</body>
</html>