package chao.design_pattern.strategy;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020年07月05日 20:59:00
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println(context.executeStrategy(10, 5));
        context = new Context(new OperationSubstract());
        System.out.println(context.executeStrategy(10, 5));
        context = new Context(new OperationMultiply());
        System.out.println(context.executeStrategy(10, 5));

        System.out.println(EnumContext.ADD.executeStrategy(10, 5));
        System.out.println(EnumContext.SUBSTRACT.executeStrategy(10, 5));
        System.out.println(EnumContext.MULTIPLY.executeStrategy(10, 5));

        System.out.println(EnumContext.valueOf("ADD").executeStrategy(10, 5));
    }
}
