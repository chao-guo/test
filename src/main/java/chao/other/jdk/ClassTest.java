package chao.other.jdk;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/07/31 09:31:00
 */
public class ClassTest {

    public static void main(String[] args) {
        System.out.println("Student.class.getSuperclass()\t" + Student.class.getSuperclass());
        System.out.println("Student.class.getGenericSuperclass()\t" + Student.class.getGenericSuperclass());

        System.out.println("Test.class.getSuperclass()\t" + ClassTest.class.getSuperclass());
        System.out.println("Test.class.getGenericSuperclass()\t" + ClassTest.class.getGenericSuperclass());

        System.out.println("Object.class.getGenericSuperclass()\t" + Object.class.getGenericSuperclass());
        System.out.println("Object.class.getSuperclass()\t" + Object.class.getSuperclass());

        System.out.println("void.class.getSuperclass()\t" + void.class.getSuperclass());
        System.out.println("void.class.getGenericSuperclass()\t" + void.class.getGenericSuperclass());

        System.out.println("int[].class.getSuperclass()\t" + int[].class.getSuperclass());
        System.out.println("int[].class.getGenericSuperclass()\t" + int[].class.getGenericSuperclass());
    }

}

class Person<T> {

}

class Student extends Person<ClassTest> {

}