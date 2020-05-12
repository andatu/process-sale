package utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 * This class should add any exception to our errorLog hashmap. The ExceptionLog is for the programmer
 * for debugging, maintenance etc. we will have only one instance of this class.
 */
public class LogHandler {
    private HashMap<String, String> ExceptionLog=new HashMap<>();
    private static final LogHandler logger = new LogHandler();

    /**
     * This constructor creates the one and only loghandler object we will use
     * @return logger an object of this class
     */
    public static LogHandler getLogHandler(){
        return logger;
    }

    public void logException(Exception e){
        String timeStamp = timeStamp();
        String logInstance=timeStamp+", Exception: "+ e.getMessage();
        ExceptionLog.put(timeStamp, logInstance);
        System.out.println("Logging exception: " + e);
    }

    private String timeStamp(){
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return time.format(formatter);
    }

}