package chao.design_pattern.observer;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/08/05 17:59:00
 */
public class ConcreteObserver extends Observer {

    private String name;

    private String observerState;

    private ConcreteSubject subject;

    public ConcreteObserver(ConcreteSubject subject, String name) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    void update() {
        observerState = subject.getSubjectState();
        System.out.println("观察者{" + name + "}的新状态是{" + observerState + "}");

    }

    public ConcreteSubject getSubject() {
        return subject;
    }

    public void setSubject(ConcreteSubject subject) {
        this.subject = subject;
    }
}
