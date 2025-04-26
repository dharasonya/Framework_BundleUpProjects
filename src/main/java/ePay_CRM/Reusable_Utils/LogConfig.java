package ePay_CRM.Reusable_Utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class LogConfig {
	
	/*public void loadConfigFileName() throws IOException
	{
		String dateSuffix = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	    String logFileName = "logs/ApplicationStep-" + dateSuffix + ".log";

	    FileAppender fileAppender = new FileAppender(
	        new PatternLayout("%d{dd:MM:yyyy HH:mm:ss} - %5p %C.%M [Line:%L] - %m%n"),
	        logFileName,
	        true
	    );
	    
	    Logger logger = Logger.getLogger(LogConfig.class);
	    logger.addAppender(fileAppender);
	    
	    logger.info("Logging message on " + dateSuffix);
	}*/
	
}
