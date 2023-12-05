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
	<form method="post" action="multi-product-tx">
		<fieldset>
			<legend>Add Product 1 Form</legend>
			
			Product Name : <input type="text" name="product_name1" id="name"> <br><br>
			Product Description : <input type="text" name="product_desc1" id="description"> <br><br>
			Product Price : <input type="text" name="product_price1" id="price"> <br><br>
			
		</fieldset>
		<fieldset>
			<legend>Add Product 2 Form</legend>
			
			Product Name : <input type="text" name="product_name2" id="name"> <br><br>
			Product Description : <input type="text" name="product_desc2" id="description"> <br><br>
			Product Price : <input type="text" name="product_price2" id="price"> <br><br>
			
		</fieldset>
		
		<fieldset>
			<legend>Add Product 3 Form</legend>
			
			Product Name : <input type="text" name="product_name3" id="name"> <br><br>
			Product Description : <input type="text" name="product_desc3" id="description"> <br><br>
			Product Price : <input type="text" name="product_price3" id="price"> <br><br>
			
			<input type="submit"  value="Add Product">
		</fieldset>
	</form>
	</div>
</body>
</html>