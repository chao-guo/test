package chao.other.jol;

import org.openjdk.jol.info.ClassLayout;

import java.io.PrintStream;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/07/29 11:10:00
 */
public class test {

    static PrintStream out = System.out;

    public static void main(String[] args) {

        Object o = new Object();

        out.println(ClassLayout.parseInstance(o).toPrintable());

        o.hashCode();

        out.println(ClassLayout.parseInstance(o).toPrintable());

        synchronized (o) {
            out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }

}
