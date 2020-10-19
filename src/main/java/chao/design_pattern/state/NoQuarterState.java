package chao.design_pattern.state;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020年07月08日 15:34:00
 */
public class NoQuarterState implements State {

    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine _gumballMachine) {
        this.gumballMachine = _gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("你投币了");
        gumballMachine.setState(new HasQuarterState(gumballMachine));
    }

    @Override
    public void ejectQuarter() {
        System.out.println("没投币，退什么币？");
    }

    @Override
    public void turnCrank() {
        System.out.println("请投币");
    }

    @Override
    public void dispense() {
        System.out.println("请投币");
    }
}
