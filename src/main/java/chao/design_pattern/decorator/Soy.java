package chao.design_pattern.decorator;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName Soy.java
 * @Description 豆浆
 * @createTime 2020年06月16日 23:57:00
 */
public class Soy extends CondimentDecorator {
    private Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Soy";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.15;
    }
}
