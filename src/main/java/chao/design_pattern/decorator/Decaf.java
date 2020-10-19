package chao.design_pattern.decorator;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName Decaf.java
 * @Description 低咖啡因咖啡
 * @createTime 2020年06月16日 23:49:00
 */
public class Decaf extends Beverage{
    public Decaf() {
        super.description = "Decaf";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
