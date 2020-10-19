package chao.design_pattern.observer.another;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/09/04 14:50:00
 */
public class StudentTest {

    public static void main(String[] args) {
        Student student = new Student();
        student.setId(1);
        student.setName("GC");
        student.setAge(20);
        student.setCourse(1);
        StudentObserver studentObserver = new StudentObserver(student);
        student.attach(studentObserver);
        student.setName("GG");
        student.setAge(2);
    }
}
