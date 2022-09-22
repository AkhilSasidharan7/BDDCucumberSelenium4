package mottMac;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

//method for configure Logs

public class SetupLog {
	  public static Logger log;
	    public static Logger setUp() {
	        BasicConfigurator.configure();
	        log = Logger.getLogger(CareerSearch.class);
	        log.info("Log set up done");
	        return log;
	    }
}