package LLD.Designs.LoggingSystem;

public abstract class AbstractLogger {
    protected LogLevel logLevel;
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void handle(LogLevel requestLevel, String message){
        if(requestLevel.getLevel() >= this.logLevel.getLevel()){
            write(message);
        }
        if(nextLogger!=null){
            nextLogger.handle(requestLevel,message);
        }
    }

    abstract protected void write(String message);

}
