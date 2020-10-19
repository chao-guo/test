package chao.design_pattern.decorator;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName CondimentDecorator.java
 * @Description 调料类（抽象装饰者类）
 * @createTime 2020年06月16日 23:39:00
 */
public abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}
