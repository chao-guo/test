package chao.design_pattern.observer;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/08/05 18:06:00
 */
public class Client {
    public static void main(String[] args) {
        ConcreteSubject s = new ConcreteSubject();

        s.attach(new ConcreteObserver(s, "X"));
        s.attach(new ConcreteObserver(s, "Y"));
        s.attach(new ConcreteObserver(s, "Z"));
        s.setSubjectState("ABC");
        s.Notify();
    }
}
