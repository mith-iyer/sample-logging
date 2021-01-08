# Sample-Logging App

Sample-Logging is a simple Java 8 and Maven based Spring Boot app that provides for basic CRUD functionality and API endpoints to peruse and learn Java logging with the log4j2 library and debugging when plugged into an IDE.

## Pre-Requisites
1) Java 8 JDK
2) Maven
3) IntelliJ (or your preferred IDE)
4) Postman

## Installation

With Intellij IDE, go to File > New > Module from Existing Sources.. and point to the folder containing the pom.xml

## Running the app

**Note:** App is set up with an embedded Apache Tomcat app server, that should serve the app on port 8080.

### Method 1

Once pom.xml Maven dependencies have been downloaded & installed, browse over to **sample-logging > src > main > java > com.oal.innovationweek.samplelogging > SampleLoggingApplication.java** and find the run icon next to the class name. Select the 'Run' option

![alt text](https://i.imgur.com/OtizyE3.png)

### Method 2

On terminal, browse over to the directory containing pom.xml and run the following
```bash
mvn spring-boot:run
```

## About the app

I. The app is connected to an in-memory H2 database [https://www.baeldung.com/spring-boot-h2-database](https://www.baeldung.com/spring-boot-h2-database) with the following tables:

1) Speaker
2) Workshop
3) Attendee
4) Workshop_Session
5) Workshop_Session_Attendee

The schema script can be found on the project at **sample-logging > src > main > resources > schema.sql**
The insert scripts can be found on the project at **sample-logging > src > main > resources > data.sql**

These do not have to be run manually. The app will run these automatically when Run.

**Note:** Since we are employing an in-memory database, any CRUD operations performed during an active app session (during 'run') will be lost when shutdown or restarted.

When the app is running, database data can be looked up by browsing over to [http://localhost:8080/h2-console](http://localhost:8080/h2-console) with the following settings (Password will be blank) :-

![alt text](https://i.imgur.com/k1dK3u0.png)

II. There is no front-end UI component present in the app, we will work with Rest Endpoints with this app. An importable Postman Collections API is provided with this project to help get started with usage. This can be found at **sample-logging > Java-logging.postman_collection.json**


## Functionality
1) Workshop Sessions can be set up and read where each session gives information about the Workshop (one and only one), its Speaker (one and only one) and attendees (0 to n).

2) Speakers, Workshop Sessions and Attendees can be viewed (either all, or a single one).

3) A new Workshop Session can be added with a Speaker chosen from an existing list of Speakers.

4) A new Speaker can be added.

5) A new Attendee can be added.

6) An existing Attendee can signup for a Workshop Session.

## Useful Study Links
1) [https://www.youtube.com/watch?v=vtPkZShrvXQ&ab_channel=freeCodeCamp.org](https://www.youtube.com/watch?v=vtPkZShrvXQ&ab_channel=freeCodeCamp.org)
2) [https://www.loggly.com/ultimate-guide/java-logging-basics/](https://www.loggly.com/ultimate-guide/java-logging-basics/)
3) [https://www.baeldung.com/java-logging-intro](https://www.baeldung.com/java-logging-intro)
4) [https://logging.apache.org/log4j/2.x/manual/configuration.html](https://logging.apache.org/log4j/2.x/manual/configuration.html)

## License
[MIT](https://choosealicense.com/licenses/mit/)