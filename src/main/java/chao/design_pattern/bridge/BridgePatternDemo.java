package chao.design_pattern.bridge;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName BridgePatternDemo.java
 * @Description TODO
 * @createTime 2020年06月29日 16:54:00
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100,100,10,new RedCircle());
        Shape greenCircle = new Circle(100,100,10,new GreenCircle());
        redCircle.draw();
        greenCircle.draw();
    }
}
