package com.hncboy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/10/27 10:30
 * @description 1237.找出给定方程的正整数解
 */
public class FindPositiveIntegerSolutionForAGivenEquation {

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= z; i++) {
            for (int j = i; j <= z; j++) {
                if (customfunction.f(i, j) == z
                        && customfunction.f(i, j) < customfunction.f(i, j + 1)
                        && customfunction.f(i, j) < customfunction.f(i + 1, j)) {
                    result.add(Arrays.asList(i, j));
                }
                if (i != j && customfunction.f(j, i) == z
                        && customfunction.f(j, i) < customfunction.f(j, i + 1)
                        && customfunction.f(j, i) < customfunction.f(j + 1, i)) {
                    result.add(Arrays.asList(j, i));
                }
            }
        }
        return result;
    }

    interface CustomFunction {
        int f(int x, int y);
    }
}
