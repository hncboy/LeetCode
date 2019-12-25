package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2019/12/25 16:40
 * @description 1169.查询无效交易
 * 
 * 如果出现下述两种情况，交易 可能无效：
 * 交易金额超过 ￥1000
 * 或者，它和另一个城市中同名的另一笔交易相隔不超过 60 分钟（包含 60 分钟整）
 * 每个交易字符串transactions[i]由一些用逗号分隔的值组成，这些值分别表示交易的名称，时间（以分钟计），金额以及城市。
 * 给你一份交易清单transactions，返回可能无效的交易列表。你可以按任何顺序返回答案。
 *
 * 示例 1：
 * 输入：transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
 * 输出：["alice,20,800,mtv","alice,50,100,beijing"]
 * 解释：第一笔交易是无效的，因为第二笔交易和它间隔不超过 60 分钟、名称相同且发生在不同的城市。同样，第二笔交易也是无效的。
 * 
 * 示例 2：
 * 输入：transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
 * 输出：["alice,50,1200,mtv"]
 * 
 * 示例 3：
 * 输入：transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
 * 输出：["bob,50,1200,mtv"]
 *
 * 提示：
 * transactions.length <= 1000
 * 每笔交易transactions[i]按"{name},{time},{amount},{city}"的格式进行记录
 * 每个交易名称{name}和城市{city}都由小写英文字母组成，长度在1到10之间
 * 每个交易时间{time}由一些数字组成，表示一个0到1000之间的整数
 * 每笔交易金额{amount}由一些数字组成，表示一个0 到2000之间的整数
 */
public class InvalidTransactions {

    public static void main(String[] args) {
        InvalidTransactions i = new InvalidTransactions();
        String[] transactions1 = {"alice,20,800,mtv", "alice,50,100,beijing"};
        String[] transactions2 = {"alice,20,800,mtv", "alice,50,1200,mtv"};
        String[] transactions3 = {"alice,20,800,mtv", "bob,50,1200,mtv"};
        System.out.println(i.invalidTransactions2(transactions1));
        System.out.println(i.invalidTransactions2(transactions2));
        System.out.println(i.invalidTransactions2(transactions3));
    }

    private List<String> invalidTransactions2(String[] transactions) {
        int n = transactions.length;

        Transaction[] ts = new Transaction[n];
        for (int i = 0; i < n; i++) {
            ts[i] = new Transaction(transactions[i]);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Transaction t = ts[i];
            if (t.amount > 1000) {
                result.add(t.transaction);
                continue;
            }

            for (int j = 0; j < n; j++) {
                Transaction tt = ts[j];
                if (t.name.equals(tt.name) && !t.city.equals(tt.city) && Math.abs(t.time - tt.time) <= 60) {
                    result.add(t.transaction);
                    break;
                }
            }
        }

        return result;
    }

    private static class Transaction {
        String name;
        String city;
        int time;
        int amount;
        String transaction;

        Transaction(String transaction) {
            this.transaction = transaction;
            String[] split = transaction.split(",");
            name = split[0];
            time = Integer.parseInt(split[1]);
            amount = Integer.parseInt(split[2]);
            city = split[3];
        }
    }

    private List<String> invalidTransactions1(String[] transactions) {
        List<String[]> transactionList = new ArrayList<>();
        for (String transaction : transactions) {
            transactionList.add(transaction.split(","));
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < transactions.length; i++) {
            String[] transaction = transactionList.get(i);
            String name = transaction[0];
            int time = Integer.parseInt(transaction[1]);
            String city = transaction[3];

            // 如果交易金额超过 ￥1000，则该笔交易无效
            if (Integer.parseInt(transaction[2]) > 1000 && !result.contains(transactions[i])) {
                result.add(transactions[i]);
            }

            for (int j = i + 1; j < transactions.length; j++) {
                String[] otherTransaction = transactionList.get(j);
                // 如果城市不相同，两笔交易同名且相隔不超过 60 分钟，则两笔交易都无效
                if (name.equals(otherTransaction[0]) && Math.abs(time - Integer.parseInt(otherTransaction[1])) <= 60
                        && !city.equals(otherTransaction[3])) {
                    if (!result.contains(transactions[j])) {
                        result.add(transactions[j]);
                    }
                    if (!result.contains(transactions[i])) {
                        result.add(transactions[i]);
                    }
                }
            }
        }

        return result;
    }
}
