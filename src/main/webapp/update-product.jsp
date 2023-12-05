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
	<form method="post" action="update-product">
		<fieldset>
			<legend>Update Product Form</legend>
			
			Product Id : <input type="text" name="product_id" id="name"> <br><br>
			Product Name : <input type="text" name="product_name" id="name"> <br><br>
			Product Description : <input type="text" name="product_desc" id="description"> <br><br>
			Product Price : <input type="text" name="product_price" id="price"> <br><br>
			
			<input type="submit"  value="Update Product">
		</fieldset>
	</form>
	</div>
</body>
</html>