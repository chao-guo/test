package chao.juc.lock;

import sun.misc.Unsafe;
import sun.misc.VM;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/07/16 10:00:00
 */
public class Test {

    private String test = "Test";

//    private Unsafe unsafe = Unsafe.getUnsafe();

    public String getTest() {
        if (!VM.isSystemDomainLoader(Test.class.getClassLoader())) {
            throw new SecurityException("Unsafe Test");
        } else {
            return test;
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.getTest());

//        Unsafe unsafe = test.unsafe;
        System.out.println("---");
    }
}
