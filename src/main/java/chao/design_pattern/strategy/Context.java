package chao.design_pattern.strategy;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020年07月05日 20:55:00
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b) {
        return strategy.doOperation(a, b);
    }
}