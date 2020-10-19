package chao.reflect;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/07/27 15:17:00
 */
public class Student implements People {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void printlnName() {
        System.out.println(name);
    }
}
