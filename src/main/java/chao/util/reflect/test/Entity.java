package chao.util.reflect.test;

/**
 * @author chao.guo
 * @Date 2020/11/9 10:23
 */
public interface Entity<T> {
    T getId();

    void setId(T id);
}
