package leetcode;

import java.util.Arrays;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName DailyTemperatures.java
 * @Description TODO
 * @createTime 2020年06月26日 10:23:00
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        result[T.length - 1] = 0;
        int lastIndex = T.length - 1;
        for (int i = T.length - 2; i >= 0; --i) {
            for (int k = i + 1; k < T.length; ++k) {
                result[i]++;
                if (k == lastIndex && T[k] <= T[i]) result[i] = 0;
                if (T[k] > T[i]) break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] t = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = new DailyTemperatures().dailyTemperatures(t);
        Arrays.stream(ints).forEach(System.out::println);
    }
}
