package leetcode;

public class productExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int k = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * k;
            k = k * nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test1 = {1,2,3,4};
        int[] ints = new productExceptSelf().productExceptSelf(test1);
        System.out.println("----");
    }
}
