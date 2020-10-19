package chao.dataandc.test;

import chao.dataandc.BinarySearchTree;

import java.util.function.Consumer;

/**
 * @author g.c
 * @date 2020年5月27日下午8:17:09
 **/
public class TestBinarySearchTree {

    static Consumer<Object> print = System.out::println;

    public static void main(String[] args) {
        BinarySearchTree<Student> studentTree = new BinarySearchTree<Student>();
        boolean insert = studentTree.insert(new Student("aa", 5));
        print.accept(insert);
        insert = studentTree.insert(new Student("bb", 2));
        print.accept(insert);
        insert = studentTree.insert(new Student("cc", 3));
        print.accept(insert);
        insert = studentTree.insert(new Student("dd", 7));
        print.accept(insert);
        insert = studentTree.insert(new Student("bb", 6));
        print.accept(insert);
        insert = studentTree.insert(new Student("bb", 4));
        print.accept(insert);
        insert = studentTree.insert(new Student("bb", 4));
        print.accept(insert);
        boolean bb = studentTree.contains(new Student("bb", 2));
        print.accept(bb);
        bb = studentTree.contains(new Student("bb", 8));
        print.accept(bb);
        Student max = studentTree.findMax();
        print.accept(max);
        Student min = studentTree.findMin();
        print.accept(min);
        //删除单儿子节点
//        print.accept(studentTree.remove(new Student("bb", 2)));
        //删除两儿子节点(随机取子节点替代)
        studentTree.insert(new Student("bb",1));
        System.out.println(studentTree.remove(new Student("bb", 2)));
    }
}
