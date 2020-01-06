package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2020/1/5 10:22
 * @description 1311.获取你好友已观看的视频
 *
 * 有 n 个人，每个人都有一个  0 到 n-1 的唯一 id 。
 * 给你数组 watchedVideos  和 friends ，其中 watchedVideos[i]  和 friends[i] 
 * 分别表示 id = i 的人观看过的视频列表和他的好友列表。
 * Level 1 的视频包含所有你好友观看过的视频，level 2 的视频包含所有你好友的好友观看过的视频，
 * 以此类推。一般的，Level 为 k 的视频包含所有从你出发，最短距离为 k 的好友观看过的视频。
 * 给定你的 id  和一个 level 值，请你找出所有指定 level 的视频，并将它们按观看频率升序返回。
 * 如果有频率相同的视频，请将它们按名字字典序从小到大排列。
 *  
 *
 * 示例 1：
 * 输入：watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 1
 * 输出：["B","C"]
 * 解释：
 * 你的 id 为 0 ，你的朋友包括：
 * id 为 1 -> watchedVideos = ["C"] 
 * id 为 2 -> watchedVideos = ["B","C"] 
 * 你朋友观看过视频的频率为：
 * B -> 1 
 * C -> 2
 *
 * 示例 2：
 * 输入：watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 2
 * 输出：["D"]
 * 解释：
 * 你的 id 为 0 ，你朋友的朋友只有一个人，他的 id 为 3 。
 *  
 * 提示：
 * n == watchedVideos.length == friends.length
 * 2 <= n <= 100
 * 1 <= watchedVideos[i].length <= 100
 * 1 <= watchedVideos[i][j].length <= 8
 * 0 <= friends[i].length < n
 * 0 <= friends[i][j] < n
 * 0 <= id < n
 * 1 <= level < n
 * 如果 friends[i] 包含 j ，那么 friends[j] 包含 i
 */
public class GetWatchedVideosByYourFriends {

    public static void main(String[] args) {
        GetWatchedVideosByYourFriends g = new GetWatchedVideosByYourFriends();
        List<List<String>> watchedVideos = Arrays.asList(Arrays.asList("A", "B"), Arrays.asList("C"),
                Arrays.asList("B", "C"), Arrays.asList("D"));
        int[][] friends = {{1, 2}, {0, 3}, {0, 3}, {1, 2}};
        System.out.println(g.watchedVideosByFriends(watchedVideos, friends, 0, 1));
        System.out.println(g.watchedVideosByFriends(watchedVideos, friends, 0, 2));

        List<List<String>> watchedVideos2 = Arrays.asList(Arrays.asList("m"), Arrays.asList("xaqhyop","lhvh"));
        int[][] friends2 = {{1}, {0}};
        System.out.println(g.watchedVideosByFriends(watchedVideos2, friends2, 1, 0));
    }

    private List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Map<String, Integer> map = new HashMap<>();
        LinkedList<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.addLast(id);
        visited.add(id);

        int depth = -1;
        while (!queue.isEmpty()) {
            depth++;
            if (depth >= level) {
                // 遍历所有的朋友
                for (Integer friend : queue) {
                    // 遍历该朋友看过的所有电视
                    for (String video : watchedVideos.get(friend)) {
                        map.put(video, map.getOrDefault(video, 0) + 1);
                    }
                }
                break;
            }

            int size = queue.size();
            // 遍历删除该 level 中的所有朋友
            for (int i = 0; i < size; i++) {
                Integer first = queue.removeFirst();
                // 遍历加入下一 level 的所有朋友
                for (int friend : friends[first]) {
                    if (!visited.contains(friend)) {
                        queue.addLast(friend);
                        visited.add(friend);
                    }
                }
            }
        }

        // 获取所有视频
        List<String> result = new ArrayList<>(map.keySet());
        result.sort((o1, o2) -> {
            Integer count1 = map.get(o1);
            Integer count2 = map.get(o2);
            // 如果数量相等的话按字典序排序否则按数量排序
            return count1.equals(count2) ? o1.compareTo(o2) : count1 - count2;
        });

        return result;
    }
}
