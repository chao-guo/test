package chao.design_pattern.state;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020年07月08日 15:29:00
 */
public interface State {
    public void insertQuarter();

    public void ejectQuarter();

    public void turnCrank();

    public void dispense();
}
