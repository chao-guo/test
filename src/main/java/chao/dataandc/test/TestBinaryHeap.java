package chao.dataandc.test;

import chao.dataandc.BinaryHeap;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName TestBinaryHeap.java
 * @Description TODO
 * @createTime 2020年06月18日 22:23:00
 */
public class TestBinaryHeap {

    public static void main(String[] args) {
        BinaryHeap<Student> binaryHeap = new BinaryHeap<Student>();
        binaryHeap.insert(new Student("aa", 5));
        binaryHeap.insert(new Student("bb", 6));
        binaryHeap.insert(new Student("cc", 8));
        binaryHeap.insert(new Student("dd", 7));
        binaryHeap.insert(new Student("dd", 20));
        binaryHeap.insert(new Student("dd", 9));
        binaryHeap.insert(new Student("dd", 10));
        binaryHeap.insert(new Student("dd", 11));
        binaryHeap.insert(new Student("dd", 12));
        binaryHeap.insert(new Student("dd", 13));

        for (int currentSize = 1; currentSize < 100; ++currentSize) {
            System.out.println((currentSize + 2) * 11 / 10);
        }
    }
}
