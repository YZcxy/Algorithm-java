package util;

public class ExchangeStr {

    public static void exchangeString(char[] chars,int begin,int end) {
        if (begin < 0 || end > chars.length - 1) return;

        while (begin < end) {
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;

            begin++;
            end--;
        }
    }
}
