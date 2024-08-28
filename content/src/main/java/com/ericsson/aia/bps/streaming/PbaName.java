/**
 *
 * (C) Copyright LM Ericsson System Expertise AT/LMI, 2017
 *
 * The copyright to the computer program(s) herein is the property of Ericsson  System Expertise EEI, Sweden.
 * The program(s) may be used and/or copied only with the written permission from Ericsson System Expertise
 * AT/LMI or in  * accordance with the terms and conditions stipulated in the agreement/contract under which
 * the program(s) have been supplied.
 *
 */
package com.ericsson.aia.bps.streaming;


import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.spark.streaming.api.java.JavaDStream;
import com.ericsson.component.aia.services.bps.spark.jobrunner.BpsSparkStreamingJobRunner;

/**
 * <h1>pbaNameInCamelCase</h1>
 * The <code>pbaNameInCamelCase</code> implements an application that
 * simply streams messages from Kafka topic and displays it in the Spark console.
 *
 */
public class pbaNameInCamelCase extends BpsSparkStreamingJobRunner {

    private static final long serialVersionUID = 5914257776162053954L;

    @SuppressWarnings("unchecked")
    @Override
    public void executeJob() {

	 /*
	  * 1st step
	  * Gets Kafka Stream as defined in flow.xml 
	  *	
	  *example 
	  *	<input name="DataSource_kafka10"> 
	  *			...
	  *         <attribute name="key.deserializer" value="org.apache.kafka.common.serialization.StringDeserializer" />
	  *			<attribute name="value.deserializer" value="org.apache.kafka.common.serialization.StringDeserializer" />
	  *	          ...
	  *	</input> 
	  *	 you can get the stream associated with input using inputStreams.getStreams("DataSource_kafka10")
	  *	final JavaDStream< ConsumerRecord<String, String>> window = (JavaDStream< ConsumerRecord<String, String>>) inputStreams.getStreams("DataSource_kafka10")
      *  .getStreamRef();
	  *
	  */
	
	 /*
      * 2nd step
	  * Apply your logic like transformation , filteration etc....
	  */

	 /*
	  * 3rd step
	  * To save output to Hdfs, file, Alluxio etc as defined in flow.xml use persistRDD or persistRDDSinglePartition methods
	  */
	
	 //persistRDD(JavaRDD<V>)
	 
    }
}
