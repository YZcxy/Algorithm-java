package string;

/**
 * 空格替换
 */
public class Replacement {
    /**
     * 请编写一个方法，将字符串中的空格全部替换为“%20”。
     * 假定该字符串有足够的空间存放新增的字符，
     * 并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。
     * 给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。
     */
    public String replaceSpace(String iniString, int length) {
        int num = 0;
        length = iniString.length();
        char[] chars = iniString.toCharArray();

        for (char c : chars) {
            if (c == ' ') {
                num++;
            }
        }

        int newLength = length + (num * 3);
        char[] newChars = new char[newLength];
        int j = newLength-1;
        for (int i = length-1; i >= 0; i--) {
            if (chars[i] == ' '){
                newChars[j--] = '0';
                newChars[j--] = '2';
                newChars[j--] = '%';
            }else {
                newChars[j--] = chars[i];
            }
        }
        return new String(newChars);
    }

    public static void main(String[] args) {
        Replacement r = new Replacement();
        r.replaceSpace("Mr John Smith",13);
    }
}
