package chao.javabase.rpc.service.impl;

import chao.javabase.rpc.Entity.Student;
import chao.javabase.rpc.service.StudentService;

/**
 * @author chao.guo
 * @Date 2022/5/6 15:38
 */
public class StudentServiceImpl implements StudentService {

    @Override
    public Student getInfo() {
        Student stu = new Student();
        stu.setID("123456");
        stu.setAge(10);
        stu.setName("gc");
        return stu;
    }

    @Override
    public void print(Student stu) {

    }
}