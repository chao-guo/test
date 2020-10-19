package chao.dataandc.sorting;

import java.util.Arrays;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName Sorting.java
 * @Description TODO
 * @createTime 2020/6/8 15:20
 */
public class Sorting {

    public static void main(String[] args) {
        Integer[] a = {34, 8, 64, 51, 32, 21};
//        Sorting.insertSort(a);
//        Sorting.bubbleSort(a);
//        Sorting.selectionSort(a);
//        Sorting.shellSort(a);
//        Arrays.asList(a).forEach(System.out::println);
        Integer[] b = {99, 5, 69, 33, 56, 13, 22, 55, 77, 48, 12, 88, 2, 69, 100};
//        Sorting.shellSort(b);
        Sorting.heapSort(b);
        Arrays.asList(b).forEach(System.out::println);
    }

    /**
     * 插入排序
     *
     * @param a
     * @param <E>
     */
    public static <E extends Comparable<? super E>> void insertSort(E[] a) {
        int j;
        for (int i = 1; i < a.length; i++) {
            E temp = a[i];
            for (j = i; j > 0 && temp.compareTo(a[j - 1]) < 0; j--)
                a[j] = a[j - 1];
            a[j] = temp;
        }
    }

    /**
     * 冒泡排序
     *
     * @param a
     * @param <E>
     */
    public static <E extends Comparable<? super E>> void bubbleSort(E[] a) {
        E temp = null;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     *
     * @param a
     * @param <E>
     */
    public static <E extends Comparable<? super E>> void selectionSort(E[] a) {
        for (int i = 0; i < a.length; i++) {
            int temp = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[temp]) < 0) {
                    temp = j;
                }
            }
            E tempElement = a[temp];
            a[temp] = a[i];
            a[i] = tempElement;
        }
    }

    /**
     * 希尔排序
     *
     * @param a
     * @param <E>
     */
    public static <E extends Comparable<? super E>> void shellSort(E[] a) {
        for (int i = a.length / 2; i > 0; i = i / 2) {
            for (int j = i; j < a.length; j++) {
                int k;
                E temp = a[j];
                for (k = j; k >= i && temp.compareTo(a[k - i]) < 0; k = k - i) {
                    a[k] = a[k - i];
                }
                a[k] = temp;
            }
        }
    }

    /**
     * 堆排序中：x坐标的左子节点坐标为2*x + 1，右子节点坐标为2*x + 2
     *
     * @param <E>
     */
    public static <E extends Comparable<? super E>> void heapSort(E[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            percDown(a, i, a.length);
        }
        for (int i = a.length - 1; i > 0; i--) {
            E temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            percDown(a, 0, i);
        }
    }

    public static <E extends Comparable<? super E>> void percDown(E[] a, int i, int n) {
        int child = leftChild(i);
        E temp = a[i];
        for (; child < n; i = child, child = leftChild(i)) {

            if (child != n - 1 && a[child].compareTo(a[child + 1]) < 0) ++child;
            if (temp.compareTo(a[child]) < 0) a[i] = a[child];
            else break;
        }
        a[i] = temp;
    }

    public static int leftChild(int i) {
        return 2 * i + 1;
    }

}
