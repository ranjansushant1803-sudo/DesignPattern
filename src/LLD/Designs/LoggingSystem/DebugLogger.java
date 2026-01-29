package LLD.Designs.LoggingSystem;

public class DebugLogger extends AbstractLogger{

    public DebugLogger(LogLevel level){
        this.logLevel = level; //loglevel from abstract class
    }

    @Override
    protected void write(String message) {
        System.out.println("[DEBUG] " + message);
    }
}
