package chao.dataandc;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName AvlTree.java
 * @Description 带有平衡条件的二叉查找树
 * @createTime 2020年06月11日 09:40:00
 */
public class AvlTree<E extends Comparable<? super E>> {

    private AvlNode<E> root;

    private static final int ALLOWED_IMBALANCE = 1;

    public AvlTree() {
        root = null;
    }

    public void insert(E element) {
    }

    private AvlNode insert(E element, AvlNode<E> root) {
        if (root == null) {
            return new AvlNode(element);
        }
        int compareTo = element.compareTo(root.element);
        if (compareTo < 0) {
            root.left = insert(element, root.left);
        } else if (compareTo > 0) {
            root.right = insert(element, root.right);
        }
        return balance(root);
    }

    private AvlNode balance(AvlNode<E> t) {
        if (t == null) {
            return t;
        }
        //左子树比右子树高
        if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE)
            if (height(t.left.left) >= height(t.left.right)) {
                //左左的情况，需要做一次单旋转（右旋）
                t = rotateWithLeftChild(t);
            } else
                t = doubleWithLeftChild(t);
        else if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE)
            if (height(t.right.right) >= height(t.right.left))
                t = rotateWithRightChild(t);
            else
                t = doubleWithRightChild(t);
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    //右旋
    private AvlNode<E> rotateWithLeftChild(AvlNode<E> k2) {
        AvlNode<E> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    //双旋转（先左旋，再右旋）
    private AvlNode<E> doubleWithLeftChild(AvlNode<E> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private AvlNode<E> rotateWithRightChild(AvlNode<E> k1) {
        AvlNode<E> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;
        return k2;
    }

    private AvlNode<E> doubleWithRightChild(AvlNode<E> k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    private int height(AvlNode<E> t) {
        return t == null ? -1 : t.height;
    }

    private static class AvlNode<E> {

        E element;

        AvlNode<E> left;

        AvlNode<E> right;

        int height;

        AvlNode(E element) {
            this(element, null, null);
        }

        AvlNode(E element, AvlNode<E> left, AvlNode<E> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }
}
