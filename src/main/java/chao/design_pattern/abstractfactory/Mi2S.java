package chao.design_pattern.abstractfactory;

public class Mi2S implements Telephone {
    @Override
    public void call(Long phoneNumber) {
        System.out.println("用小米2S打电话给：" + phoneNumber);
    }
}
