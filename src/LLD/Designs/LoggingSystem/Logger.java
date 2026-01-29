package LLD.Designs.LoggingSystem;

public class Logger {

    private static Logger instance;
    private AbstractLogger loggerChain;

    public Logger(){
        buildLoggerChain();
    }

    public void buildLoggerChain(){
        AbstractLogger fatal = new FatalLogger(LogLevel.FATAL);
        AbstractLogger error = new ErrorLogger(LogLevel.ERROR);
        AbstractLogger warn = new WarnLogger(LogLevel.WARN);
        AbstractLogger info = new InfoLogger(LogLevel.INFO);
        AbstractLogger debug = new DebugLogger(LogLevel.DEBUG);

        error.setNextLogger(fatal);
        warn.setNextLogger(error);
        info.setNextLogger(warn);
        debug.setNextLogger(info);
        this.loggerChain = debug;
    }

    public static Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public void log(LogLevel level,String message){
        loggerChain.handle(level,message);
    }

}
