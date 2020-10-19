package chao.design_pattern.flyweight;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020年07月03日 14:51:00
 */
public class ConcretePiece extends ChessPiece {

    public ConcretePiece(String color) {
        super(color);
        System.out.println("创建： " + color + " 棋子");
    }

    @Override
    public void downPiece(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println(color + "，位置：" + x + "," + y);
    }
}
