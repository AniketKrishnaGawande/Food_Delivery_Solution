# FoodDeliveryPortal

## Document:
System Requirement Specification Document

## Title:
System Reqruiement Spefication for Online Food Delivery Portal

## Team: 
Direct Customer,Indirect Customer, Architect,Business Analyst,	Quality Assurance Team, System Analyst

## Objective (Purpose):
The online food delivery portal is intended to  provide complete solution for hoteliers, Consumers as well as internal users (Staff) through  a single Gateway using internet. It will enable hoteliers to set up online restaurants, customers to browse through virtual restaurants and order meals online without visiting the restaurants physically.

## Scope:
This System will allow hoteliers to setup their restaurents virtually and provide food facilities to customers.
Customers can order food from registered restaurents online using this web based platform and they can cancel their orders till restaurant did not accept it.
Customer can track order history through login.
Delivery boy will be assigned to each order based on availibilty and order will be delivered to customer.
for better integration between customers and hoteliers, internal staff will be having extra privileges. 

## Definitions:
	<!-- OSS: Online Shopping System
	QA:  Quality Assurance
	Portal: Peronalized Online Web Application
	MIS: Management Information System
	CRM: Customer Relation Managment
	BI:  Business Intelligence
	KPI:Key Performance I
	Dashboard: Personalized information presented using  BI techniques such grid, score card, graph, KPI -->


## Functional Requirements:
---> Customer View:

Annonymous customers will be able to visit any virtual restaurant and can lookup their food menu and prices.
Customers can go through various dishes offered by various restaurants and can apply filters based on meals(breakfast,lunch,dinner).
After registration, customers can add food items into the cart and place order for desired location. before placing order, customers have to pay order amount by UPI, Debit card, credit card. Placed orders will be notified to restaurants. Orders can be cancelled by customer till it is not confirmed by restaurant.
Prepared orders will be assigned to available delivery boy.Customers can track their ordered food status.
Customers can check ordered history as well. 
Customers can give ratings to restaurants from which order is placed.
customers can change their profile cridentials.
during registration customer have to give address and they can add different delivery address while placing order. each customer can register maximum three address.
for successfully delivered orders, customers can give ratings to delivery boy and restraurants
<-- future may be possible -- customers can apply coupone code while payment --> 

--->Hoteliers view
Hoteliers need to do registration before creating virtual restrautant and this registrations request will be approved by system staff after some verification.
Registered hoteliers will be able promote their dishes for sale by adding it to the catalog maintained by the System.
hoteliers are allowed to give dishes based on type of meals (breakFast, main course, breads, rice, soup, beverages etc) fixed structure will be given by system to maintain uniformity
Hotelier will be able to update dish details which have been already added to catalog.
Dishes listing will be provided based on their category.
Hoteliers will have to inform about status of order like order being prepared, order is ready and waiting for delivery boy, dispatched orders for deliveries to the system and change the status of orders.
hotels will be shown to customers iff hoteliers are signedin and accepting orders else it will be considered that restraurant is closed to accept orders.
also restraurant managers will have authority to block system to assign orders to them.  
they can check history of orders delivered from their hotels


-----> System staff
system staff have authority to verify and approve registration request of hoteliers as well as they will be having authority of de-register restraurants in case of any misuse.
they can monitor details of hoteliers along with their menu.
System staff will be having authority to see unsensitive details of Customer and able to track the order. they will have all information of placed orders
System will be able to cancel , reject or approve orders been placed by customers due to some policies of business.
in case of any issue customers can contact to support team of system staff.
<-- future if poosbble system staff can set coupone code in system so that customers will get occasional discount>

----> delivery boy
orders which are placed successfully and under preparing status will be assigned to available delivery boy. delivery boy will get information about order like pickup hotel address, delivery location, mobile number of customer
delivery boy have to update status of order once it is picked up from retrarants and after it it delivered to customer.
once delivery boy logged in to their account they will be available to take orders and orders will be assigned to them  automatically based on availibility

<-- future if possible delivery boys will be recruted by staff of system --> 
<-- payments system> 
