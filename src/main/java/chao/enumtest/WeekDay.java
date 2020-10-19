package chao.enumtest;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/07/14 11:00:00
 */
public enum WeekDay {
    MONDAY("Mon.", 1),
    TUESDAY("Tues.", 2),
    WEDNESDAY("Wed.", 3),
    THURSDAY("Thur.", 4),
    FRIDAY("Fri.", 5),
    SATURDAY("Sat.", 6),
    SUNDAY("Sun.", 7);

    private String s;

    private int value;

    WeekDay(String s, int value) {
        this.s = s;
        this.value = value;
    }

    public static void main(String[] args) {
        WeekDay monday = WeekDay.valueOf("MONDAY");
        WeekDay monday1 = WeekDay.valueOf(WeekDay.class, "MONDAY");
        System.out.println(monday == monday1);
        System.out.println(monday.equals(monday1));
    }
}
