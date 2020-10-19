package chao.design_pattern.adapter.implementation1;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName TwoToThreeAdapter.java
 * @Description 对象适配器 转接器Adapter
 * @createTime 2020年06月15日 09:23:00
 */
public class TwoToThreeAdapter implements ThreePower {

    private TwoPower twoPower;

    public TwoToThreeAdapter(TwoPower twoPower){
        this.twoPower = twoPower;
    }

    @Override
    public void powerByThree() {
        twoPower.powerByTwo();
        System.out.println("借助对象（组合）适配器转换二项电");
    }
}
