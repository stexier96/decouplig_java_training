package fr.lernejo.logger;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger{
    private String callerClass = null;
    private Logger delegateLogger = null;

    public ContextualLogger(String p_name, Logger p_logger){
        callerClass = p_name;
        delegateLogger = p_logger;
    }
    @Override
    public void log(String message) {
        delegateLogger.log(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + " "
            + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")) + " "
            + callerClass + " "
            + message);
    }
}
