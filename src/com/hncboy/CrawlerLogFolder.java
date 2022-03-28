package com.hncboy;

/**
 * @author hncboy
 * @date 2022/3/28 8:46
 * 1598.文件夹操作日志搜集器
 *
 * 每当用户执行变更文件夹操作时，LeetCode 文件系统都会保存一条日志记录。
 * 下面给出对变更操作的说明：
 *
 * "../" ：移动到当前文件夹的父文件夹。如果已经在主文件夹下，则 继续停留在当前文件夹 。
 * "./" ：继续停留在当前文件夹。
 * "x/" ：移动到名为 x 的子文件夹中。题目数据 保证总是存在文件夹 x 。
 * 给你一个字符串列表 logs ，其中 logs[i] 是用户在 ith 步执行的操作。
 *
 * 文件系统启动时位于主文件夹，然后执行 logs 中的操作。
 * 执行完所有变更文件夹操作后，请你找出 返回主文件夹所需的最小步数 。
 *
 * 示例 1：
 * 输入：logs = ["d1/","d2/","../","d21/","./"]
 * 输出：2
 * 解释：执行 "../" 操作变更文件夹 2 次，即可回到主文件夹
 *
 * 示例 2：
 * 输入：logs = ["d1/","d2/","./","d3/","../","d31/"]
 * 输出：3
 *
 * 示例 3：
 * 输入：logs = ["d1/","../","../","../"]
 * 输出：0
 *
 * 提示：
 * 1 <= logs.length <= 103
 * 2 <= logs[i].length <= 10
 * logs[i] 包含小写英文字母，数字，'.' 和 '/'
 * logs[i] 符合语句中描述的格式
 * 文件夹名称由小写英文字母和数字组成
 * 通过次数 12,704 提交次数 18,882
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/crawler-log-folder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CrawlerLogFolder {

    public static void main(String[] args) {
        CrawlerLogFolder c = new CrawlerLogFolder();
        System.out.println(c.minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"}));
        System.out.println(c.minOperations(new String[]{"d1/","d2/","./","d3/","../","d31/"}));
        System.out.println(c.minOperations(new String[]{"d1/","../","../","../"}));
    }

    public int minOperations(String[] logs) {
        int result = 0;
        for (String log : logs) {
            if ("../".equals(log)) {
                result = Math.max(0, result - 1);
                continue;
            }

            if ("./".equals(log)) {
                continue;
            }

            result++;
        }

        return result;
    }
}
