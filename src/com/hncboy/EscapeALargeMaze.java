package com.hncboy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hncboy
 * @date 2022/1/11 8:44
 * 1036.逃离大迷宫 TODO
 * 在一个 106 x 106 的网格中，每个网格上方格的坐标为 (x, y) 。
 *
 * 现在从源方格 source = [sx, sy] 开始出发，意图赶往目标方格 target = [tx, ty] 。
 * 数组 blocked 是封锁的方格列表，其中每个 blocked[i] = [xi, yi] 表示坐标为 (xi, yi) 的方格是禁止通行的。
 *
 * 每次移动，都可以走到网格中在四个方向上相邻的方格，只要该方格 不 在给出的封锁列表 blocked 上。同时，不允许走出网格。
 * 只有在可以通过一系列的移动从源方格 source 到达目标方格 target 时才返回 true。否则，返回 false。
 *
 * 示例 1：
 * 输入：blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
 * 输出：false
 * 解释：
 * 从源方格无法到达目标方格，因为我们无法在网格中移动。
 * 无法向北或者向东移动是因为方格禁止通行。
 * 无法向南或者向西移动是因为不能走出网格。
 *
 * 示例 2：
 * 输入：blocked = [], source = [0,0], target = [999999,999999]
 * 输出：true
 * 解释：
 * 因为没有方格被封锁，所以一定可以到达目标方格。
 *  
 * 提示：
 * 0 <= blocked.length <= 200
 * blocked[i].length == 2
 * 0 <= xi, yi < 106
 * source.length == target.length == 2
 * 0 <= sx, sy, tx, ty < 106
 * source != target
 * 题目数据保证 source 和 target 不在封锁列表内
 *
 * 通过次数 5,241 提交次数 14,509
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/escape-a-large-maze
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EscapeALargeMaze {

    private final Set<Integer> blockSet = new HashSet<>();
    private final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private final int n = 1000000;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        for (int[] b : blocked) {
            blockSet.add(b[0] * n + b[1]);
        }
        if (blockSet.isEmpty()) {
            return true;
        }
        return dfs(source[0], source[1], source, target, new HashSet<>())
                && dfs(target[0], target[1], target, source, new HashSet<>());
    }

    private boolean dfs(int currX, int currY, int[] source, int[] target, Set<Integer> visited) {
        // 当前点到达目标点，直接返回 true
        if (currX == target[0] && currY == target[1]) {
            return true;
        }
        if (Math.abs(source[0] - currX) + Math.abs(source[1] - currY) > 200) {
            return true;
        }
        visited.add(currX * n + currY);

        // 遍历四个方向
        for (int[] direction : directions) {
            int x = currX + direction[0];
            int y = currY + direction[1];
            int id = x * n + y;
            if (x >= 0 && x < n && y >= 0 && y < n && !blockSet.contains(id) && !visited.contains(id)) {
                if (dfs(x, y, source, target, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
