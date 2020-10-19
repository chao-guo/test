package chao.design_pattern.chain_of_responsibility;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/07/19 20:01:00
 */
public class ChainPatternDemo {
    private static AbstractLogger getChainOfLoggers() {

        AbstractLogger errorLogger = new ErrorLogger();
        AbstractLogger fileLogger = new FileLogger();
        AbstractLogger consoleLogger = new ConsoleLogger();

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO,
                "This is an information.");

        loggerChain.logMessage(AbstractLogger.DEBUG,
                "This is an debug level information.");

        loggerChain.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
    }
}
