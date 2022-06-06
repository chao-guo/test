package chao.javabase.rpc.service;

import chao.javabase.rpc.Entity.Student;

/**
 * @author chao.guo
 * @Date 2022/5/6 15:37
 */
public interface StudentService {

    public Student getInfo();

    public void print(Student stu);
}
