# Spring boot application for Market

- Contains Admin, Employee, Customer, Product and Invoice
- Invoice will generate csv/txt file

# Market Application flow structure
## customer:
- create, update, get, generate invoice
- add product items to list
- generate invoice
- csv, txt, store in local path
	
## product:
- create, create list, final product, can't update
- provide product unique id, so that customer can add that unique id

## order:
- order id as unique id
- contains customer id, product unique id's, total amount and discount
	
	

## Description:
	
- There is already define product list, which contains unique product id
- product can have product_id, unique_id, amount, product_name and quantity, and everything is store in as Set<Product> productList in productDto
- customer can choose unique product id and quantity*amount from product list
- add to customer_product_list as Map<String,BigDecimal> productList, contains product name and final amount (quantity*amount)
 


### UI Flow
- List provided
- checkbox for each product
- customer can login and select the products he want
- after checkout, all the details like customer_product_list and invoice_customer_id provided to invoice
- after successful order, invoice generate csv/txt/file and store it in DB/local path
- each order have it's own order_unique_id
- it contains order_unique_id, customer_id, payment_type, payment_order_status as success/failed
- payment_order_status will success after invoice generate file
- if invoice generate file fails then payment_order_status fails