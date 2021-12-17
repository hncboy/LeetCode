package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/12/17 18:33
 * @description 剑指 Offer II 087.复原 IP
 * 
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，
 * 但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 *
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 *
 * 示例 2：
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 *
 * 示例 3：
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 *
 * 示例 4：
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 *
 * 示例 5：
 * 输入：s = "10203040"
 * 输出：["10.20.30.40","102.0.30.40","10.203.0.40"]
 *  
 * 提示：
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 *
 * 注意：本题与主站 93 题 {@link com.hncboy.RestoreIpAddresses} 相同：https://leetcode-cn.com/problems/restore-ip-addresses/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/0on3uN
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question087 {

    public List<String> restoreIpAddresses(String s) {
        List<String> ipList = new ArrayList<>();
        int n = s.length();
        // 超出 ip 长度
        if (n > 12 || n < 4) {
            return ipList;
        }

        Deque<String> path = new ArrayDeque<>(4);
        dfs(s, n, 0, 4, path, ipList);
        return ipList;
    }

    private void dfs(String s, int n, int begin, int residue, Deque<String> path, List<String> ipList) {
        // 如果已经到达最大长度了
        if (begin == n) {
            // 判断是否剩余 0 个段未拼接
            if (residue == 0) {
                ipList.add(String.join(".", path));
            }
            return;
        }

        // 遍历 ip 其中一段的整数，范围为 0-255
        for (int i = begin; i < begin + 3 && i < n; i++) {
            // 判断剩余的数字个数是否大于所需拼接 ip 段的所有整数之和
            if (residue * 3 < n - i) {
                continue;
            }

            // 判断 [beign, i] 中间的整数是否符合 ip 一段规则
            if (judgeIpSegment(s, begin, i)) {
                // 获取 ip 段
                String currentIpSegment = s.substring(begin, i + 1);

                path.addLast(currentIpSegment);
                dfs(s, n, i + 1, residue - 1, path, ipList);
                path.removeLast();
            }
        }
    }

    /**
     * 计算整数是否在 [0,255] 区间
     */
    private boolean judgeIpSegment(String s, int left, int right) {
        if (right > left && s.charAt(left) == '0') {
            return false;
        }

        int result = 0;
        while (left <= right) {
            result = result * 10 + s.charAt(left) - '0';
            left++;
        }

        return result >= 0 && result <= 255;
    }
}
