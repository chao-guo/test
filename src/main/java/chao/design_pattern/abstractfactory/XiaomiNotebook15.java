package chao.design_pattern.abstractfactory;

public class XiaomiNotebook15 implements Notebook {
    @Override
    public void type(String code) {
        System.out.println("用XiaomiNotebook15敲代码：" + code);
    }
}
