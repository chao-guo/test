package chao.dataandc;

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

    public boolean isEmpty() {
        return root == null;
    }

    public boolean insert(E element) {
        if (root == null) {
            root = new BinaryNode<E>(element);
            return true;
        }
        BinaryNode<E> t = root;
        int compareTo = element.compareTo(t.element);
        while (!(compareTo < 0 && t.left == null) && !(compareTo > 0 && t.right == null)) {
            compareTo = element.compareTo(t.element);
            if (compareTo < 0) {
                t = t.left;
            } else if (compareTo > 0) {
                t = t.right;
            } else {
                break;
            }
            compareTo = element.compareTo(t.element);
        }
        if (compareTo < 0 && t.left == null) {
            t.left = new BinaryNode<E>(element);
            return true;
        } else if (compareTo > 0 && t.right == null) {
            t.right = new BinaryNode<E>(element);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除有两种情况需要处理：
     * - 只有一个儿子：删除当前节点，子节点接上；
     * - 有两个儿子节点：删除当前节点，左子树中最大值作为替代或者右子树中最小值作为替代。
     * <p>
     * 感觉这里只能用递归去实现。
     *
     * @param element
     * @return
     */
    public boolean remove(E element) {
        root = remove(element,root);
        return true;
    }

    private BinaryNode<E> remove(E element, BinaryNode<E> t) {
        int leftOrRight = (int) Math.random() * 2 + 1;
        if (t == null) {
            return null;
        }
        int i = element.compareTo(t.element);
        if (i < 0) {
            t.left = remove(element, t.left);
        } else if (i > 0) {
            t.right = remove(element, t.right);
        } else if (i == 0) {//找到要删除的节点
            if (t.left != null && t.right != null) {//要删除的节点有两个儿子
                if (leftOrRight == 1) {
                    //删除时，选择左子树最大的值作为该节点
                    t.element = findMax(t.left).element;
                    t.left = remove(t.element, t.left);
                } else {
                    //删除时，选择右子树最小的值作为该节点
                    t.element = findMin(t.right).element;
                    t.right = remove(t.element, t.right);
                }
            } else {//单个儿子
                t = (t.left == null) ? t.right : t.left;
            }
        }
        return t;
    }

    public boolean contains(E element) {
        return contains(element, root);
    }

    private boolean contains(E element, BinaryNode<E> t) {
        if (t == null) {
            return false;
        }
        int compareTo = element.compareTo(t.element);
        if (compareTo < 0) {
            return contains(element, t.left);
        } else if (compareTo > 0) {
            return contains(element, t.right);
        } else
            return true;
//  	用while代替尾递归的实现方式
//		BinaryNode<E> temp = t;
//		while (compareTo != 0) {
//			if (compareTo < 0) {
//				temp = temp.left;
//				if (temp.element == null)
//					return false;
//				compareTo = element.compareTo(temp.element);
//			} else if (compareTo > 0) {
//				temp = temp.right;
//				if (temp.element == null)
//					return false;
//				compareTo = element.compareTo(temp.element);
//			} else {
//				return true;
//			}
//		}
    }

    public E findMin() {
        if (isEmpty())
            throw new RuntimeException("tree is empty");
        return findMin(root).element;
    }

    public E findMax() {
        if (isEmpty())
            throw new RuntimeException("tree is empty");
        return findMax(root).element;
    }

    private BinaryNode<E> findMin(BinaryNode<E> root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private BinaryNode<E> findMax(BinaryNode<E> root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
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
