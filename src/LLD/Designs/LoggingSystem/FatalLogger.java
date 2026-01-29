package LLD.Designs.LoggingSystem;

public class FatalLogger extends AbstractLogger{

    public FatalLogger(LogLevel level){
        this.logLevel = level; //loglevel from abstract class
    }
    @Override
    protected void write(String message) {
        System.out.println("[FATAL] " + message);
    }
}
