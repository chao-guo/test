package chao.design_pattern.adapter.implementation1;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName test.java
 * @Description TODO
 * @createTime 2020年06月15日 09:53:00
 */
public class NoteBook {
    private ThreePower threePower;

    public NoteBook(ThreePower threePower) {
        this.threePower = threePower;
    }

    public void work() {
        System.out.println("笔记本电脑开始工作!");
    }

    public void recharge() {
        // 使用三项充电
        threePower.powerByThree();
    }

    public static void main(String[] args) {
        ThreePower threePower = new TwoToThreeAdapter(new TwoPower());
        NoteBook noteBook = new NoteBook(threePower);
        noteBook.recharge();
        noteBook.work();

        ThreePower threePower1 = new TwoToThreeAdapter2();
        NoteBook noteBook1 = new NoteBook(threePower1);
        noteBook1.recharge();
        noteBook1.work();
    }
}
