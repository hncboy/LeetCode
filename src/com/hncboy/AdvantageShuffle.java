package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2019/12/3 14:55
 * @description 870.优势洗牌
 *
 * 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
 * 返回 A 的任意排列，使其相对于 B 的优势最大化。
 *
 * 示例 1：
 * 输入：A = [2,7,11,15], B = [1,10,4,11]
 * 输出：[2,11,7,15]
 *
 * 示例 2：
 * 输入：A = [12,24,8,32], B = [13,25,32,11]
 * 输出：[24,32,8,12]
 *  
 * 提示：
 * 1 <= A.length = B.length <= 10000
 * 0 <= A[i] <= 10^9
 * 0 <= B[i] <= 10^9
 */
public class AdvantageShuffle {

    public static void main(String[] args) {
        AdvantageShuffle a = new AdvantageShuffle();
        int[] A1 = {2, 7, 11, 15};
        int[] B1 = {1, 10, 4, 11};
        int[] A2 = {12, 24, 8, 32, 2};
        int[] B2 = {13, 25, 32, 11, 1};
        System.out.println(Arrays.toString(a.advantageCount(A1, B1)));
        System.out.println(Arrays.toString(a.advantageCount(A2, B2)));
    }

    private int[] advantageCount(int[] A, int[] B) {
        // 存放B中牌对应的下标
        Map<Integer, Queue<Integer>> map = new HashMap<>(B.length);
        for (int i = 0; i < B.length; i++) {
            if (map.containsKey(B[i])) {
                map.get(B[i]).add(i);
            } else {
                map.put(B[i], new LinkedList<>(Collections.singletonList(i)));
            }
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int[] result = new int[A.length];
        // 比较排序后的牌
        for (int i = 0, j = 0, k = A.length - 1; i < A.length; i++) {
            if (A[i] > B[j]) {
                result[map.get(B[j++]).poll()] = A[i];
            } else {
                result[map.get(B[k--]).poll()] = A[i];
            }
        }
        return result;
    }
}
