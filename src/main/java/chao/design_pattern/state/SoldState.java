package chao.design_pattern.state;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020年07月08日 15:48:00
 */
public class SoldState implements State {

    GumballMachine gumballMachine;

    public SoldState(GumballMachine _gumballMachine) {
        this.gumballMachine = _gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("稍等，发货中");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("货都给你了，你现在要退币？");
    }

    @Override
    public void turnCrank() {
        System.out.println("货以取");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.count > 0) {
            gumballMachine.setState(new NoQuarterState(gumballMachine));
        } else {
            System.out.println("没货了");
            gumballMachine.setState(new SoldOutState(gumballMachine));
        }
    }
}
