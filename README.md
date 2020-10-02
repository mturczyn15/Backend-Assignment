# Note Backend-Assignment
This project provides a simple RESTful web API where you can manage with notes.
# Requirements
- Java 8,
- JavaIDE (Intellij, Eclipse),
- Gradle
# How to start project
- download project from Github,
- open IDE. <br />
 For Intellij:
- File -> New -> Project from existing sources..  <br />->choose folder where you downloaded project and click file "build.gradle"
  -> wait for buildind project  <br />-> Open class "NotesApplication.java" situated in package com.assignment.notes and run it's main method as shown on photo,
  ![dadada](https://snipboard.io/vR5dZ2.jpg)
 - Project is running,
 - server port it's 8080,
 - url: http://localhost:8080/v1
 
# Technologies
- Java 8
- Spring Web,
- Hibernate,
- JUnit,
- Mockito,
- Swagger,
- Hibernate Validator,
- Lombok,
- H2 database

# Endpoints
## Creating note:
Request: method POST curl: http://localhost:8080/v1/notes that endpoint consumes JSON (you don't have to place id, create, modified, this data are read-only) e.g<br />
fields created and modified cant be null and must contains at least 3 characters<br />
{	<br />
	"title": "note",<br />
	"content": "do sth"<br />
}<br />

## Getting single note:
Request: method GET curl: http://localhost:8080/v1/notes/{id} e.g http://localhost:8080/v1/notes/1<br />
id - requested path variable<br />
Possible Response:<br />
{<br />
    "id": 5,<br />
    "title": "note",<br />
    "content": "text",<br />
    "created": "2020-10-02",<br />
    "modified": null<br />
}<br />


## Getting all notes:
Request: method GET curl: http://localhost:8080/v1/notes<br />
Possible Response:<br />
[<br />
{<br />
    "id": 1,<br />
    "title": "note",<br />
    "content": "text",<br />
    "created": "2020-10-02",<br />
    "modified": null<br />
}<br />
{<br />
    "id": 2,<br />
    "title": "note",<br />
    "content": "text",<br />
    "created": "2020-10-02",<br />
    "modified": null<br />
}<br />]<br />

## Update note
Request: method PUT curl: http://localhost:8080/v1/notes that endpoint cosnumes JSON with note's id, and modified data e.g<br />
{	<br />
	"id": 1,<br />
	"title": "note",<br />
	"content": "do sth"<br />
}<br />

## Delete note
Request: method DELETE curl: http://localhost:8080/v1/notes/{id} e.g http://localhost:8080/v1/notes/1<br />
id - requested path variable<br />
When you delete note it is stored in version history.<br />


## Get all versions of note
Notes are versioned you can can check note's story of modifies.<br />
Request: method GET curl: http://localhost:8080/v1/versions?note_Id=1<br />
note_Id - query parameter. Id of note, which you want check.<br />
Even if you delete note, you can check story of changes.<br />
In response you can see id, noteId, title, content, created, modified, action(CREATE, UPDATE or DELETE), date of modification and version.<br />
Possible Response:<br />
[<br />
    {<br />
        "id": 2,<br />
        "noteId": 1,<br />
        "title": "note",<br />
        "content": "do sth",<br />
        "created": "2020-10-02",<br />
        "modified": null,<br />
        "action": "CREATE",<br />
        "version": 1<br />
    },<br />
    {<br />
        "id": 9,<br />
        "noteId": 1,<br />
        "title": "note 111",<br />
        "content": "read book",<br />
        "created": "2020-10-02",<br />
        "modified": "2020-10-02",<br />
        "action": "UPDATE",<br />
        "version": 2<br />
    },<br />
    {<br />
        "id": 10,<br />
        "noteId": 1,<br />
        "title": "note 111",<br />
        "content": "do sth",<br />
        "created": "2020-10-02",<br />
        "modified": "2020-10-02",<br />
        "action": "UPDATE",<br />
        "version": 3<br />
    },<br />
    {<br />
        "id": 11,<br />
        "noteId": 1,<br />
        "title": "note 111",<br />
        "content": "do sth",<br />
        "created": "2020-10-02",<br />
        "modified": "2020-10-02",<br />
        "action": "DELETE",<br />
        "version": 4<br />
    }<br />
]<br />

# Database
This application uses H2Database. It's no need to configure database, configuration of database in placed in application.properties file.<br />

# Additional API documentation
- Run application
- Api doc is available on: http://localhost:8080/swagger-ui.html
# Author
- Marcin Turczyn
  

