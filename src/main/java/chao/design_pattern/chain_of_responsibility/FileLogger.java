package chao.design_pattern.chain_of_responsibility;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/07/17 16:59:00
 */
public class FileLogger extends AbstractLogger {

    public FileLogger() {
        this.level = AbstractLogger.DEBUG;
    }

    @Override
    protected void write(String message) {
        System.out.println("File Log:" + message);
    }
}
