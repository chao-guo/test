package chao.util;

/**
 * @author g.c
 * @date 2020年5月26日下午5:13:00
 **/
public interface MyStack<E> {

	/**
	 * 新增一个元素
	 * 
	 * @param element
	 */
	void push(E element);

	/**
	 * 移除栈顶元素
	 */
	void pop();

	/**
	 * 返回栈顶元素，但不改变栈
	 * 
	 * @return
	 */
	E top();

	/**
	 * 返回栈顶元素，并且移除该元素
	 * 
	 * @return
	 */
	E topAndPop();

	/**
	 * 栈是否为空
	 * 
	 * @return
	 */
	boolean isEmpty();

	/**
	 * 清空栈
	 */
	void makeEmpty();
}
