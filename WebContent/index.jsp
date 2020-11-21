<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AIMORC Login Page!</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#resultDiv').css('display', 'none');
		$('#submitFirstForm').click(function() {
			var data = {
				username : $('#username').val(),
				password : $('#password').val()
			};
			$.ajax({
				type : "POST",
				url : "SampleServlet",
				contentType : "application/json",
				data : JSON.stringify(data),
				success : function(result) {
					$('#resultDiv').css('display', 'block');
					$('#result1').css('display', 'block');
					$('#formContainer').css('display', 'none');
					$('#result1').html(result);
					console.log(result);
				},
				error : function(result){
				  $('#result1').html(result);
				  console.log(result);
				}
			});
		});
	});
</script>

</head>
<body>
	<div class="container" id="formContainer">
		<h1>Login Page!</h1>
		<form>
			<div class="form-group">
				<label for="username">Username:</label> 
				<input type="username" class="form-control" placeholder="Enter username" id="username">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> 
				<input type="password" class="form-control" placeholder="Enter password" id="password">
			</div>
			
			<button type="button" class="btn btn-primary" id="submitFirstForm">Submit</button>
		</form>
	</div>
	<div class="container" id="resultDiv">
		<h1>Response...</h1>
		<span id="result1"></span>
	</div>

</body>
</html>