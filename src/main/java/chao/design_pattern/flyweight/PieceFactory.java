package chao.design_pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020年07月03日 14:59:00
 */
public class PieceFactory {

    private static Map<String, ChessPiece> pieceMap = new HashMap();

    /**
     * @throws
     * @title
     * @description
     */
    public static ChessPiece getChessPieces(String color) {
        ChessPiece piece = pieceMap.get(color);
        if (piece != null) {
            return piece;
        } else {
            piece = new ConcretePiece(color);
            pieceMap.put(color, piece);
            return piece;
        }
    }

    public static void main(String[] args) {
        ChessPiece black = PieceFactory.getChessPieces("black");
        black.downPiece(1,1);
        ChessPiece black2 = PieceFactory.getChessPieces("black");
        black2.downPiece(2,2);
        ChessPiece red = PieceFactory.getChessPieces("white");
        red.downPiece(3,2);
        ChessPiece black3 = PieceFactory.getChessPieces("black");
        black3.downPiece(4,4);
        ChessPiece red2 = PieceFactory.getChessPieces("white");
        red2.downPiece(4,2);

    }
}
