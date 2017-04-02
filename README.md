# Spring Boot + Quartz + MongoDB
## Spring Boot

This is a sample application which will be deployed in a cluster environment. We implement it with Spring Boot.

## Quartz 
Quartz is a open source java based enterprise job scheduling library. We will use Quartz to manage all the project related cron job rathen than using the system's crontab. 

[Quartz](http://www.quartz-scheduler.org/)

## MongoDB
This project using MongoDB as the internal persistent store. 
To cluster the Quartz jobs, we need a DB job store. Since we already have the MongoDB available we decide to use a MongoDB job store other than the JDBC job store.

[A MongoDB-based store for Quartz](https://github.com/michaelklishin/quartz-mongodb)

## Key features of this application

* Using MongoDB as the job store so we can deploy the cron jobs in a cluster environment.
The configurations of MongoDB and Job store are in the quartz.properties.

* Auto wire the service into job class to run the job. 

* No business logic in the Cron Job.

* Dynamically change the job schedule by API call

* Pause/Resume triggers by API call






