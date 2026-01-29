package LLD.Designs.LoggingSystem;

public class ErrorLogger extends AbstractLogger{

    public ErrorLogger(LogLevel level){
        this.logLevel = level; //loglevel from abstract class
    }
    @Override
    protected void write(String message) {
        System.out.println("[ERROR] " + message);
    }
}
