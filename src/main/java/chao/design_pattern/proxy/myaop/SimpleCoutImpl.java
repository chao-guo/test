package chao.design_pattern.proxy.myaop;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName SimpleCoutImpl.java
 * @Description TODO
 * @createTime 2020年06月27日 21:05:00
 */
public class SimpleCoutImpl implements AdditionalFunction {
    @Override
    public void before() {
        System.out.println("我想在执行真实方法前做一些处理···By SimpleCoutImpl");
    }

    @Override
    public void after() {
        System.out.println("我想在执行真实方法后做一些处理···By SimpleCoutImpl");
    }
}
