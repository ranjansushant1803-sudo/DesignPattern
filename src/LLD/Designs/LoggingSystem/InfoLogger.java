package LLD.Designs.LoggingSystem;

public class InfoLogger extends AbstractLogger{

        public InfoLogger(LogLevel level){
            this.logLevel = level; //loglevel from abstract class
        }
        @Override
        protected void write(String message) {
            System.out.println("[INFO] " + message);
        }
}
