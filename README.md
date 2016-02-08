# Football_Teams

Football Team Simple REST Example 

This is a simple RESTFul application using maven 3, spring 4 and java 8


1- Check out the project and run mvn clean install at the root of project

2- The above command will create a war file called football.war in the target folder

3- Copy the war file and put it in a container i.e. tomcat/webapp

4- Once that done the webservice should be available with the following API:

- Create a team

Sample Request:

POST http://localhost:8080/football/team
Content-Type:application/json
Basic Authentication - username: razh password: razhPassword

body:

{  
   "name":"Razh FC",
   "city":"Manchester",
   "owner":"Razh",
   "competition":"Premier League",
   "players":[  
      {  
         "name":"Razh",
         "age":27,
         "position":"MIDFIELDER"
      }
   ]
}


Sample Response:
Team Created


-------------------------------------------
------------------------------------------


- List all teams:

Sample Request:

GET http://localhost:8080/football/teams
Basic Authentication - username: razh password: razhPassword

Sample Response:

[
  {
    "name": "Razh FC",
    "city": "Manchester",
    "owner": "Razh",
    "competition": "Premier League",
    "players": [
      {
        "name": "Razh",
        "age": 27,
        "dateOfBirth": null,
        "position": "MIDFIELDER"
      }
    ],
    "createdDate": "2016-02-08 21:25:44"
  }
]

-------------------------------------------
------------------------------------------


- List all teams:

Sample Request:

GET http://localhost:8080/football/team/{teamName}
GET http://localhost:8080/football/team/Razh FC
Basic Authentication - username: razh password: razhPassword

Sample Response:

[
  {
    "name": "Razh FC",
    "city": "Manchester",
    "owner": "Razh",
    "competition": "Premier League",
    "players": [
      {
        "name": "Razh",
        "age": 27,
        "dateOfBirth": null,
        "position": "MIDFIELDER"
      }
    ],
    "createdDate": "2016-02-08 21:25:44"
  }
]
