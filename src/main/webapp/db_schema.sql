
// create a dabase
> create database estore_zone_db;

// use database;
> use estore_zone_db;

> select  database();

// create table
> create table eproducts(product_id int  primary key auto_increment, product_name varchar(100), price decimal(10,2), 
  product_desc varchar(255), create_at timestamp default now());
  
>  select * from eproduct;



// store procedure 

	DELIMITER &&

	CREATE PROCEDURE insert_product_info(IN p_name varchar(100), IN p_price int, IN p_dec varchar(255))
	BEGIN 
		INSERT INTO eproducts(product_name,price,product_desc) values (p_name,p_price,p_dec);
	END &&
	DELIMITER ; 
    
	---
    
	DELIMITER &&

	CREATE PROCEDURE total_product_info()
	BEGIN 
		SELECT COUNT(*) FROM eproducts ; 
	END &&
	DELIMITER ; 