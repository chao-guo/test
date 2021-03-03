package chao.util.reflect.test;

/**
 * @author chao.guo
 * @Date 2020/11/9 10:24
 */
public class Section extends AbstractEntity {
    Section() {
    }

    Section(Long id) {
        super.setId(id);
    }

    public String method1() {
        return "";
    }

    private String nethod2() {
        return "";
    }

    public void method3(String param1, Integer param2) {
    }

    public Long method4(Long param1) {
        return 0L;
    }
}
