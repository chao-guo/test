package chao.design_pattern.command;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020年07月05日 21:47:00
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void call() {
        System.out.println("调用者执行命令command···");
        command.execute();
    }
}
