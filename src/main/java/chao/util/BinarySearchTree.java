package chao.util;

/**
 * @author g.c
 * @date 2020年5月22日下午2:02:17
 **/
public class BinarySearchTree<E extends Comparable<? super E>> {

	private BinaryNode<E> root;

	public BinarySearchTree() {
		root = null;
	}
	
	public void makeEmpty() {
		root = null;
	}

	
	private static class BinaryNode<E> {

		E element;

		BinaryNode<E> left;

		BinaryNode<E> right;

		BinaryNode(E element) {
			this(element, null, null);
		}

		BinaryNode(E element, BinaryNode<E> left, BinaryNode<E> right) {
			this.element = element;
			this.left = left;
			this.right = right;
		}
	}
}
