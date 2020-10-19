package chao.dataandc.test;

import chao.dataandc.SeparateChainingHashTable;

public class TestHashTable {
    public static void main(String[] args) {
        SeparateChainingHashTable<Student> separateChainingHashTable = new SeparateChainingHashTable<>();
        Student student1 = Student.createStudent("aa", 11);
        Student student2 = Student.createStudent("bb", 22);
        Student student3 = Student.createStudent("cc", 33);
        Student student4 = Student.createStudent("dd", 44);
        separateChainingHashTable.insert(student1);
        System.out.println(separateChainingHashTable.size());
        separateChainingHashTable.insert(student2);
        System.out.println(separateChainingHashTable.size());
        separateChainingHashTable.insert(student3);
        System.out.println(separateChainingHashTable.size());
        separateChainingHashTable.insert(student4);
        System.out.println(separateChainingHashTable.size());
        System.out.println(separateChainingHashTable.contains(student1));
        System.out.println(separateChainingHashTable.contains(student2));
        System.out.println(separateChainingHashTable.contains(student3));
        System.out.println(separateChainingHashTable.contains(student4));
        separateChainingHashTable.remove(student1);
        System.out.println(separateChainingHashTable.contains(student1));
        System.out.println(separateChainingHashTable.size());
        separateChainingHashTable.remove(student2);
        System.out.println(separateChainingHashTable.contains(student2));
        System.out.println(separateChainingHashTable.size());
        separateChainingHashTable.makeEmpty();
        System.out.println(separateChainingHashTable.size());
    }
}
