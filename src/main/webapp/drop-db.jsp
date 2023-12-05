<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="index.jsp"></jsp:include> <br><br>
	
	<div style="text-align:center; padding:20px; margin: auto 10%">
	<form method="post" action="drop-db">
		<fieldset>
			<legend>Drop Database Form</legend>
			
			Enter DB Name : <input type="text" name="db_name" id="name"> <br><br>
			
			<input type="submit"  value="Drop DB">
		</fieldset>
	</form>
	</div>
</body>
</html>