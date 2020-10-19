package chao.design_pattern.chain_of_responsibility;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/07/17 16:58:00
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger() {
        this.level = AbstractLogger.ERROR;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Log:" + message);
    }
}
