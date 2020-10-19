package chao.design_pattern.state.nostate;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020年07月08日 14:56:00
 */
public class GumballMachine {
    final static int SOLD_OUT = 0;
    final static int NO_QUARTER = 1;
    final static int HAS_QUARTER = 2;
    final static int SOLD = 3;

    int state = SOLD_OUT;
    int count = 0;

    public GumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_QUARTER;
        }
    }

    //投币
    public void insertQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("已投币，无需再投！");
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;
            System.out.println("你投币了");
        } else if (state == SOLD_OUT) {
            System.out.println("无货，勿投币");
        } else if (state == SOLD) {
            System.out.println("稍等，发货中");
        }
    }

    //退币
    public void ejectQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("退币");
            state = NO_QUARTER;
        } else if (state == NO_QUARTER) {
            System.out.println("没投币，退什么币？");
        } else if (state == SOLD) {
            System.out.println("货都给你了，你现在要退币？");
        } else if (state == SOLD_OUT) {
            //不处理
        }
    }

    //转动曲柄
    public void turnCrank() {
        if (state == SOLD) {
            System.out.println("货以取");
        } else if (state == NO_QUARTER) {
            System.out.println("请投币");
        } else if (state == SOLD_OUT) {
            System.out.println("没货了");
        } else if (state == HAS_QUARTER) {
            System.out.println("发货");
            state = SOLD;
            dispense();
        }
    }

    //发货
    public void dispense() {
        if (state == SOLD) {
            count--;
            if (count == 0) {
                state = SOLD_OUT;
            } else {
                state = NO_QUARTER;
            }
        } else if (state == NO_QUARTER) {
            //因该不会出现
        } else if (state == SOLD_OUT) {
            //因该不会出现
        } else if (state == HAS_QUARTER) {
            //因该不会出现
        }
    }

    @Override
    public String toString() {
        return "GumballMachine{" +
                "state=" + state +
                ", count=" + count +
                '}';
    }
}
