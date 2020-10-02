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
## Creating note:
Request: method POST curl: http://localhost:8080/v1/notes that endpoint consumes JSON (you don't have to place id, create, modified, this data are read-only) e.g
{	
	"title": "note",
	"content": "do sth"
}

## Getting single note:
Request: method GET curl: http://localhost:8080/v1/notes/{id}
id - requested path parameter
Possible Response:
{
    "id": 5,
    "title": "note",
    "content": "text",
    "created": "2020-10-02",
    "modified": null
}


## Getting all notes:
Request: method GET curl: http://localhost:8080/v1/notes
Possible Response:
{
    "id": 1,
    "title": "note",
    "content": "text",
    "created": "2020-10-02",
    "modified": null
}
{
    "id": 2,
    "title": "note",
    "content": "text",
    "created": "2020-10-02",
    "modified": null
}

## Update note
Request: method PUT curl: http://localhost:8080/v1/notes that endpoint cosnumes JSON with note's id, and modified data e.g
{	
	"id": 1,
	"title": "note",
	"content": "do sth"
}

## Delete note
Request: method DELETE curl: http://localhost:8080/v1/notes/{id}
id - requested path parameter

## Get all versions of note
Request: method GET curl: http://localhost:8080/v1/notes
Possible Response:
{
    "id": 1,
    "title": "note",
    "content": "text",
    "created": "2020-10-02",
    "modified": null
}
{
    "id": 2,
    "title": "note",
    "content": "text",
    "created": "2020-10-02",
    "modified": null
}




# Additional API documentation
- Run application
- Api doc is available on: http://localhost:8080/swagger-ui.html
# Author
Marcin Turczyn
  

