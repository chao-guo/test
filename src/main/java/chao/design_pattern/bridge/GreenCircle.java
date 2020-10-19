package chao.design_pattern.bridge;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName GreenCircle.java
 * @Description TODO
 * @createTime 2020年06月29日 16:53:00
 */
public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}
