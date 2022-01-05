package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2022/1/4 8:38
 * 913.猫和老鼠
 * 
 * 两位玩家分别扮演猫和老鼠，在一张 无向 图上进行游戏，两人轮流行动。
 * 图的形式是：graph[a] 是一个列表，由满足 ab 是图中的一条边的所有节点 b 组成。
 *
 * 老鼠从节点 1 开始，第一个出发；猫从节点 2 开始，第二个出发。在节点 0 处有一个洞。
 * 在每个玩家的行动中，他们 必须 沿着图中与所在当前位置连通的一条边移动。例如，如果老鼠在节点 1 ，那么它必须移动到 graph[1] 中的任一节点。
 *
 * 此外，猫无法移动到洞中（节点 0）。
 * 然后，游戏在出现以下三种情形之一时结束：
 *
 * 如果猫和老鼠出现在同一个节点，猫获胜。
 * 如果老鼠到达洞中，老鼠获胜。
 * 如果某一位置重复出现（即，玩家的位置和移动顺序都与上一次行动相同），游戏平局。
 * 给你一张图 graph ，并假设两位玩家都都以最佳状态参与游戏：
 *
 * 如果老鼠获胜，则返回 1；
 * 如果猫获胜，则返回 2；
 * 如果平局，则返回 0 。
 *  
 * 示例 1：
 * 输入：graph = [[2,5],[3],[0,4,5],[1,4,5],[2,3],[0,2,3]]
 * 输出：0
 *
 * 示例 2：
 * 输入：graph = [[1,3],[0],[3],[0,2]]
 * 输出：1
 *
 * 提示：
 * 3 <= graph.length <= 50
 * 1 <= graph[i].length < graph.length
 * 0 <= graph[i][j] < graph.length
 * graph[i][j] != i
 * graph[i] 互不相同
 * 猫和老鼠在游戏中总是移动
 * 通过次数 14,161 提交次数 22,394
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cat-and-mouse
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CatAndMouse {

    public static void main(String[] args) {
        CatAndMouse c = new CatAndMouse();
        System.out.println(c.catMouseGame(new int[][]{{2, 5}, {3}, {0, 4, 5}, {1, 4, 5}, {2, 3}, {0, 2, 3}}));
        System.out.println(c.catMouseGame(new int[][]{{1, 3}, {0}, {3}, {0, 2}}));
    }

    private static final int MOUSE_WIN = 1;
    private static final int CAT_WIN = 2;
    private static final int DRAW = 0;
    private int n;
    private int[][] graph;
    private int[][][] dp;

    public int catMouseGame(int[][] graph) {
        this.n = graph.length;
        this.graph = graph;

        // dp[mouse][cat][turns] 表示老鼠位于节点 mouse、猫位于节点 cat、游戏已经进行了 turns 轮的状态开始
        this.dp = new int[n][n][n * 2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // 猫从节点 1 开始，老鼠从节点 2 开始
        return getResult(1, 2, 0);
    }

    private int getResult(int mouse, int cat, int turns) {
        // 平局
        if (turns == n * 2) {
            return DRAW;
        }
        if (dp[mouse][cat][turns] < 0) {
            if (mouse == 0) {
                // 如果老鼠位于节点 0，则表示老鼠获胜了
                dp[mouse][cat][turns] = MOUSE_WIN;
            } else if (cat == mouse) {
                // 如果老鼠和猫处于相同节点，则表示猫获胜了
                dp[mouse][cat][turns] = CAT_WIN;
            } else {
                getNextResult(mouse, cat, turns);
            }
        }
        return dp[mouse][cat][turns];
    }

    private void getNextResult(int mouse, int cat, int turns) {
        // 根据进行的轮数来决定是当前是老鼠移动还是猫移动
        int currMoveRole = turns % 2 == 0 ? mouse : cat;
        int defaultResult = currMoveRole == mouse ? CAT_WIN : MOUSE_WIN;
        int result = defaultResult;

        // 遍历可以移动的方向
        for (int next : graph[currMoveRole]) {
            // 如果当前是猫移动并且移动到节点 0，则跳过本次移动
            if (currMoveRole == cat && next == 0) {
                continue;
            }

            // 获取猫和老鼠下一步要走的位置
            int nextMouse = currMoveRole == mouse ? next : mouse;
            int nextCat = currMoveRole == cat ? next : cat;
            // 获取移动结果
            int nextResult = getResult(nextMouse, nextCat, turns + 1);
            // 如果移动后的结果不为默认结果
            if (nextResult != defaultResult) {
                result = nextResult;
                if (result != DRAW) {
                    break;
                }
            }
        }
        dp[mouse][cat][turns] = result;
    }
}
