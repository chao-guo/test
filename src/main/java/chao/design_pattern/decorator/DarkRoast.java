package chao.design_pattern.decorator;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName DarkRoast.java
 * @Description 深度烘培咖啡
 * @createTime 2020年06月16日 23:47:00
 */
public class DarkRoast extends Beverage{
    public DarkRoast() {
        super.description = "DarkRoast";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
