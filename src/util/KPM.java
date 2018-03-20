package util;

/**
 * KPM算法，提供两篇比较好理解的博客
 * https://kb.cnblogs.com/page/176818/
 * http://blog.csdn.net/hyjoker/article/details/51190726
 */
public class KPM {
	
    /**
     * KPM核心算法，比较两个字符串，遇到不匹配时，
     * 只需要将B字符串回退到最大公共元素即可，A字符串不会回退。
     * 因此时间复制度为O(n+m);
     */
	public static boolean isContain(String strA, String strB) {
    	boolean res = false;
    
    	if (strA == null || strB == null 
          || strA.length() < strB.length() ) return res;

    	int j = 0;
        int[] next = getNext(strB);

        for (int i = 0; i < strA.length(); i++) {
            while (j > 0 && strA.charAt(i) != strB.charAt(j)) j = next[j];
            
            if (strA.charAt(i) == strB.charAt(j)) j++;
            
            if (j == strB.length()) {
            	res = true;
                break;
            }
        }
        
        return res;
    }
		
    /**
     * 根据传递的字符串，求出其对应的next数组
     */
    private static int[] getNext (String str) {
    	
        int len = str.length();
        int j = 0;
        
        int[] next = new int[len+1];
        next[0] = next[1] = 0;
        
        for (int i = 0; i < len; i++) {
        	while (j > 0 && str.charAt(i) != str.charAt(j)) j = next[j];
            
            if (str.charAt(i) == str.charAt(j)) j++;
            
            next[i+1] = j;
        }
        
        return next;
    }
}