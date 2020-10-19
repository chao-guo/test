package chao.design_pattern.observer.another;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/09/04 14:13:00
 */
public class Student extends ObjectSubject {

    private long id;

    private String name;

    private int age;

    private int course;

    public Student() {
    }

    public Student(long id, String name, int age, int course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public Student copy() {
        return new Student(this.id, this.name, this.age, this.course);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
        this.Notify(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.Notify(this);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        this.Notify(this);
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
        this.Notify(this);
    }
}
