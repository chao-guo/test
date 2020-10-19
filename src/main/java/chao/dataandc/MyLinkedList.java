package chao.dataandc;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author g.c
 * @date 2020年5月20日下午11:25:58
 **/
public class MyLinkedList<E> implements Iterable<E> {

	private int size;

	private Node<E> first;

	private Node<E> last;

	public MyLinkedList() {
		size = 0;
		first = null;
		last = null;
	}

	public void add(E enement) {
		Node<E> beforeLast = last;
		Node<E> temp = new Node<E>(beforeLast, enement, null);
		last = temp;
		if (beforeLast == null)
			first = temp;
		else
			beforeLast.next = temp;
		size++;
	}

	public void remove(int index) {
		Node<E> indexNode = getIndexNode(index);
		Node<E> prev = indexNode.prev;
		Node<E> next = indexNode.next;
		prev.next = next;
		next.prev = prev;
		size--;
	}

	public int size() {
		return size;
	}

	private Node<E> getIndexNode(int index) {
		// 先校验 index
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		// 先判断index离得头近，还是离得尾近
		Node<E> target = first;
		if (index == size)
			target = last;
		else if (index < size / 2) {
			for (int i = 0; i < index; i++) {
				target = target.next;
			}
		} else {
			target = last;
			for (int i = size - 1; i > index; i--) {
				target = target.prev;
			}
		}
		return target;
	}

	public E get(int index) {
		Node<E> indexNode = getIndexNode(index);
		return indexNode.enement;
	}

	public void add(int index, E enement) {
		Node<E> indexNode = getIndexNode(index);
		Node<E> indexPrev = indexNode.prev;
		Node<E> newNode = new Node<E>(indexPrev, enement, indexNode);
		indexNode.prev = newNode;
		indexPrev.next = newNode;
		size++;
	}

	private static class Node<E> {

		private E enement;

		private Node<E> next;

		private Node<E> prev;

		Node(Node<E> prev, E enement, Node<E> next) {
			this.enement = enement;
			this.next = next;
			this.prev = prev;
		}
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new MyLinkedListIterator();
	}

	private class MyLinkedListIterator implements Iterator<E> {

		private int index = 0;

		@Override
		public boolean hasNext() {
			return index < size;
		}

		@Override
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			return getIndexNode(index++).enement;
		}

		public void remove() {
			MyLinkedList.this.remove(--index);
		}

	}

}
