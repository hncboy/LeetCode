package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/30 14:13
 * @description 769.最多能完成排序的块
 *
 * 数组arr是[0, 1, ..., arr.length - 1]的一种排列，我们将这个数组分割成几个“块”，并将这些块分别进行排序。
 * 之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
 * 我们最多能将数组分成多少块？
 *
 * 示例 1:
 * 输入: arr = [4,3,2,1,0]
 * 输出: 1
 * 解释:
 * 将数组分成2块或者更多块，都无法得到所需的结果。
 * 例如，分成 [4, 3], [2, 1, 0] 的结果是 [3, 4, 0, 1, 2]，这不是有序的数组。
 *
 * 示例 2:
 * 输入: arr = [1,0,2,3,4]
 * 输出: 4
 * 解释:
 * 我们可以把它分成两块，例如 [1, 0], [2, 3, 4]。
 * 然而，分成 [1, 0], [2], [3], [4] 可以得到最多的块数。
 *
 * 注意:
 * arr 的长度在 [1, 10] 之间。
 * arr[i]是 [0, 1, ..., arr.length - 1]的一种排列。
 */
public class MaxChunksToMakeSorted {

    public static void main(String[] args) {
        MaxChunksToMakeSorted m = new MaxChunksToMakeSorted();
        System.out.println(m.maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
        System.out.println(m.maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
    }

    private int maxChunksToSorted(int[] arr) {
        int result = 0;
        int max = 0;
        // 只要该区间的最大值满足目前遍历到的i个数，即可自成排序区间
        for (int i = 0; i < arr.length; ++i) {
            max = Math.max(max, arr[i]);
            result = max == i ? result + 1 : result;
        }
        return result;
    }
}
