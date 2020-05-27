package chao.util;

/**
 * @author g.c
 * @param <E>
 * @date 2020年5月26日下午5:21:27
 **/
@SuppressWarnings("unchecked")
public class MyArrayStack<E> implements MyStack<E> {

	private E[] theStack;

	private static final int DEFAULT_CAPACITY = 10;

	// 栈顶元素位置(-1 表示空栈)
	private int topOfStack;

	public MyArrayStack() {
		this.topOfStack = -1;
		this.theStack = (E[]) new Object[DEFAULT_CAPACITY];
	}

	@Override
	public void push(E element) {
		ensureCapacity();
		theStack[++topOfStack] = element;
	}

	@Override
	public void pop() {
		if (isEmpty()) {
			throw new RuntimeException("ArrayStack top");
		}
		theStack[topOfStack] = null;
		topOfStack--;
	}

	@Override
	public E top() {
		if (isEmpty()) {
			throw new RuntimeException("ArrayStack top");
		}
		return theStack[topOfStack];
	}

	@Override
	public E topAndPop() {
		if (isEmpty()) {
			throw new RuntimeException("ArrayStack top");
		}
		E element = theStack[topOfStack];
		theStack[topOfStack] = null;
		topOfStack--;
		return element;
	}

	@Override
	public boolean isEmpty() {
		return topOfStack == -1;
	}

	@Override
	public void makeEmpty() {
		topOfStack = -1;
		theStack = (E[]) new Object[DEFAULT_CAPACITY];
	}

	private void ensureCapacity() {
		int size = topOfStack + 1;
		if (size == 10 || size == theStack.length) {
			E[] oldList = theStack;
			theStack = (E[]) new Object[size * 2 + 1];
			for (int i = 0; i < oldList.length; i++) {
				theStack[i] = oldList[i];
			}
		}
	}

}
