package chao.javabase.rpc;

import chao.javabase.rpc.Entity.Student;
import chao.javabase.rpc.client.SocketClientProxy;
import chao.javabase.rpc.service.StudentService;

/**
 * @author chao.guo
 * @Date 2022/5/6 16:04
 */
public class Test2 {

    public static void main(String[] args) {
        SocketClientProxy proxy = new SocketClientProxy();
        StudentService studentService = proxy.getProxy(StudentService.class);
        Student student = studentService.getInfo();
        System.out.println(student.getName());
    }
}
