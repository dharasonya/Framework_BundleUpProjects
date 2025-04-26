package ePay_CRM.Reusable_Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class CommonLogger {
    private static Logger log = Logger.getLogger("infoLogger");
    private static Logger errorLog = Logger.getLogger("errorLogger");
    private static boolean isInfoLoggerInitialized = false;
    private static boolean isErrorLoggerInitialized = false;

    public static void log(String message) {
        try {
            if (!isInfoLoggerInitialized) {
                initializeInfoLogger();  // Initialize only when the first log entry happens
            }

            StackTraceElement caller = Thread.currentThread().getStackTrace()[2];
            log.info(caller.getClassName() + "." + caller.getMethodName() + " [Line:" + caller.getLineNumber() + "] - " + message);
        } catch (Exception e) {
            System.out.println("Error logging info: " + e.getMessage());
        }
    }

    public static void errorLog(Exception ex) {
        try {
            if (!isErrorLoggerInitialized) {
                initializeErrorLogger(); // Initialize only when the first error log entry happens
            }

            StackTraceElement caller = Thread.currentThread().getStackTrace()[2];
            errorLog.error("Exception in " + caller.getClassName() + "." + caller.getMethodName() + " [Line:" + caller.getLineNumber() + "]", ex);
        } catch (Exception e) {
            System.out.println("Error logging exception: " + e.getMessage());
        }
    }

    private static void initializeInfoLogger() throws Exception {
        String dateSuffix = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String logFileName = "logs/ApplicationStep_Log_Id_" + generateRandomNumber() + "_" + dateSuffix + ".log";

        FileAppender fileAppender = new FileAppender(
            new PatternLayout("%d{dd:MM:yyyy HH:mm:ss} - %5p %C.%M [Line:%L] - %m%n"),
            logFileName,
            true
        );

        log.addAppender(fileAppender);
        isInfoLoggerInitialized = true;
    }

    private static void initializeErrorLogger() throws Exception {
        String dateSuffix = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String errorLogFileName = "logs/ErrorLog_"+generateRandomNumber() + "_"  + dateSuffix + ".log";

        FileAppender errorFileAppender = new FileAppender(
            new PatternLayout("%d{dd:MM:yyyy HH:mm:ss} - %5p %C.%M [Line:%L] - %m%n"),
            errorLogFileName,
            true
        );

        errorLog.addAppender(errorFileAppender);
        isErrorLoggerInitialized = true;
    }

    public static int generateRandomNumber() {
        Random random = new Random();
        return 10000 + random.nextInt(90000);
    }
}