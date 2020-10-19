package chao.design_pattern.decorator;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName Mocha.java
 * @Description 摩卡
 * @createTime 2020年06月16日 23:51:00
 */
public class Mocha extends CondimentDecorator {

    private Beverage beverage;
    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.20;
    }
}
