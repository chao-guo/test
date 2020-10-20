package leetcode.listSet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/10/20 22:25:00
 */
public class _1_twoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
