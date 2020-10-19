package chao.design_pattern.strategy;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/07/14 17:11:00
 */
public enum EnumContext {
    ADD(new OperationAdd()), SUBSTRACT(new OperationSubstract()), MULTIPLY(new OperationMultiply());

    private Strategy strategy;

    EnumContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b) {
        return strategy.doOperation(a, b);
    }
}
