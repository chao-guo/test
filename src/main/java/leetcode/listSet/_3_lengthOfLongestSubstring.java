package leetcode.listSet;


import java.util.ArrayList;
import java.util.List;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/10/25 17:35:00
 */
public class _3_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) return 0;
        if (chars.length == 1) return 1;
        List<Character> temp = new ArrayList<>();
        int length = 0;
        for (int i = 0; i < chars.length; ++i) {
            temp.add(chars[i]);
            int j = i + 1;
            for (; j < chars.length; ++j) {
                if (!temp.contains(chars[j])) {
                    temp.add(chars[j]);
                } else {
                    if (length < temp.size()) length = temp.size();
                    temp.clear();
                    break;
                }
            }
            if (j == chars.length) {
                if (length < temp.size()) length = temp.size();
                temp.clear();
            }
        }
        return length;
    }

    public static void main(String[] args) {
        _3_lengthOfLongestSubstring lengthOfLongestSubstring = new _3_lengthOfLongestSubstring();
        int abcabcbb = lengthOfLongestSubstring.lengthOfLongestSubstring("");
        System.out.println(abcabcbb);
    }
}
