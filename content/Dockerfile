# **********************************************************************
# Ericsson Radio Systems AB                                     
# **********************************************************************
#
# (c) Ericsson 2017 - All rights reserved.
#
# The copyright to the computer program(s) herein is the property of
# Ericsson Radio Systems AB, Sweden. The programs may be used and/or
# copied only with the written permission from Ericsson Radio Systems AB
# or in accordance with the terms and conditions stipulated in the
# agreement/contract under which the program(s) have been supplied.
#
# **********************************************************************
#Pull Data Processor Base image from Docker Repository
FROM armdocker.rnd.ericsson.se/aia_releases/spark:v2.1.0

CMD mkdir -p  /pbaName

#overwrite JavaHome
ENV JAVA_HOME /usr/java/latest

#Copy init start script
COPY config/initialization_script /pbaName/

#Copy Processor Batch jar
COPY target/aia-pbaName-spark-streaming-deployable.jar /pbaName/

#Run this script when docker images gets initialized 
ENTRYPOINT ["/pbaName/initialization_script"]
