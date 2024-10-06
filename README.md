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
Send a string as Body raw
This is my first message
You will get http status 200 with message "message queued successfully"

Start kafka consumer from the terminal. Go to your
kafka server installation and run (software installed at /Users/adiyen/software/kafka_2.13-3.1.0)
bin/kafka-console-consumer.sh --topic simple --from-beginning --bootstrap-server localhost:9092
This is my first message

The consumer in the terminal will display that message.
Note that if you stop the consumer client and run it again,
you will get all the messages starting from the first message. 
I think there will be a default message expiry and until then message
will be persisted in message broker.
