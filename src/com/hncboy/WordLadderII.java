package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2019/11/29 8:31
 * @description 126.单词接龙 II
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。
 * 转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *
 * 示例 1:
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 *
 * 示例 2:
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 输出: []
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 */
public class WordLadderII {

    public static void main(String[] args) {
        WordLadderII w = new WordLadderII();
        System.out.println(w.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(w.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
    }

    /**
     * BFS
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    private List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return result;
        }

        // 单词字母的长度
        int n = beginWord.length();

        // 对应预处理之后通用单词状态的 map，每种通用状态对应一组 word 集合
        Map<String, List<String>> comboDictMap = new HashMap<>();
        wordList.forEach(word -> {
            for (int i = 0; i < n; i++) {
                // 截取通用单词状态
                String generalWord = word.substring(0, i) + "*" + word.substring(i + 1, n);
                List<String> generalWordList = comboDictMap.getOrDefault(generalWord, new ArrayList<>());
                generalWordList.add(word);
                // 将对应该状态的单词插入 map 中
                comboDictMap.put(generalWord, generalWordList);
            }
        });

        // 存放已经访问过的单词
        Set<String> visitedSet = new HashSet<>(Collections.singletonList(beginWord));

        List<String> first = new ArrayList<>(Collections.singletonList(beginWord));
        // 存放每一层的结果队列
        Queue<List<String>> queue = new LinkedList<>(Collections.singletonList(first));

        // 判断是否到达符合条件的层
        boolean isFinish = false;

        while (!queue.isEmpty() && !isFinish) {
            // 上一层的路径数量
            int size = queue.size();
            // 用于记录该层中的单词是否已经访问过，因为有些单词在同一层中可能会被重复访问
            Set<String> subVisitedSet = new HashSet<>();
            // 遍历上一层所有路径
            for (int i = 0; i < size; i++) {
                // 取出对应的路径
                List<String> subPath = queue.poll();
                // 取出路径的最后一个单词
                String word = subPath.get(subPath.size() - 1);
                // 遍历该单词的所有通用状态
                for (int j = 0; j < n; j++) {
                    // 截取该单词通用状态
                    String generalWord = word.substring(0, j) + "*" + word.substring(j + 1, n);
                    // 遍历符合该通用状态的所有单词
                    for (String conformWord : comboDictMap.getOrDefault(generalWord, new ArrayList<>())) {
                        // 如果该单词没有被访问
                        if (!visitedSet.contains(conformWord)) {
                            // 构造新的路径加入该单词
                            List<String> newSubPath = new ArrayList<>(subPath);
                            newSubPath.add(conformWord);
                            queue.add(newSubPath);
                            subVisitedSet.add(conformWord);
                            // 如果满足最后一个单词，则为最短路径
                            if (conformWord.equals(endWord)) {
                                // 标记完成
                                isFinish = true;
                                result.add(newSubPath);
                            }
                        }
                    }
                }
            }
            // 将该层所有访问的单词添加到集合中
            visitedSet.addAll(subVisitedSet);
        }

        return result;
    }

    /**
     * 双向 BFS + DFS
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    private List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
        // TODO
        return null;
    }
}
