package chao.design_pattern.decorator;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName HouseBlend.java
 * @Description 星巴克咖啡
 * @createTime 2020年06月16日 23:45:00
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        super.description = "HouseBlend";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
