package leetcode.listSet;

/**
 * @author chao.guo
 * @Date 2020/11/2 10:00
 */
public class _5_longestPalindrome {
    /**
     * 最长回文字符串
     * 1.暴力解法，挨个遍历每一个字符串
     * babaf
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        while (length != 0) {
            for (int i = 0; i <= (s.length() - length); i++) {
                int start = i;
                int end = i + length;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        _5_longestPalindrome longestPalindrome = new _5_longestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("babaf"));

    }
}
