package chao.dataandc.test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import chao.dataandc.MyArrayList;
import chao.dataandc.MyLinkedList;

/**
 * @author g.c
 * @date 2020年5月20日下午9:52:11
 **/
public class TestMyList {

	static Consumer<Object> print = System.out::println;

	public static void main(String[] args) {
		MyArrayList<String> list = new MyArrayList<String>();
		list.add("111");
		list.add("222");
		list.add("333");
		list.add("444");
		list.add("555");
		list.add(1, "666");
		int size = list.size();
		list.remove(1);
		size = list.size();
		String string = list.get(3);
		print.accept(string);
		list.set(4, "777");
		size = list.size();
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			print.accept(iterator.next());
		}

		List<String> list3 = new LinkedList<String>();
		list3.add("111");
		list3.add("222");
		list3.add("333");
		list3.add("444");
		list3.add("555");
		list3.add(2, "666");
		MyLinkedList<String> list2 = new MyLinkedList<String>();
		list2.add("111");
		list2.add("222");
		list2.add("333");
		list2.add("444");
		list2.add("555");
		String string2 = list2.get(0);
		print.accept(string2);
		String string3 = list2.get(3);
		print.accept(string3);
		String string4 = list2.get(0);
		print.accept(string4);
		print.accept(list2.size());
		list2.add(2, "666");
		print.accept(list2.size());
		print.accept("---" + list2.get(2));
		list2.remove(1);
		print.accept(list2.size());
		print.accept(list2.get(1));
		Iterator<String> iterator2 = list2.iterator();
		while (iterator2.hasNext()) {
			print.accept("list2:" + iterator2.next());
		}
	}
}
