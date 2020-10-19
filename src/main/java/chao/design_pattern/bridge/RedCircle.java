package chao.design_pattern.bridge;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName RedCircle.java
 * @Description TODO
 * @createTime 2020年06月29日 16:10:00
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[Color:red,radius:" + radius + ",x:" + x + ",y:" + y + "]");
    }
}
