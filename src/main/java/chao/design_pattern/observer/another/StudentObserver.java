package chao.design_pattern.observer.another;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/09/04 14:26:00
 */
public class StudentObserver extends ObjectObserver {

    private Student copyStudent;

    public StudentObserver(Student student) {
        this.copyStudent = student.copy();
    }

    @Override
    void update(ObjectSubject objectSubject) {
        Student student = (Student) objectSubject;
        if (student.getId() != copyStudent.getId())
            System.out.println("修改 Id : {" + copyStudent.getId() + "} -> {" + student.getId() + "}");
        if (!student.getName().equals(copyStudent.getName()))
            System.out.println("修改 Name : {" + copyStudent.getName() + "} -> {" + student.getName() + "}");
        if (student.getAge() != copyStudent.getAge())
            System.out.println("修改 Age : {" + copyStudent.getAge() + "} -> {" + student.getAge() + "}");
        if (student.getCourse() != copyStudent.getCourse())
            System.out.println("修改 Course :  {" + copyStudent.getCourse() + "} -> {" + student.getCourse() + "}");
        this.copyStudent = student.copy();
    }
}
