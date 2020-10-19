package chao.design_pattern.bridge;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName Shape.java
 * @Description TODO
 * @createTime 2020年06月29日 16:50:00
 */
public abstract class Shape {

    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
