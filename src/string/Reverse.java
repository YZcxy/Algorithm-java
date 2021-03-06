package string;

import util.ExchangeStr;

/**
 * 句子的逆序
 */
public class Reverse {
    /**
     * 对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
     * 给定一个原字符串A和他的长度，请返回逆序后的字符串。
     */
    public String reverseSentence(String A, int n) {
        char[] chars = A.toCharArray();

        ExchangeStr.exchangeString(chars,0,n-1);

        int begin = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == ' '){
                ExchangeStr.exchangeString(chars,begin,i-1);
                begin = i+1;
            }
        }
        ExchangeStr.exchangeString(chars,begin,n-1);
        return new String(chars);
    }


}
