package LLD.Designs.LoggingSystem;

public class WarnLogger extends AbstractLogger{

    public WarnLogger(LogLevel level){
        this.logLevel = level; //loglevel from abstract class
    }
    @Override
    protected void write(String message) {
        System.out.println("[WARN] " + message);
    }
}
