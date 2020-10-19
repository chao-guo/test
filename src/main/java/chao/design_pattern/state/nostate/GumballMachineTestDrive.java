package chao.design_pattern.state.nostate;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020年07月08日 15:20:00
 */
public class GumballMachineTestDrive {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);
        System.out.println(gumballMachine);
        gumballMachine.insertQuarter();
        System.out.println(gumballMachine);
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
    }
}
