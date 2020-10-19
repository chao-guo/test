package chao.dataandc;

/**
 * @author chao.guo
 * @version 1.0.0
 * @Description 二叉堆
 * @createTime 2020/6/18 18:59
 */
public class BinaryHeap<E extends Comparable<? super E>> {

    public static final int DEFAULT_CAPACITY = 10;

    private int currentSize;

    private E[] array;

    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        array = (E[]) new Comparable[capacity];
        currentSize = 0;
    }

    public BinaryHeap(E[] elements) {
        currentSize = elements.length;
        array = (E[]) new Comparable[(currentSize + 2) * 11 / 10];
        int i = 1;
        for (E element : elements) {
            array[i++] = element;
        }
        buildHeap();
    }

    public void insert(E element) {
        if (currentSize == 0) {
            array[++currentSize] = element;
            return;
        }
        if (currentSize == array.length - 1) {
            enlargeArray(array.length * 2 + 1);
        }
        int tempIndex = currentSize + 1;
        int compareTo;
        while (true) {
            array[tempIndex] = array[tempIndex / 2];
            compareTo = element.compareTo(array[tempIndex / 2]);
            if (compareTo > 0 || tempIndex <= 0) break;
            tempIndex = tempIndex / 2;
        }
        array[tempIndex] = element;
        ++currentSize;
    }

    public E findMin() {
        if (isEmpty())
            throw new RuntimeException("BinaryHeap is empty");
        return array[1];
    }

    public E deleteMin() {
        if (isEmpty()) throw new RuntimeException("BinaryHeap is empty");
        E element = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        return element;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void makeEmpty() {
    }

    //下滤
    private void percolateDown(int hole) {
        int child;
        E tmp = array[hole];
        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            /**
             * 这里，如果hole*2 等于currentSize时，表示出现一个节点上只有一个子节点（currentSize是偶数）
             */
            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0) ++child;
            if (array[child].compareTo(tmp) < 0) array[hole] = array[child];
            else break;
        }
        array[hole] = tmp;
    }

    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--)
            percolateDown(i);
    }

    private void enlargeArray(int newSize) {
        E[] old = array;
        array = (E[]) new Comparable[newSize];
        for (int i = 0; i < old.length; i++)
            array[i] = old[i];
    }


}
