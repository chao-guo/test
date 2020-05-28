package chao.util.test;

import chao.util.BinarySearchTree;

/**
* @author g.c
* @date 2020年5月27日下午8:17:09
**/
public class TestBinarySearchTree {

	public static void main(String[] args) {
		BinarySearchTree<Student> studentTree = new BinarySearchTree<Student>();
		boolean insert = studentTree.insert(new Student("aa",5));
		System.out.println(insert);
		insert = studentTree.insert(new Student("bb",2));
		System.out.println(insert);
		insert = studentTree.insert(new Student("cc",3));
		System.out.println(insert);
		insert = studentTree.insert(new Student("dd",7));
		System.out.println(insert);
		insert = studentTree.insert(new Student("bb",6));
		System.out.println(insert);
		insert = studentTree.insert(new Student("bb",4));
		System.out.println(insert);
		insert = studentTree.insert(new Student("bb",4));
		System.out.println(insert);
	}
}
