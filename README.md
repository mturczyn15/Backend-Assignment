# Note Backend-Assignment
This project provides a simple RESTful web API where you can manage with notes.
# Requirements
- JavaIDE(Intellij, Eclipse),
- Gradle
# How to start project
- download project from Github,
- open IDE
 For Intellij:
- File -> New -> Project from existing sources.. -> choose folder where you downloaded project and find file "build.gradle"
  -> wait for buildind project -> Open class "Notes application" and run it's main method
  Project is running.
 - server port it's 8080
# Endpoints
##Creating note:
method POST curl: http://localhost:8080/v1/notes that endpoint cosnumes JSON e.g
{	
	"title": "note",
	"content": "do sth"
}

##Getting single note:
Request
Path parameters
id Required
method GET curl: http://localhost:8080/v1/notes/id
Response:
{
    "id": 5,
    "title": "note",
    "content": "text",
    "created": "2020-10-02",
    "modified": null
}


##Getting all notes:
method GET curl: http://localhost:8080/v1/notes







# Additional API documentation
- Run application
- Api doc is available on: http://localhost:8080/swagger-ui.html
# Author
Marcin Turczyn
  

