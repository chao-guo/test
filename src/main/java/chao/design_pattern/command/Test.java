package chao.design_pattern.command;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020年07月05日 21:48:00
 */
public class Test {
    public static void main(String[] args) {
        Command cmd = new ConcreteCommand(new Receiver());
        Invoker invoker = new Invoker(cmd);
        invoker.call();
    }
}
