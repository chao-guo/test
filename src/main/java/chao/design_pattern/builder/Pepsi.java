package chao.design_pattern.builder;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName Pepsi.java
 * @Description TODO
 * @createTime 2020年06月28日 23:43:00
 */
public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}
