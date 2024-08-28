# Introduction

The pbaName project generated from the AIA Portal using the Spark Streaming template.
This guide provides quick end to end use case flow of data processing flow on cluster environment.
AIA provides own set of environment called [AIA Sandbox]: http://analytics.ericsson.se/#/GetStarted/sandbox which can be used to execute pbaName use case.


# Prerequisites

Please follow the guide http://analytics.ericsson.se/#/Documentation/Prepare_to_Build_and_Run to set up your environment. The following tools are required,
```
   Java
   Maven
   Docker

```
various services including HDFS, Kafka, database, Spark, Flink are required with regards to the selected data sources, data sinks and processing engine. 

You can use AIA Sandbox(http://analytics.ericsson.se/#/GetStarted/sandbox) for flow/application execution and testing.
 
# Build the application

## Implmentation

Please follow the instruction as in comments in the following class to implement driver logic,
```
  com.ericsson.aia.bps.streaming.pbaNameInCamelCase
```

## Compile with Maven
```
mvn clean install
```

# Running pbaName
 
## Run the application natively

Once application build successfully it will generate the bps-engine-deployable.jar copy that jar along with flow.xml to target platform, e.g, AIA sandbox.

Run the follow command to submit the bps-engine-deployable.jar and flow.xml to spark cluster for execution, 
```
	<SPARK_HOME>/bin/spark-submit --class com.ericsson.component.aia.services.bps.engine.service.BPSPipeLineExecuter --master <SPARK_MASTER> <DIRECTORY OF JAR>/bps-engine-deployable.jar  <DIRECTORY OF FLOW XML>/flow.xml
	<SPARK_HOME>: spark home directory. e.g, /opt/spark-2.1.1
	<SPARK_MASTER>: Point to your target platform spark cluster, as defined in https://spark.apache.org/docs/latest/submitting-applications.html#master-urls.
	<DIRECTORY OF JAR>: directory path containing the bps-engine-deployable.jar
	<DIRECTORY OF FLOW XML>: directory path containing the flow xml 
```

		
## Run the application in docker
	
Dockerfile is provided to facilitate the creation of docker image and execute in docker mode.

### Containerize the application
Go to the pbaName project root folder and then run the following commands,
```
docker login -u <signum> http://armdocker.rnd.ericsson.se
docker build -t armdocker.rnd.ericsson.se/aia/bps-pbaName:1.0 .
```
### Publish the container to Artifactory
```
docker push armdocker.rnd.ericsson.se/aia/bps-pbaName:1.0
```
### Run Containerize application.
```
docker run -it --env mainClass=com.ericsson.component.aia.services.bps.engine.service.BPSPipeLineExecuter --env deployMode=cluster --env masterUrl=spark://ip:7077 --env bpsJar=hdfs://localhost:8020/ --env flowPath=hdfs://ip:8020/ --env jobArguments="" armdocker.rnd.ericsson.se/aia/bps-pbaName:1.0
```

## verify output 

As per the flow.xml verify data sink for expected result.