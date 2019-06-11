/**
 * 
 * quartz-demo : SampleService.java
 */
package com.learning.quartzdemo.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * quartz-demo : com.learning.quartzdemo.service
 *
 * 
 * @author vishnu.g
 *
 * 09-Jun-2019
 * 
 */
@Service
public class SampleService {
	
    private static final Logger logger = LoggerFactory.getLogger(SampleService.class);

	public void printTime() {
        logger.info("Hi there ! {}", new Date());        
    }

}

