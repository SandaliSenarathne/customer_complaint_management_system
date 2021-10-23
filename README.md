# customer_complaint_management_system
Mini project using Spring Boot, Thymeleaf, Hibernate, and MySQL. 

## Folder Structure
All the controllers, models, and repositories are in corresponding folders under **src/main/java/com/sandali/CustomerComplaintManagementSystem**

    controllers
    - ComplaintController.java
    - CustomerController.java
    - PackageController.java
    - SubscriptionController.java
  
	models
	- Complaint.java
	- Customer.java
	- Package.java
	- Subscription.java
  
	repository
	- ComplaintRepository.java
	- CustomerRepository.java
	- PackageRepository.java
	- SubscriptionRepository.java

All the views are in **src/main/resources/templates/** folder

## Project configurations
- Database configurations are in application.properties file. 
- Application is running on the default port **8080**.
- index.html page is returned on **localhost:8080/**

## Main functionalities
- Add/view/edit/delete customer details
- Add/view/edit/delete package details
- Add/view/edit/delete subscription details
- Add/view/edit/delete complaint details

### Find on Github
https://github.com/SandaliSenarathne/customer_complaint_management_system
