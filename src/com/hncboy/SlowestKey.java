package com.hncboy;

/**
 * @author hncboy
 * @date 2022/1/9 12:44
 * 1629.按键持续时间最长的键
 */
public class SlowestKey {

    public static void main(String[] args) {
        SlowestKey s = new SlowestKey();
        System.out.println(s.slowestKey(new int[]{9, 29, 49, 50}, "cbcd"));
        System.out.println(s.slowestKey(new int[]{12,23,36,46,62}, "spuda"));
    }

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxTime = releaseTimes[0];
        char result = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            char key = keysPressed.charAt(i);
            int time = releaseTimes[i] - releaseTimes[i - 1];
            if (time > maxTime || (time == maxTime && key > result)) {
                result = key;
                maxTime = time;
            }
        }
        return result;
    }
}
