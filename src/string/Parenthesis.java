package string;

/**
 * 合法括号序列
 */
public class Parenthesis {
    /**
     * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
     * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
     */
    public boolean chkParenthesis(String A, int n) {
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (num < 0) return false;
            if (A.charAt(i) == '(') {
                num++;
            }
            else if (A.charAt(i) == ')') {
                num--;
            }
        }
        if (num == 0) return true;
        return false;
    }
}
