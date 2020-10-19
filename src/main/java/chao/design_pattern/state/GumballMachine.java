package chao.design_pattern.state;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020年07月08日 15:35:00
 */
public class GumballMachine {

    State state = null;
    int count = 0;

    public GumballMachine(int count) {
        if (count > 0) {
            state = new NoQuarterState(this);
            this.count = count;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    void setState(State state) {
        this.state = state;
    }

    void releaseBall() {
        System.out.println("一个货物发放");
        if (count != 0) {
            count--;
        }
    }

}
