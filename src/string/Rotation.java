package string;

import util.KPM;
/**
 * 如果对于一个字符串A，将A的前面任意一部分挪到后边去形成的字符串称为A的旋转词。
 * 比如A="12345",A的旋转词有"12345","23451","34512","45123"和"51234"。对于两个字符串A和B，请判断A和B是否互为旋转词。
 * 给定两个字符串A和B及他们的长度lena，lenb，请返回一个bool值，代表他们是否互为旋转词。
 */
public class Rotation {
	
    /**
     * 分析：首先判断A和B长度是否相等，如果相等，复制A并且合并A1+A2，然后判断合并字符串是否包含B即可。
     * 可优化的地方为找到合并字符串是否包含B，暴力求解释可以的，但是时间复杂度不够好，最好选用KMP算法。
     */
    public boolean chkRotation(String A, int lena, String B, int lenb) {
    	if (lena != lenb) return false;
        
        String subA = A + A;
  		
        return KPM.isContain(subA,B);
    }
    
    
}