package chao.design_pattern.bridge;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName Circle.java
 * @Description TODO
 * @createTime 2020年06月29日 16:51:00
 */
public class Circle extends Shape {

    private int x, y, radius;

    protected Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}
