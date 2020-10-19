package chao.design_pattern.proxy;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName RealSubjectImpl.java
 * @Description TODO
 * @createTime 2020年06月27日 12:05:00
 */
public class RealSubjectImpl implements Subject {
    @Override
    public void request() {
        System.out.println("真正的对象方法...");
    }
}
