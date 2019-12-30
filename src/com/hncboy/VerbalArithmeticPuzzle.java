package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2019/12/29 10:29
 * @description 1307.��������
 * 
 * ����һ�����̣������words��ʾ���ұ���result ��ʾ��
 * ����Ҫ�������¹����鷽���Ƿ�ɽ⣺
 * ÿ���ַ����ᱻ�����һλ���֣�0 - 9����
 * ÿ�Բ�ͬ���ַ�����ӳ�䵽��ͬ�����֡�
 * ÿ�� words[i] �� result���ᱻ�����һ��û��ǰ��������֡�
 * �������֮�ͣ�words�������Ҳ����֣�result����
 * ������̿ɽ⣬����True�����򷵻�False��
 *
 * ʾ�� 1��
 * ���룺words = ["SEND","MORE"], result = "MONEY"
 * �����true
 * ���ͣ�ӳ�� 'S'-> 9, 'E'->5, 'N'->6, 'D'->7, 'M'->1, 'O'->0, 'R'->8, 'Y'->'2'
 * ���� "SEND" + "MORE" = "MONEY" ,  9567 + 1085 = 10652
 * 
 * ʾ�� 2��
 * ���룺words = ["SIX","SEVEN","SEVEN"], result = "TWENTY"
 * �����true
 * ���ͣ�ӳ�� 'S'-> 6, 'I'->5, 'X'->0, 'E'->8, 'V'->7, 'N'->2, 'T'->1, 'W'->'3', 'Y'->4
 * ���� "SIX" + "SEVEN" + "SEVEN" = "TWENTY" ,  650 + 68782 + 68782 = 138214
 * 
 * ʾ�� 3��
 * ���룺words = ["THIS","IS","TOO"], result = "FUNNY"
 * �����true
 * 
 * ʾ�� 4��
 * ���룺words = ["LEET","CODE"], result = "POINT"
 * �����false
 *
 * ��ʾ��
 * 2 <= words.length <= 5
 * 1 <= words[i].length,results.length<= 7
 * words[i], resultֻ���д�дӢ����ĸ
 * ���ʽ��ʹ�õĲ�ͬ�ַ������Ϊ10
 */
public class VerbalArithmeticPuzzle {

    public static void main(String[] args) {
        VerbalArithmeticPuzzle v = new VerbalArithmeticPuzzle();
        System.out.println(v.isSolvable(new String[]{"SEND", "MORE"}, "MONEY"));
        System.out.println(v.isSolvable(new String[]{"SIX", "SEVEN", "SEVEN"}, "TWENTY"));
        System.out.println(v.isSolvable(new String[]{"THIS", "IS", "TOO"}, "FUNNY"));
        System.out.println(v.isSolvable(new String[]{"LEET", "CODE"}, "POINT"));
    }

    /**
     * ��������ַ��� map
     */
    private Map<Character, Integer> charMap = new HashMap<>();
    /**
     * ��Ų�Ϊ0���ַ����� word �� result �����ַ�
     */
    private int[] notZero = new int[26];
    /**
     * �ж��Ƿ���ʸ�����
     */
    private boolean[] visited = new boolean[10];
    /**
     * �����������ַ���Ȩֵ
     */
    private int[] left = new int[10];
    /**
     * ����ұ������ַ���Ȩֵ
     */
    private int[] right = new int[10];

    public boolean isSolvable(String[] words, String result) {
        // ���� word �� result �������ַ����� map
        // key Ϊ�ַ���value ���ַ������ҳ��ֵ�˳���Ѵ�����ַ�ȡ��һ�ε�˳�򣬷�ΧΪ[0,9]
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                charMap.put(ch, charMap.getOrDefault(ch, charMap.size()));
            }
        }
        for (char ch : result.toCharArray()) {
            charMap.put(ch, charMap.getOrDefault(ch, charMap.size()));
        }

        // �� word �е����ַ���˳����� notZero ���飬������ word �����ַ���Ȩ��
        for (String word : words) {
            notZero[charMap.get(word.charAt(0))] = -1;
            setWight(word, left);
        }
        // �� result �е����ַ���˳����� notZero ���飬������ result �����ַ���Ȩ��
        notZero[charMap.get(result.charAt(0))] = -1;
        setWight(result, right);

        return dfs(0, charMap.size(), 0, 0);
    }

    private boolean dfs(int start, int length, int l, int r) {
        if (start == length) {
            return l == r;
        }

        for (int i = 0; i <= 9; i++) {
            // ��ǰ�ַ��Ѿ����ʹ��������ַ�Ϊ 0 �Ļ�����ѭ��
            if (visited[i] || (i == 0 && notZero[start] == -1)) {
                continue;
            }

            visited[i] = true;
            // l + i * left[start] �� r + i * right[start] �����������ߵ�Ȩֵ
            // ����ߵ�Ȩֵ�����ұߵ�Ȩֵʱ�������ߵ�ֵ��ȣ�ͨ��Ȩֵ�������ߵ�ֵ
            if (dfs(start + 1, length, l + i * left[start], r + i * right[start])) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

    /**
     * ����Ȩ��
     *
     * @param s
     * @param weight
     */
    private void setWight(String s, int[] weight) {
        int value = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            weight[charMap.get(s.charAt(i))] += value;
            value *= 10;
        }
    }
}
