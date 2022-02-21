# E-CommerceSiteWithAngularAndSpringBoot
Backend of e-commerce project


1. Project uses MySQL database for persisting data.
- use data base scripts at \project\E-CommerceSiteWithAngularAndSpringBoot\src\main\db-scripts for creating db tables and their relations.

2. Project's API Endpoints are documented using Swagger. After running app you can reach documentation using http://localhost:8080/swagger-ui/index.html

3. Backend accepts both JSON and XML structures.
4. /orders endpoint is secured using Okta authentication server with JWT
5. Https Rest API's
6. Sends credit card payment using stripe infrastructure