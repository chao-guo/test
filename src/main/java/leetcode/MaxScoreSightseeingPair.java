package leetcode;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName maxScoreSightseeingPair.java
 * @Description TODO
 * @createTime 2020年06月17日 18:14:00
 */
public class MaxScoreSightseeingPair {
    public int maxScoreSightseeingPair(int[] A) {
        int result = A[0] + A[1] - 1;
        int current;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                current = A[i] + A[j] + i - j;
                result = current > result ? current : result;
            }
        }
        return result;
    }

    public int maxScoreSightseeingPair2(int[] A) {
        int result = A[0] + A[1] - 1;
        int mx = A[0] + 0;
        for (int i = 1; i < A.length; ++i) {
            result = result > (A[i] - i + mx) ? result : (A[i] - i + mx);
            mx = mx > (A[i] + i) ? mx : (A[i] + i);
        }
        return result;
    }

    public int maxScoreSightseeingPair3(int[] A) {
        int result = A[0] + A[1] - 1;
        int mx = A[0] + 0;
        for (int i = 1; i < A.length; ++i) {
            result = Math.max(result, A[i] + i + mx);
            mx = Math.max(mx, A[i] - i);
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] a = {1, 2};
        int[] a = {8, 1, 5, 2, 6};
        int i = new MaxScoreSightseeingPair().maxScoreSightseeingPair(a);
        System.out.println(i);
        i = new MaxScoreSightseeingPair().maxScoreSightseeingPair2(a);
        System.out.println(i);
        i = new MaxScoreSightseeingPair().maxScoreSightseeingPair3(a);
        System.out.println(i);
    }
}
