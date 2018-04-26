package string;

import java.util.HashMap;

/**
 * 最长无重复字串
 */
public class DistinctSubstring {
    /**
     * 对于一个字符串,请设计一个高效算法，找到字符串的最长无重复字符的子串长度。
     * 给定一个字符串A及它的长度n，请返回它的最长无重复字符子串长度。
     * 保证A中字符全部为小写英文字符，且长度小于等于500。
     */
    public int longestSubstring(String A, int n) {
        HashMap<Character,Integer> indexMap = new HashMap<>(n);
        char[] chars = A.toCharArray();
        int maxLength = Integer.MIN_VALUE;

        int pre = 0;
        int now = 0;
        indexMap.put(chars[0],0);
        for (int i = 1; i < n; i++) {
            if (indexMap.get(chars[i]) == null) {
                now = 0;
            }else {
                now = indexMap.get(chars[i]) + 1;
            }

            indexMap.put(chars[i],i);
            pre = now > pre ? now : pre;

            int length = i - pre + 1;
            if (length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength;
    }
}
