package chao.design_pattern.builder;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName Item.java
 * @Description TODO
 * @createTime 2020年06月28日 23:19:00
 */
public interface Item {
    public String name();

    public Packing packing();

    public float price();
}
