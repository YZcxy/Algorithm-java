package string;

import util.ExchangeStr;

/**
 * 字符串移位
 */
public class Translation {
    /**
     * 对于一个字符串，请设计一个算法，将字符串的长度为len的前缀平移到字符串的最后。
     * 给定一个字符串A和它的长度，同时给定len，请返回平移后的字符串。
     */
    public String stringTranslation(String A, int n, int len) {
        char[] chars = A.toCharArray();

        ExchangeStr.exchangeString(chars,0,len-1);
        ExchangeStr.exchangeString(chars,len,n-1);
        ExchangeStr.exchangeString(chars,0,n-1);

        return new String(chars);
    }


}
