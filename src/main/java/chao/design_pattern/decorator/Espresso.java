package chao.design_pattern.decorator;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName Espresso.java
 * @Description 浓缩咖啡
 * @createTime 2020年06月16日 23:43:00
 */
public class Espresso extends Beverage {
    public Espresso() {
        super.description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }

}
