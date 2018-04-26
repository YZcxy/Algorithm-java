package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 词语变形
 */
public class Transform {
    /**
     * 对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，
     * 则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。
     * 给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。
     */
    public boolean chkTransform(String A, int lena, String B, int lenb) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        for (char a : A.toCharArray()) {
            if (map1.get(a) == null) {
                map1.put(a,1);
            }else {
                map1.put(a,map1.get(a)+1);
            }
        }
        for (char b : B.toCharArray()) {
            if (map2.get(b) == null) {
                map2.put(b,1);
            }else {
                map2.put(b,map2.get(b)+1);
            }
        }

        for (Map.Entry<Character,Integer> m : map1.entrySet()) {
            if (map2.get(m.getKey()) != m.getValue()) {
                return false;
            }
        }
        return true;
    }
}
