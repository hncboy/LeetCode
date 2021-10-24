package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2021/10/24 10:43
 * @description 638.大礼包
 * 
 * 在 LeetCode 商店中， 有 n 件在售的物品。每件物品都有对应的价格。然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
 *
 * 给你一个整数数组 price 表示物品价格，其中 price[i] 是第 i 件物品的价格。
 * 另有一个整数数组 needs 表示购物清单，其中 needs[i] 是需要购买第 i 件物品的数量。
 *
 * 还有一个数组 special 表示大礼包，special[i] 的长度为 n + 1 ，
 * 其中 special[i][j] 表示第 i 个大礼包中内含第 j 件物品的数量，且 special[i][n] （也就是数组中的最后一个整数）为第 i 个大礼包的价格。
 *
 * 返回 确切 满足购物清单所需花费的最低价格，你可以充分利用大礼包的优惠活动。
 * 你不能购买超出购物清单指定数量的物品，即使那样会降低整体价格。任意大礼包可无限次购买。
 *
 * 示例 1：
 * 输入：price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]
 * 输出：14
 * 解释：有 A 和 B 两种物品，价格分别为 ¥2 和 ¥5 。 
 * 大礼包 1 ，你可以以 ¥5 的价格购买 3A 和 0B 。 
 * 大礼包 2 ，你可以以 ¥10 的价格购买 1A 和 2B 。 
 * 需要购买 3 个 A 和 2 个 B ， 所以付 ¥10 购买 1A 和 2B（大礼包 2），以及 ¥4 购买 2A 。
 *
 * 示例 2：
 * 输入：price = [2,3,4], special = [[1,1,0,4],[2,2,1,9]], needs = [1,2,1]
 * 输出：11
 * 解释：A ，B ，C 的价格分别为 ¥2 ，¥3 ，¥4 。
 * 可以用 ¥4 购买 1A 和 1B ，也可以用 ¥9 购买 2A ，2B 和 1C 。 
 * 需要买 1A ，2B 和 1C ，所以付 ¥4 买 1A 和 1B（大礼包 1），以及 ¥3 购买 1B ， ¥4 购买 1C 。 
 * 不可以购买超出待购清单的物品，尽管购买大礼包 2 更加便宜。
 *
 * 提示：
 * n == price.length
 * n == needs.length
 * 1 <= n <= 6
 * 0 <= price[i] <= 10
 * 0 <= needs[i] <= 10
 * 1 <= special.length <= 100
 * special[i].length == n + 1
 * 0 <= special[i][j] <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shopping-offers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShoppingOffers {

    public static void main(String[] args) {
        ShoppingOffers s = new ShoppingOffers();
        List<Integer> price = Arrays.asList(2, 5);
        List<List<Integer>> special = Arrays.asList(Arrays.asList(3, 0, 5), Arrays.asList(1, 2, 10));
        List<Integer> needs = Arrays.asList(3, 2);
        System.out.println(s.shoppingOffers(price, special, needs));
    }

    private final Map<List<Integer>, Integer> memo = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // 物品类型的数量
        int productTypeNum = price.size();

        // 过滤不需要计算的大礼包，只保留需要计算的大礼包
        List<List<Integer>> filterSpecialList = new ArrayList<>();
        for (List<Integer> specialBag : special) {
            int totalCount = 0;
            int totalPrice = 0;

            // 遍历礼包中的所有商品
            for (int i = 0; i < productTypeNum; i++) {
                // 统计这个礼包中所有物品的数量
                totalCount += specialBag.get(i);
                // 统计使用单价购买礼包中物品的总价格
                totalPrice += specialBag.get(i) * price.get(i);
                // 如果礼包中物品的数量大于实际所需的数量，那就不能买这个礼包
                if (specialBag.get(i) > needs.get(i)) {
                    totalCount = 0;
                    break;
                }
            }

            // 如果这个礼包的通过各个物品单价购买的总价格大于礼包自身优惠的价格，说明这个礼包是值得购买的
            if (totalCount > 0 && totalPrice > specialBag.get(productTypeNum)) {
                filterSpecialList.add(specialBag);
            }
        }

        return dfs(price, needs, filterSpecialList, productTypeNum);
    }

    /**
     * 记忆化搜索计算满足购物清单所需花费的最低价格
     */
    public int dfs(List<Integer> price, List<Integer> currentNeeds, List<List<Integer>> filterSpecialList, int productTypeNum) {
        if (!memo.containsKey(currentNeeds)) {
            int minPrice = 0;
            // 计算原价购买当前购物清单中所有商品的价格
            for (int i = 0; i < productTypeNum; ++i) {
                minPrice += currentNeeds.get(i) * price.get(i);
            }

            // 遍历实惠的大礼包
            for (List<Integer> specialBag : filterSpecialList) {
                // 下一次需要购买的物品数量
                List<Integer> nextNeeds = new ArrayList<>();
                for (int i = 0; i < productTypeNum; i++) {
                    // 下一次需要购买的物品数量
                    int nextNeed = currentNeeds.get(i) - specialBag.get(i);
                    // 如果下一次需要购买当前物品的小于 0，说明这个礼包量有点大，不能买
                    if (nextNeed < 0) {
                        break;
                    }
                    // 否则就购买当前大礼包
                    nextNeeds.add(nextNeed);
                }

                // 如果把当前大礼包的所有物品都买了，则继续往下进行搜索购买下一个大礼包并取最低价格
                if (nextNeeds.size() == productTypeNum) {
                    minPrice = Math.min(minPrice, dfs(price, nextNeeds, filterSpecialList, productTypeNum) + specialBag.get(productTypeNum));
                }
            }
            // 存入购买当前礼包的最小价格
            memo.put(currentNeeds, minPrice);
        }
        return memo.get(currentNeeds);
    }
}
