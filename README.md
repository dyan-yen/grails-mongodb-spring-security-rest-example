# grails-mongodb-spring-security-rest-example
This project uses Grails 3.1 with plugins: GORM for MongoDB, Spring Security Core Plugin, and Spring Security REST plugin. 
Make sure your mongoDB is up before you run this project. You can check [BootStrap.groovy](https://github.com/dyan-yen/grails-mongodb-spring-security-rest-example/blob/master/grails-app/init/BootStrap.groovy) to see what data were inserted.

This project was created using:

```$ grails create-app grails-mongodb-spring-security-rest-example --profile=rest-api```

User and Role were created using:

```$ grails s2-quickstart com.dyan.auth User Role```

To understand how Spring Security REST plugin works, send a POST JSON to Authentication Endpoint:

```$ curl -X POST -H "Content-Type: application/json" -d '{"username":"user","password":"password"}' http://localhost:8080/api/login```

An `access_token` will be returned. Use the token as an Authorization header:

```$ curl -X GET -H "Content-type: application/json" -H "Authorization: Bearer <PUT THE access_token HERE>" http://localhost:8080/api/persons```
