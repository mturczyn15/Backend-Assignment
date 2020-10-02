# Note Backend-Assignment
This project provides a simple RESTful web API where you can manage with notes.
# Requirements
- JavaIDE(Intellij, Eclipse),
- Gradle
# How to start project
- download project from Github,
- open IDE.
 For Intellij:
- File -> New -> Project from existing sources.. -> choose folder where you downloaded project and find file "build.gradle"
  -> wait for buildind project -> Open class "Notes application" and run it's main method,
 - Project is running,
 - server port it's 8080
# Endpoints
## Creating note:
Request: method POST curl: http://localhost:8080/v1/notes that endpoint consumes JSON (you don't have to place id, create, modified, this data are read-only) e.g
{	<br />
	"title": "note",<br />
	"content": "do sth"<br />
}

## Getting single note:
Request: method GET curl: http://localhost:8080/v1/notes/{id} e.g http://localhost:8080/v1/notes/1
id - requested path variable
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
[
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
}]

## Update note
Request: method PUT curl: http://localhost:8080/v1/notes that endpoint cosnumes JSON with note's id, and modified data e.g
{	
	"id": 1,
	"title": "note",
	"content": "do sth"
}

## Delete note
Request: method DELETE curl: http://localhost:8080/v1/notes/{id} e.g http://localhost:8080/v1/notes/1
id - requested path variable
When you delete note it is stored in version history.
In note's

## Get all versions of note
Notes are versioned you can can check note's story of modifies.
Request: method GET curl: http://localhost:8080/v1/versions?note_Id=1
note_Id - query parameter. Id of note, which you want check.
Even if you delete note, you can check story of changes.
In response you can see id, noteId, title, content, created, modified, action(CREATE, UPDATE or DELETE), date of modification and version.
Possible Response:
[
    {
        "id": 2,
        "noteId": 1,
        "title": "note",
        "content": "do sth",
        "created": "2020-10-02",
        "modified": null,
        "action": "CREATE",
        "version": 1
    },
    {
        "id": 9,
        "noteId": 1,
        "title": "note 111",
        "content": "read book",
        "created": "2020-10-02",
        "modified": "2020-10-02",
        "action": "UPDATE",
        "version": 2
    },
    {
        "id": 10,
        "noteId": 1,
        "title": "note 111",
        "content": "do sth",
        "created": "2020-10-02",
        "modified": "2020-10-02",
        "action": "UPDATE",
        "version": 3
    },
    {
        "id": 11,
        "noteId": 1,
        "title": "note 111",
        "content": "do sth",
        "created": "2020-10-02",
        "modified": "2020-10-02",
        "action": "DELETE",
        "version": 4
    }
]


# Additional API documentation
- Run application
- Api doc is available on: http://localhost:8080/swagger-ui.html
# Author
Marcin Turczyn
  

