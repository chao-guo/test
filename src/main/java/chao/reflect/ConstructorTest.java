package chao.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/07/27 15:14:00
 */
public class ConstructorTest {

    public static Constructor getConstructor(Class<? extends People> clazz) {
        Constructor<? extends People> constructor = null;
        try {
            constructor = clazz.getConstructor(new Class[]{String.class});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return constructor;
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = getConstructor(Student.class);
        People gc = (People) constructor.newInstance("gc");
        gc.printlnName();
    }
}
