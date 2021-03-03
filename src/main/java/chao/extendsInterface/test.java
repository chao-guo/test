package chao.extendsInterface;

import java.sql.Timestamp;
import java.util.Date;

public class test {

    public static void main(String[] args) {

        B b = new BB();
        b.outA();
        b.outB();
        AA aa = new CC();
        aa.outA();
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        System.out.println(timestamp.equals(date));
    }
}
