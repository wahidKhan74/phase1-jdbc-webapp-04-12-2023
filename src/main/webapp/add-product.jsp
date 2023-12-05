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
	<form method="post" action="add-product">
		<fieldset>
			<legend>Add Product Form</legend>
			
			Product Name : <input type="text" name="product_name" id="name"> <br><br>
			Product Description : <input type="text" name="product_desc" id="description"> <br><br>
			Product Price : <input type="text" name="product_price" id="price"> <br><br>
			
			<input type="submit"  value="Add Product">
		</fieldset>
	</form>
	</div>
</body>
</html>