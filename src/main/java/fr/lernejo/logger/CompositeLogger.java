package fr.lernejo.logger;

public class CompositeLogger implements Logger{
    private ConsoleLogger consoleLogger;
    private ContextualLogger fileLogger;

    public CompositeLogger(ConsoleLogger p_logConsole, ContextualLogger p_logFile){
        this.consoleLogger = p_logConsole;
        this.fileLogger = p_logFile;
    }
    @Override
    public void log(String message) {
        this.consoleLogger.log(message);
        this.fileLogger.log(message);
    }
}
