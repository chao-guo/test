package chao.dataandc;

/**
 * 平方探测法实现的散列表
 */
public class QuadraticProbingHashTable<E> {

    private static final int DEFAULT_TABLE_SIZE = 11;

    private HashEntry<E>[] array;

    private int currentSize;

    public QuadraticProbingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public QuadraticProbingHashTable(int currentSize) {
        allocateArray(currentSize);
        makeEmpty();
    }

    public void makeEmpty() {
        this.currentSize = 0;
        for (HashEntry entry : array) {
            entry = null;
        }

    }

    public void insert(E element) {
        int currentPos = findPos(element);
        if (array[currentPos] != null) {
            throw new RuntimeException("Element already exist");
        }
        array[currentPos] = new HashEntry<>(element);
        currentSize++;
        if (currentSize > array.length / 2) {
            rehash();
        }
    }

    public void remove(E element) {
        int currentPos = findPos(element);
        if (isActive(currentPos)) {
            array[currentPos].isActive = false;
            currentSize--;
        }
    }

    public boolean contains(E element) {
        int pos = findPos(element);
        return isActive(pos);
    }

    //数组大小取值为大于等于指定值的最小素数
    public void allocateArray(int arraySize) {
        array = new HashEntry[nextPrime(arraySize)];
    }

    public boolean isActive(int currentPos) {
        return array[currentPos] != null && array[currentPos].isActive;
    }

    //通过平方探测法算出新增元素的位置
    public int findPos(E element) {
        int hashVal = myhash(element);
        int offset = 1;
        int offsetTime = 0;
        //该位置元素不为空且元素未被懒惰删除，则继续寻找下一个单元
        while (array[hashVal] != null && array[hashVal].isActive && !array[hashVal].element.equals(element)) {
            offset += 2 * ++offsetTime - 1;//这里书中仅仅是offset += 2，基于 f(i) = f(i-1) + 2 * i - 1 我认为有问题。
            hashVal += offset;
            if (hashVal > array.length) {
                hashVal -= array.length;
            }
        }
        return hashVal;
    }

    public void rehash() {
        HashEntry<E>[] oldArray = this.array;
        array = new HashEntry[nextPrime(oldArray.length * 2)];
        currentSize = 0;
        for (int i = 0; i < oldArray.length; i++) {
            if (oldArray[i] != null && oldArray[i].isActive) {
                insert(oldArray[i].element);
            }
        }
    }

    private int myhash(E element) {
        int hashVal = element.hashCode();
        hashVal %= array.length;
        if (hashVal < 0) hashVal += array.length;
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

    private static class HashEntry<E> {

        public E element;

        //false 表示删除
        public boolean isActive;

        public HashEntry(E element) {
            this(element, true);
        }

        public HashEntry(E element, boolean isActive) {
            this.element = element;
            this.isActive = isActive;
        }
    }
}
