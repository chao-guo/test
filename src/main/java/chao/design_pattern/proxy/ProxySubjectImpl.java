package chao.design_pattern.proxy;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName SubjectImpl.java
 * @Description TODO
 * @createTime 2020年06月27日 12:06:00
 */
public class ProxySubjectImpl implements Subject {

    private RealSubjectImpl realSubject;

    public ProxySubjectImpl() {
        this(new RealSubjectImpl());
    }

    public ProxySubjectImpl(RealSubjectImpl realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void request() {
        System.out.println("我想在执行真实方法前做一些处理···");
        realSubject.request();
        System.out.println("我想在执行真实方法后做一些处理···");
    }
}
