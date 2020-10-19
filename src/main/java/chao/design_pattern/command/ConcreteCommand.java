package chao.design_pattern.command;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020年07月05日 21:31:00
 */
public class ConcreteCommand implements Command {

    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
