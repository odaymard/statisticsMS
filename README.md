#Statistics Microservice

A spring-boot Microservice to calculate the request statistics for the last 60 seconds.

## Table of Contents
- [Requirements](#requirements)
- [Running](#running)
- [Todo](#Todo)
## Requirements
Java installed
## Running

Run `mvn spring-boot:run` to run the server on port 8080

  **To send sales-amount to our service**
 
 
` localhost:8080/api/v1/sales  
Method:POST
`

Payload :


`{
"sales_amount": 81.80
}`


`Status Code :202
`




 **To get statistics for the sales during the last 60 seconds**

`localhost:8080/api/v1/statistics 
Method:GET
`

Response

`{
"total_sales_amount": 500.0,
"average_amount": 100.0
}`

`Status Code :200
`





## Todo
 - Increaes the test coverage.
 - Use Docker.

