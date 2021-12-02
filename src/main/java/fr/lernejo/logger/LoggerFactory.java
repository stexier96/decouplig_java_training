package fr.lernejo.logger;

public abstract class LoggerFactory implements Logger{

    public static Logger getLogger(String name){
        return new CompositeLogger(new ConsoleLogger(), new ContextualLogger(ContextualLogger.class.toString(), new FileLogger("log.log")));
        //return new ContextualLogger(ContextualLogger.class.toString(), new FileLogger("log.log"));
    }
}
