/**
 * 
 * quartz-demo : EventLog.java
 */
package com.learning.quartzdemo.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * quartz-demo : com.learning.quartzdemo.event
 *
 * 
 * @author vishnu.g
 *
 * 10-Jun-2019
 * 
 */
public class EventLog {
	private static final Logger LOG = LoggerFactory.getLogger("event_log");

    private EventLog() {}
    
    public static String storeLog(String serviceId, String eventType, String jobName) {
        String logRecord = "Service [" + serviceId + "], triggered by event " + eventType + " on [" + jobName + "] ";
        LOG.info(logRecord);
        return logRecord;
    }

    /**
     * Method for storing log
     *
     * @param requestUUID
     * @param microserviceId
     * @param eventType
     * @param userLogin
     * @param additionalData
     * @return formatter log record in string representation
     */
    public static String storeLog(String requestUUID, String serviceId, String eventType, String jobName, Object... additionalData) {
        String logRecord = "Request [" + requestUUID + "] at [" + serviceId + "], " + eventType + " by [" + jobName + "] " + composeAdditionalInfo(additionalData);
        LOG.info(logRecord);
        return logRecord;
    }

    private static String composeAdditionalInfo(Object... additionalData) {
        StringBuilder info = additionalData.length > 0 ? new StringBuilder("Info: ") : new StringBuilder(",");
        for (Object data : additionalData) {
            info.append(data + ", ");
        }
        return info.substring(0, info.lastIndexOf(","));
    }
}

