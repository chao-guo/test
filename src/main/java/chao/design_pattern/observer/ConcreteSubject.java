package chao.design_pattern.observer;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/08/05 17:57:00
 */
public class ConcreteSubject extends Subject {

    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}
