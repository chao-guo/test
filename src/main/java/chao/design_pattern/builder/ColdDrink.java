package chao.design_pattern.builder;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName ColdDrink.java
 * @Description TODO
 * @createTime 2020年06月28日 23:39:00
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

}
