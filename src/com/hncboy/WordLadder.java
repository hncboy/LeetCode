package com.hncboy;

import javafx.util.Pair;

import java.util.*;

/**
 * @author hncboy
 * @date 2019/11/20 8:32
 * @description 127.单词接龙
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。
 * 转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 *
 * 说明:
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *
 * 示例 1:
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出: 5
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 *
 * 示例 2:
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 输出: 0
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class WordLadder {

    public static void main(String[] args) {
        WordLadder w = new WordLadder();
        System.out.println(w.ladderLength2("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(w.ladderLength2("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
    }

    /**
     * BFS
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    private int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
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

        // 记录已经访问过的 word
        Map<String, Boolean> visitedMap = new HashMap<>();
        visitedMap.put(beginWord, true);

        // 存放符合条件的 Pair，Pair 存放单词和对应的变换过程中的层次
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        while (!queue.isEmpty()) {
            // 取出队列中的一个 Pair
            Pair<String, Integer> pair = queue.poll();
            String word = pair.getKey();
            int level = pair.getValue();
            // 遍历该单词的所有通用状态
            for (int i = 0; i < n; i++) {
                // 截取该单词通用状态
                String generalWord = word.substring(0, i) + "*" + word.substring(i + 1, n);
                // 遍历符合该通用状态的所有单词
                for (String conformWord : comboDictMap.getOrDefault(generalWord, new ArrayList<>())) {
                    // 找到 endWord 则直接返回
                    if (conformWord.equals(endWord)) {
                        return level + 1;
                    }

                    // 该单词未被访问的话，将该单词加入队列
                    if (!visitedMap.containsKey(conformWord)) {
                        visitedMap.put(conformWord, true);
                        queue.add(new Pair<>(conformWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }

    /**
     * 双向 BFS
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    private int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        int n = beginWord.length();
        Map<String, List<String>> comboDictMap = new HashMap<>();
        wordList.forEach(word -> {
            for (int i = 0; i < n; i++) {
                String generalWord = word.substring(0, i) + "*" + word.substring(i + 1, n);
                List<String> generalWordList = comboDictMap.getOrDefault(generalWord, new ArrayList<>());
                generalWordList.add(word);
                comboDictMap.put(generalWord, generalWordList);
            }
        });

        Set<String> beginSet = new HashSet<>(Collections.singleton(beginWord));
        Set<String> endSet = new HashSet<>(Collections.singleton(endWord));
        Set<String> visitedSet = new HashSet<>();
        int level = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // 控制循环从更小的集合开始遍历
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            // 存放下一个 beginSet
            Set<String> nextBeginSet = new HashSet<>();
            // 遍历 beginSet 的每个单词
            for (String word : beginSet) {
                // 遍历该单词的每个通用状态
                for (int i = 0; i < n; i++) {
                    String generalWord = word.substring(0, i) + "*" + word.substring(i + 1);
                    // 遍历符合该通用状态的每个单词
                    for (String conformWord : comboDictMap.getOrDefault(generalWord, new ArrayList<>())) {
                        if (endSet.contains(conformWord))
                            return level + 1;
                        if (!visitedSet.contains(conformWord)) {
                            visitedSet.add(conformWord);
                            nextBeginSet.add(conformWord);
                        }
                    }
                }
            }
            // 更新 beginSet 和 level
            beginSet = nextBeginSet;
            level++;
        }
        return 0;
    }


    /*private int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
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

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        Set<String> visitedSet = new HashSet<>();
        int level = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // 控制循环从更小的集合遍历
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> neighbor = new HashSet<>();
            for (String word : beginSet) {
                for (int i = 0; i < n; i++) {
                    String generalWord = word.substring(0, i) + "*" + word.substring(i + 1);
                    for (String conformWord : comboDictMap.getOrDefault(generalWord, new ArrayList<>())) {
                        if (endSet.contains(conformWord))
                            return level + 1;
                        if (!visitedSet.contains(conformWord)) {
                            visitedSet.add(conformWord);
                            neighbor.add(conformWord);
                        }
                    }
                }
            }
            beginSet = neighbor;
            level++;
        }
        return 0;
    }*/
}

