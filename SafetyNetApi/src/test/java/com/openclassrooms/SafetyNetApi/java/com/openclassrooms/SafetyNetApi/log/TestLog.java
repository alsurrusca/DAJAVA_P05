package com.openclassrooms.SafetyNetApi.log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
public class TestLog {

    private static Logger logger;

    @Test
    public void testLog(){
        logger = LogManager.getLogger(TestLog.class);
        logger.debug("DEBUG");
        logger.error("ERROR");
    }

}
