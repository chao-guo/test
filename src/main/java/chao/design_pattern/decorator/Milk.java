package chao.design_pattern.decorator;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName Milk.java
 * @Description 牛奶
 * @createTime 2020年06月16日 23:56:00
 */
public class Milk extends CondimentDecorator {
    private Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Milk";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.10;
    }
}
