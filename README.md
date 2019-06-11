# spring boot quartz
Sample spring boot project with clustered quartz scheduler. 

## Description
This is a sample spring boot demo project using [Spring Inotializer](https://start.spring.io/)

Execute the jar in 2 or more instance or terminal so that the sample jobs 'SampleJobA' and 'SampleJobB'
will be executed by only one instance. Clustered quartz scheduler will ensure that the job will be executed 
only once by any one of the instance, provided the database can be accessed by all the instance,(i.e. database 
must be shared). 

The clustered quartz scheduler will make sure the job be executed only once in an auto scaled environment.

## Stack:
Spring Boot
Quartz
MySQL (try docker: https://hub.docker.com/_/mysql/)