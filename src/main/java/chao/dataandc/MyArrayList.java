package chao.dataandc;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author g.c
 * @date 2020年5月20日下午3:27:56
 **/
@SuppressWarnings("unchecked")
public class MyArrayList<E> implements Iterable<E> {

	// 容量
	private E[] theList;

	// 真实大小
	private int size;

	public MyArrayList() {
		this.size = 0;
		this.theList = (E[]) new Object[10];
	}

	public MyArrayList(int size) {
		this.size = 0;
		this.theList = (E[]) new Object[size];
	}

	public void add(E enement) {
		add(size, enement);
	}

	public void add(int index, E enement) {
		// 先校验 index
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		// 确认是否需要扩容
		ensureCapacity();
		// 索引位置之后的元素都需要往后移一位
		for (int i = size; i > index; i--) {
			theList[i] = theList[i - 1];
		}
		theList[index] = enement;
		size++;
	}

	public void remove(int index) {
		for (int i = size - 1; i >= index; i--) {
			E enement = theList[i];
			theList[i] = theList[size - 1];
			theList[size - 1] = enement;
		}
		size--;
	}

	public void clear() {
		for (int i = 0; i < size; i++) {
			theList[i] = null;
		}
		size = 0;
	}

	public int size() {
		return size;
	}

	public E get(int index) {
		// 先校验 index
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		return theList[index];
	}

	public void set(int index, E enement) {
		// 先校验 index
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		theList[index] = enement;
	}

	private void ensureCapacity() {
		if (size == 10 || size == theList.length) {
			E[] oldList = theList;
			theList = (E[]) new Object[size * 2 + 1];
			for (int i = 0; i < oldList.length; i++) {
				theList[i] = oldList[i];
			}
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new MyArrayListIterator();
	}

	private class MyArrayListIterator implements Iterator<E> {

		// 当前遍历的位置
		private int index = 0;

		@Override
		public boolean hasNext() {
			return index < size;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return theList[index++];
		}

		public void remove() {
			MyArrayList.this.remove(--index);
		}

	}
}
