
**Project Overview**

The API will generate unique tracking numbers based on the provided parameters like origin_country_id, destination_country_id, weight, created_at, customer_id, customer_name, and customer_slug. 

**Step 1:** Set up the Spring Boot Project

Project: Maven Project\
Language: Java\
Spring Boot Version: Latest\
Packaging: Jar\
Java Version: 17 or later

Dependencies:
Spring Web\
Spring Boot DevTools\
Spring Data JPA

**Step 2:** Design the API Endpoint

TrackingNumber Controller: The main endpoint /next-tracking-number will receive the query parameters and return the generated tracking number in TrackingNumberResponse.

**Step 3:** Implement Tracking Number Generation Logic in TrackingNumberService

This will generates a unique tracking number by hashing the combined input string. The first 16 characters of the hash are used to form the tracking number.

**Step 4:** Testing and Deployment

Unit Tests: Can use JUnit and Mockito to write unit tests for the TrackingNumberService and TrackingNumberController.

Integration Testing: Can test the API endpoint with different combinations of input parameters to ensure correct behavior.

Testing: Can perform load testing using tools like JMeter to verify that the system can handle high loads.

Hosted using ZohoCatalyst (click on below for output)

[GET /api/next-tracking-number?origin_country_id=MY&destination_country_id=ID&weight=1.234&created_at=2018-11-20T19:29:32 08:00&customer_id=de619854-b59b-425e-9db4-943979e1bd49&customer_name=RedBox Logistics&customer_slug=redbox-logistics
](https://hostingtrackingnumber-50023338739.development.catalystappsail.in/api/next-tracking-number?origin_country_id=MY&destination_country_id=ID&weight=1.234&created_at=2017-04-17T05:45:18.070Z&customer_id=de619854-b59b-425e-9db4-943979e1bd49&customer_name=RedBox%20Logistics&customer_slug=redbox-logistics)

{
  "tracking_number": "EF81F028E621F200",
  "created_at": "2024-11-06T04:12:31.754332781Z"
}
