As on 05-Oct-24 start.spring.io gives this 

plugins {
    id 'java'
    id 'org.springframework.boot' version '3.3.4'
    id 'io.spring.dependency-management' version '1.1.6'
}

this has following issue with logback which needs to be resolved

ERROR in ch.qos.logback.core.model.processor.ImplicitModelHandler - Could not create component [timeBasedFileNamingAndTriggeringPolicy] of type [ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP] java.lang.ClassNotFoundException: ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP
ERROR in c.q.l.core.rolling.DefaultTimeBasedFileNamingAndTriggeringPolicy - Filename pattern [./logs/archived/simplemind-kafka-demo-%d{yyyy-MM-dd}.%i.log] contains an integer token converter, i.e. %i, INCOMPATIBLE with this configuration. Remove it.
at org.springframework.boot.context.logging.LoggingApplicationListener.initializeSystem(LoggingApplicationListener.java:347)
....
Suppressed: java.lang.ClassNotFoundException: ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP
....

So I went back to slightly older spring boot version 3.2.5
and dependency-management version 1.1.4, which works fine with logging

Steps to Run
-------------
Start the kafka server running as docker container
This should start the kafka server in default port 9092

gradle bootRun

Go to postman and do a post 
POST http://localhost:8080/api/v1/messages
Send a student json as Body raw
{
"id":1,
"firstName": "john",
"lastName": "doe"
}

You will get http status 200 with message "message queued successfully"
In the log, you should see the consumer message like this

com.simplemind.kafka.service.impl.KafkaConsumer: consuming message :Student(id=1, firstName=john, lastName=doe)
That's it. You have successfully tested the demo app. Congrats


