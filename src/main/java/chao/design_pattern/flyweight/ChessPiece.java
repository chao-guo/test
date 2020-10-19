package chao.design_pattern.flyweight;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020年07月03日 14:47:00
 */
public abstract class ChessPiece {

    String color;

    int x;

    int y;

    public ChessPiece(String color) {
        this.color = color;
    }

    public abstract void downPiece(int x, int y);
}
