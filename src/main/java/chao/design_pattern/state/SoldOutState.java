package chao.design_pattern.state;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020年07月08日 15:46:00
 */
public class SoldOutState implements State {

    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("无货，勿投币");
    }

    @Override
    public void ejectQuarter() {
        //不处理
    }

    @Override
    public void turnCrank() {
        System.out.println("没货了");
    }

    @Override
    public void dispense() {
        //不恰当的动作
    }
}
