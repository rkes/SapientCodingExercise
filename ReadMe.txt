Maven is mandatory

Framework Used :- Spring Boot
Database :- H2 Database
Container for each microservices :- Tomcat

To Run Services :-
go to each services , open command line and run command -----> mvn spring-boot:run
for e.g. :- 
	$ catalog-microservice > mvn spring-boot:run

Assumptions :-

Please add few Product with createNewProduct API for better demo
	
In Subsequent Step I have used localhost as host , however we can have any host	

To check H2 DB console for each services :- http://localhost:8080/console [for catalog-microservice] , http://localhost:8090/ [Price MicroServices]
------------------------------------------------------------------------------------------------
catalog-microservice :-
	It Runs on 8080 port
	API :- 
		a) Create New Product :- http://localhost:8080/addProduct?price=99.33     [POST]
		b) get all product :- http://localhost:8080/getAllProduct                 [GET]
		c) get all Product By Type :- http://localhost:8080/getProductByType?type="Mobile"     [GET]
		d) get First Occurance of Product By Name  :- http://localhost:8080/getProduct?name=Iphone 7 Plus    [GET]
		e) remove product :- http://localhost:8080/removeProduct/{productId}   [DELETE]
		f) Update Product Price :- http://localhost:8080/updateProductPrice/{productId}    [PUT]
---------------------------------------------------------------------------------------------------
Price MicroServices :-
		It Runs on 8090 Port
		a) Create New Price :- http://localhost:8090/addPrice/1900   [Post]
		b) Get Price of a priceId :- http://localhost:8080/getPrice/{priceId}  [GET]
		c) Update Price :- http://localhost:8080/updatePrice   [PUT]
		d) Remove Price :- http://localhost:8090/removePrice/{priceId}   [DELETE] 