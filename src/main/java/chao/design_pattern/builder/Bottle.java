package chao.design_pattern.builder;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName Bottle.java
 * @Description TODO
 * @createTime 2020年06月28日 23:34:00
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
