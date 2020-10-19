package chao.design_pattern.builder;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName ChickenBurger.java
 * @Description TODO
 * @createTime 2020年06月28日 23:42:00
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.5f;
    }
}
