package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/25 16:15
 * @description 1144.�ݼ�Ԫ��ʹ����ʾ��״
 * 
 * ����һ����������nums��ÿ�� ���������ѡ��һ��Ԫ�ز� ����Ԫ�ص�ֵ����1��
 *
 * ��������������֮һ��������A���� ������飺
 *
 * ÿ��ż��������Ӧ��Ԫ�ض��������ڵ�Ԫ�أ���A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * ���ߣ�ÿ������������Ӧ��Ԫ�ض��������ڵ�Ԫ�أ���A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * ���ؽ�����numsת��Ϊ��������������С����������
 *
 * ʾ�� 1��
 * ���룺nums = [1,2,3]
 * �����2
 * ���ͣ����ǿ��԰� 2 �ݼ��� 0����� 3 �ݼ��� 1��
 * 
 * ʾ�� 2��
 * ���룺nums = [9,6,1,6,2]
 * �����4
 *
 * ��ʾ��
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 */
public class DecreaseElementsToMakeArrayZigzag {

    public static void main(String[] args) {
        DecreaseElementsToMakeArrayZigzag d = new DecreaseElementsToMakeArrayZigzag();
        System.out.println(d.movesToMakeZigzag(new int[]{1, 2, 3}));
        System.out.println(d.movesToMakeZigzag(new int[]{9, 6, 1, 6, 2}));
        System.out.println(d.movesToMakeZigzag(new int[]{7, 4, 8, 9, 7, 7, 5}));
    }

    public int movesToMakeZigzag(int[] nums) {
        int evenCount = getCount(nums.clone(), 0);
        if (evenCount == 0) {
            return 0;
        }
        return Math.min(evenCount, getCount(nums, 1));
    }

    /**
     * �����ڵ�Ԫ�رȽ�
     *
     * @param nums
     * @param start 0 ż�������������� 1 ����������������
     * @return
     */
    private int getCount(int[] nums, int start) {
        int count = 0;
        for (int i = start; i < nums.length; i += 2) {
            // ���ǰһ�������ڵ��ڸ�������ǰһ������ֵ�޸�Ϊ��ǰ����-1
            if (i - 1 >= 0 && nums[i] <= nums[i - 1]) {
                count += nums[i - 1] - nums[i] + 1;
                nums[i - 1] = nums[i] - 1;
            }
            // �����һ�������ڵ��ڸ���������һ������ֵ�޸�Ϊ��ǰ����-1
            if (i + 1 < nums.length && nums[i] <= nums[i + 1]) {
                count += nums[i + 1] - nums[i] + 1;
                nums[i + 1] = nums[i] - 1;
            }
        }
        return count;
    }
}
