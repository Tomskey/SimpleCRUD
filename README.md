# TSNotes



TSNotes is a simply Restful api CRUD web service. It contains basic CRUD calls and simply Tag system 



### Tech

TSNotes uses a number of open source projects to work properly:

* Spring-Boot - Stand-alone Spring applications creator.
* IntelliJ IDEA - IDE for Java development with lombok plugin.
* MongoDB - Database that stores data in flexible, JSON-like documents.
* Postman - Powerful API development environment. 
* Tomcat - Container for web applications.
* Maven - Build automation tool for Java.



### Installation

TSNotes requires JDK 1.8 to run.

Download and Install [MongoDB](https://www.mongodb.com/download-center?jmp=nav).
Download and Install [InteliiJ IDE](https://www.jetbrains.com/idea/) if needed.
Download and Install [Postman](https://www.getpostman.com/apps) to run tests with this specialized application.

To run this project you need to:

Run Mongo database(in Windows): 
* First, add enviromental variable Path (default in C:\Program Files\MongoDB\Server\3.6\bin) to automatically run database without typing full path of mongo.
* open cmd and type "mongod" to run database(default port 27017).
* Run InteliiJ IDE and instal lombok plugin (required for Getters and Setters adnotatnions).
* Click File -> Settings ->  Plugins, and find Lombok.
    
Add Run/Debug Configuration:
* click Select Run/Debug Configurations -> Edit Configurations -> Add -> Maven
* in Working Directory paste project path
* in Command line type "spring-boot:run"
* save
    
You can now run and test project.

Unfortunately there is not implemented any of integration tests, so you need to follow instructions below.

To test functionality of this project you need to run Postman, in Omnibox type e.g. "localhost:8080/api/notes/"(port 8080 its default port for this project) and choose required method.

It is worth remembering, that MongoDB create predefined ID numbers, so in TSNotes, you need to use titles to e.g. get single notes.

