package chao.design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/08/05 17:39:00
 */
public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void Notify() {
        observers.forEach(i -> i.update());
    }
}
