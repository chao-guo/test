package chao.design_pattern.decorator;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName Beverage.java
 * @Description 饮料类
 * @createTime 2020年06月16日 23:35:00
 */
public abstract class Beverage {

    String description = "Unknown Beverage";

    public String getDescription(){
        return this.description;
    }

    public abstract double cost();
}
