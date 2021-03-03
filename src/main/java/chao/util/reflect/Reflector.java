package chao.util.reflect;

import chao.util.reflect.invoker.Invoker;
import chao.util.reflect.test.Section;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chao.guo
 * @Date 2020/11/6 17:30
 */
public class Reflector {

    private static boolean classCacheEnabled = true;

    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    //这里用ConcurrentHashMap，多线程支持，作为一个缓存
    private static final Map<Class<?>, Reflector> REFLECTOR_MAP = new ConcurrentHashMap<Class<?>, Reflector>();

    private Class<?> type;
    //getter的属性列表
    private String[] readablePropertyNames = EMPTY_STRING_ARRAY;
    //setter的属性列表
    private String[] writeablePropertyNames = EMPTY_STRING_ARRAY;
    //setter的方法列表
    private Map<String, Invoker> setMethods = new HashMap<String, Invoker>();
    //getter的方法列表
    private Map<String, Invoker> getMethods = new HashMap<String, Invoker>();
    //setter的类型列表
    private Map<String, Class<?>> setTypes = new HashMap<String, Class<?>>();
    //getter的类型列表
    private Map<String, Class<?>> getTypes = new HashMap<String, Class<?>>();
    //构造函数
    private Constructor<?> defaultConstructor;

    private Map<String, String> caseInsensitivePropertyMap = new HashMap<String, String>();

    private Reflector() {
    }

    public Reflector(Class<?> clazz) {
        this.type = clazz;
        initDefaultConstructor();
        System.out.println("test");
    }

    private void initDefaultConstructor() {
        Constructor<?>[] constructors = type.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterCount() == 0) {
                constructor.setAccessible(true);
                this.defaultConstructor = constructor;
            }
        }
    }

    private void initMethod() {
        Map<String, Method> uniqueMethods = new HashMap<String, Method>();
        Class<?> currentClass = type;
        while (currentClass != null) {
            Method[] declaredMethods = type.getDeclaredMethods();
            addUniqueMethods(uniqueMethods, declaredMethods);
            Class<?>[] interfaces = currentClass.getInterfaces();
            for (Class<?> anInterface : interfaces) {
                addUniqueMethods(uniqueMethods, anInterface.getMethods());
            }
        }

    }

    private void addUniqueMethods(Map<String, Method> uniqueMethods, Method[] declaredMethods) {
        for (Method declaredMethod : declaredMethods) {
            if (!declaredMethod.isBridge()) {
                StringBuffer methodLongName = new StringBuffer();
                methodLongName.append(declaredMethod.getReturnType().getName()).append("#").append(declaredMethod
                        .getName());
                Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == 0) methodLongName.append(":");
                    else methodLongName.append(",");
                    methodLongName.append(parameterTypes[i].getName());
                }
                if (!uniqueMethods.containsKey(methodLongName.toString())) {
                    declaredMethod.setAccessible(true);
                    uniqueMethods.put(methodLongName.toString(), declaredMethod);
                }
            }
        }
    }

    public static void main(String[] args) {
        Reflector reflector = new Reflector(Section.class);

    }

}
