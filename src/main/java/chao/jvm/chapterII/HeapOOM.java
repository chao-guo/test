package chao.jvm.chapterII;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆大小：20MB 不可扩展（Xms、Xmx设置为一样避免自动扩展） -XX:+HeapDumpOnOutOfMemoryError 异常时Dump出当前内存堆转储快照
 * VM args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author chao.guo
 * @Date 2021/12/7 15:53
 */
public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {

        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
