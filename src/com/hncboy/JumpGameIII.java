package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/29 10:29
 * @description 1306.��Ծ��Ϸ III
 *
 * ������һ���Ǹ���������arr�����ʼλ�ڸ��������ʼ�±�start����
 * ����λ���±�i��ʱ�����������i + arr[i] ���� i - arr[i]��
 * �����ж��Լ��Ƿ��ܹ�������ӦԪ��ֵΪ 0 �� ���� �±괦��
 * ע�⣬������ʲô����£��㶼�޷���������֮�⡣
 *
 * ʾ�� 1��
 * ���룺arr = [4,2,3,0,3,1,2], start = 5
 * �����true
 * ���ͣ�
 * ����ֵΪ 0 ���±� 3 �����¿��ܷ����� 
 * �±� 5 -> �±� 4 -> �±� 1 -> �±� 3 
 * �±� 5 -> �±� 6 -> �±� 4 -> �±� 1 -> �±� 3 
 * 
 * ʾ�� 2��
 * ���룺arr = [4,2,3,0,3,1,2], start = 0
 * �����true 
 * ���ͣ�
 * ����ֵΪ 0 ���±� 3 �����¿��ܷ����� 
 * �±� 0 -> �±� 4 -> �±� 1 -> �±� 3
 * 
 * ʾ�� 3��
 * ���룺arr = [3,0,2,1,2], start = 2
 * �����false
 * ���ͣ��޷�����ֵΪ 0 ���±� 1 ���� 
 *
 * ��ʾ��
 * 1 <= arr.length <= 5 * 10^4
 * 0 <= arr[i] <arr.length
 * 0 <= start < arr.length
 */
public class JumpGameIII {

    public static void main(String[] args) {
        JumpGameIII j = new JumpGameIII();
        System.out.println(j.canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
        System.out.println(j.canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 0));
        System.out.println(j.canReach(new int[]{3, 0, 2, 1, 2}, 2));
    }

    private boolean canReach(int[] arr, int start) {
        return dfs(start, arr, new boolean[arr.length]);
    }

    private boolean dfs(int start, int[] arr, boolean[] visited) {
        if (start < 0 || start >= arr.length || visited[start]) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        visited[start] = true;
        return dfs(start + arr[start], arr, visited) || dfs(start - arr[start], arr, visited);
    }
}
