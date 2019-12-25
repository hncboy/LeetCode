package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2019/12/25 16:40
 * @description 1169.��ѯ��Ч����
 * 
 * ������������������������ ������Ч��
 * ���׽��� ��1000
 * ���ߣ�������һ��������ͬ������һ�ʽ������������ 60 ���ӣ����� 60 ��������
 * ÿ�������ַ���transactions[i]��һЩ�ö��ŷָ���ֵ��ɣ���Щֵ�ֱ��ʾ���׵����ƣ�ʱ�䣨�Է��Ӽƣ�������Լ����С�
 * ����һ�ݽ����嵥transactions�����ؿ�����Ч�Ľ����б�����԰��κ�˳�򷵻ش𰸡�
 *
 * ʾ�� 1��
 * ���룺transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
 * �����["alice,20,800,mtv","alice,50,100,beijing"]
 * ���ͣ���һ�ʽ�������Ч�ģ���Ϊ�ڶ��ʽ��׺������������ 60 ���ӡ�������ͬ�ҷ����ڲ�ͬ�ĳ��С�ͬ�����ڶ��ʽ���Ҳ����Ч�ġ�
 * 
 * ʾ�� 2��
 * ���룺transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
 * �����["alice,50,1200,mtv"]
 * 
 * ʾ�� 3��
 * ���룺transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
 * �����["bob,50,1200,mtv"]
 *
 * ��ʾ��
 * transactions.length <= 1000
 * ÿ�ʽ���transactions[i]��"{name},{time},{amount},{city}"�ĸ�ʽ���м�¼
 * ÿ����������{name}�ͳ���{city}����СдӢ����ĸ��ɣ�������1��10֮��
 * ÿ������ʱ��{time}��һЩ������ɣ���ʾһ��0��1000֮�������
 * ÿ�ʽ��׽��{amount}��һЩ������ɣ���ʾһ��0 ��2000֮�������
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

            // ������׽��� ��1000����ñʽ�����Ч
            if (Integer.parseInt(transaction[2]) > 1000 && !result.contains(transactions[i])) {
                result.add(transactions[i]);
            }

            for (int j = i + 1; j < transactions.length; j++) {
                String[] otherTransaction = transactionList.get(j);
                // ������в���ͬ�����ʽ���ͬ������������� 60 ���ӣ������ʽ��׶���Ч
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
