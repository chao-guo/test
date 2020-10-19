package chao.design_pattern.observer.another;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/09/04 11:16:00
 */
public abstract class ObjectSubject {

    private List<ObjectObserver> observers = new ArrayList<>();

    public void attach(ObjectObserver observer) {
        observers.add(observer);
    }

    public void detach(ObjectObserver observer) {
        observers.remove(observer);
    }

    public void Notify(ObjectSubject objectSubject) {
        observers.forEach(i -> i.update(objectSubject));
    }
}