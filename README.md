# ttdevelopment-api

This API is made for communicating with our website via a jar. You can get information & progress of a project. 


# Installation

- Create a new folder in you're project called 'lib'. 
- Put the [jar](https://github.com/tt-development/ttdevelopment-api/blob/master/T%26T%20Development%20API.jar) into the 'lib' folder.
- Add the internal jar via build path.

# How to use


Initialize API. Make sure to import it from `ttdev.ttdevelopment.api`.
```java
API api = new API();
```

Get project title and description.
```java
String projectID = "";
ProjectInformation projectInformation = api.getProjectInformation(projectID

System.out.println("Title: " + projectInformation.getTitle());
System.out.println("Description: " + projectInformation.getShortDescription());
```

Get project progress.
```java
String projectID = "";
ProjectProgress = projectProgress = api.getProjectProgress(projectID);

for (int i=0; i < projectProgress.getTotalCommits(); i++) {
  System.out.println("Description: " + projectProgress.getCommits().get(i).getDescription());
}
```
