package chao.design_pattern.proxy;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName ProsyTest.java
 * @Description TODO
 * @createTime 2020年06月27日 12:12:00
 */
public class ProsyTest {
    public static void main(String[] args) {
        Subject subject = new ProxySubjectImpl();
        subject.request();

        //jdk
        subject = new RealSubjectImpl();
        JdkProxySubject<Subject> jdkProxySubject = new JdkProxySubject(subject);
        Subject proxyInstance = jdkProxySubject.getProxy();
        proxyInstance.request();

        //cglib
        CGlibProxySubject<Subject> cGlibProxySubject = new CGlibProxySubject(subject);
        Subject proxy = cGlibProxySubject.getProxy();
        proxy.request();
    }
}
