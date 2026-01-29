package LLD.Designs.LoggingSystem;

public class LoggingSystem {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log(LogLevel.WARN, "Payment failed for order 123");
    }
}
