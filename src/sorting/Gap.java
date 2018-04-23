package sorting;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 相邻两树最大差
 */
public class Gap {
    /**
     * 有一个整形数组A，请设计一个复杂度为O(n)的算法，算出排序后相邻两数的最大差值。
     * 给定一个int数组A和A的大小n，请返回最大的差值。保证数组元素多于1个。
     */
    public int maxGap(int[] A, int n) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : A) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }

        int pitch = max - min;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(n+1);
        int num = 1;
        for (int i = 1; i <= n + 1; i++) {
            ArrayList<Integer> bucket = new ArrayList<>();
            buckets.add(bucket);
        }

        for (int a : A) {
            int temp = ((a * n) - (min * n)) / pitch;
            ArrayList<Integer> bucket = buckets.get((temp-1)>0?temp-1:0);
            bucket.add(a);
        }

        int lastMAX = 0;
        int nextMin = 0;
        int bigGap = 0;
        ArrayList<Integer> lastBucket = null;
        ArrayList<Integer> nextBucket = null;
        for (int i=0; i <= n; i++) {
            if ((lastBucket = buckets.get(i)).size() == 0) {
                continue;
            }

            int j = i+1;
            while (j <= n) {
                if ((nextBucket = buckets.get(j)).size() != 0){
                    break;
                }
                nextBucket = null;
                j++;
            }

            if (nextBucket == null) break;

            Collections.sort(lastBucket);
            Collections.sort(nextBucket);

            lastMAX = lastBucket.get(lastBucket.size()-1);
            nextMin = nextBucket.get(0);

            int tempGap = nextMin - lastMAX;
            if (tempGap > bigGap) {
                bigGap = tempGap;
            }

        }

        return bigGap;

    }
}
