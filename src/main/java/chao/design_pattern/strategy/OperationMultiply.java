package chao.design_pattern.strategy;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020年07月05日 20:54:00
 */
public class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int a, int b) {
        return a * b;
    }
}
