package chao.dataandc;

import java.util.LinkedList;
import java.util.List;

/**
 * 分离链接法实现的散列表
 *
 * @param <E>
 */
public class SeparateChainingHashTable<E> {

    private static final int DEFAULT_TABLE_SIZE = 101;

    private List<E>[] theLists;

    private int currentSize;

    public SeparateChainingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public SeparateChainingHashTable(int size) {
        theLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList();
        }
    }

    public void insert(E element) {
        List<E> whichList = theLists[myhash(element)];
        if (!whichList.contains(element)) {
            whichList.add(element);
            if (++currentSize > theLists.length) {
                rehash();
            }
        } else {
            throw new RuntimeException("Element already exist");
        }
    }

    public void remove(E element) {
        List<E> whichList = theLists[myhash(element)];
        if (whichList.contains(element)) {
            whichList.remove(element);
            currentSize--;
        }
    }

    public boolean contains(E element) {
        List<E> whichList = theLists[myhash(element)];
        return whichList.contains(element);
    }

    public int size() {
        return currentSize;
    }

    public void makeEmpty() {
        for (List list : theLists)
            list.clear();
        currentSize = 0;
    }

    private void rehash() {
        List<E>[] oldList = this.theLists;
        theLists = new LinkedList[nextPrime(theLists.length * 2)];
        currentSize = 0;
        for (int i = 0; i < oldList.length; i++) {
            for (E element : oldList[i]) {
                insert(element);
            }
        }

    }

    /**
     * 每一个项要提供适当的equals方法和返回一个int类型值的hashCode方法，且转成适当的数组下标
     *
     * @param element
     * @return
     */
    private int myhash(E element) {
        int hashVal = element.hashCode();
        hashVal %= theLists.length;
        if (hashVal < 0) {
            hashVal += theLists.length;
        }
        return hashVal;
    }

    private static int nextPrime(int n) {
        if (n % 2 == 0)
            n++;

        for (; !isPrime(n); n += 2)
            ;
        return n;
    }

    private static boolean isPrime(int n) {
        if (n == 2 || n == 3)
            return true;

        if (n == 1 || n % 2 == 0)
            return false;

        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;

        return true;
    }

}
