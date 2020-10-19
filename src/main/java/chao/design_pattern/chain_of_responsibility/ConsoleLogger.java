package chao.design_pattern.chain_of_responsibility;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/07/17 16:55:00
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger() {
        this.level = AbstractLogger.INFO;
    }

    @Override
    protected void write(String message) {
        System.out.println("Consloe Log:" + message);
    }
}
