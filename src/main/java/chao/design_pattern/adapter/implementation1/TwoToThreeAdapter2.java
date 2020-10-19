package chao.design_pattern.adapter.implementation1;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName TwoToThreeAdapter2.java
 * @Description 类适配器转换类 Adapter
 * @createTime 2020年06月15日 09:52:00
 */
public class TwoToThreeAdapter2 extends TwoPower implements ThreePower {
    @Override
    public void powerByThree() {
        this.powerByTwo();
        System.out.println("借助类（继承）适配器转换二项电");
    }
}
