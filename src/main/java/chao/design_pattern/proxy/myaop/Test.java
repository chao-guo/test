package chao.design_pattern.proxy.myaop;

import chao.design_pattern.proxy.ProxySubjectImpl;
import chao.design_pattern.proxy.RealSubjectImpl;
import chao.design_pattern.proxy.Subject;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2020年06月27日 22:53:00
 */
public class Test {
    public static void main(String[] args) {
        Subject subject = new RealSubjectImpl();
        AdditionalFunction additionalFunction = new SimpleCoutImpl();
        JdkProxySubjectWithAddFunc<Subject> jdkProxySubjectWithAddFunc = new JdkProxySubjectWithAddFunc(subject,additionalFunction);
        Subject proxy = jdkProxySubjectWithAddFunc.proxy();
        proxy.request();
    }
}
