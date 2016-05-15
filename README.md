# fonis-start-rest
Project used for teaching about RESTful services at FONIS START conference  May,2016

All api calls are available at:

`http://localhost:8080/fonis-rest-service/api/`

for example: `http://localhost:8080/fonis-rest-service/api/users`

You can open index.html page by going to: `http://localhost:8080/fonis-rest-service/`

To use this project, you need:
  1. [Tomcat 8](http://tomcat.apache.org/download-80.cgi) or any other java web container
  2. MySQL Server to be able to import the database (database .sql file is in [src/main/java/resources/database](https://github.com/Branislav1993/fonis-start-rest/blob/master/src/resources/java/database/start_fonis.sql))
  3. [Maven](https://maven.apache.org/)
  
After importing the project, wait build to finish, then right click onto project -> Maven -> Update project, or `mvn clean install -U ` in command line.
  
Useful resources:
- [Maven tutorial](http://www.tutorialspoint.com/maven/)
- [Jersey tutorial](http://www.vogella.com/tutorials/REST/article.html)
- [Jersey example](http://www.tutorialsdesk.com/2014/09/jersey-crud-restful-webservice-tutorial.html)
  
  


