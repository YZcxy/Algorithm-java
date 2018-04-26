package string;

import java.util.*;

/**
 * 拼接最小字典序
 */
public class Prior {
    /**
     * 对于一个给定的字符串数组，请找到一种拼接顺序，使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。
     * 给定一个字符串数组strs，同时给定它的大小，请返回拼接成的串。
     */
    public String findSmallest(String[] strs, int n) {
        ArrayList<String> list = new ArrayList<>(n);

        for (String str : strs) {
            list.add(str);
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                for (int i = 0; i < str1.length(); i++) {
                    if (str1.charAt(i) != str2.charAt(i)){
                        return str1.charAt(i) - str2.charAt(i);
                    }
                }
                return 0;
            }
        });

        StringBuffer sb = new StringBuffer();
        for (String str : list) {
            sb.append(str);
        }

        return sb.toString();
    }
}
