package chao.design_pattern.state;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020年07月08日 15:47:00
 */
public class HasQuarterState implements State {

    GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine _gumballMachine) {
        this.gumballMachine = _gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("已投币，无需再投！");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("退币");
        gumballMachine.setState(new NoQuarterState(gumballMachine));
    }

    @Override
    public void turnCrank() {
        System.out.println("发货");
        gumballMachine.setState(new SoldOutState(gumballMachine));

    }

    @Override
    public void dispense() {
        //不恰当的动作
    }
}
