package com.iori.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <h3>分数背包问题 - 贪心解法</h3>
 */
public class FractionalKnapsackProblemLianXi {

      /*
        1. n个物品都是液体，有重量和价值
        2. 现在你要取走 10升 的液体
        3. 每次可以不拿，全拿，或拿一部分，问最高价值是多少

            编号 重量(升) 价值
            0   4       24      水
            1   8       160     牛奶       选中 7/8
            2   2       4000    五粮液     选中
            3   6       108     可乐
            4   1       4000    茅台       选中

            8140

        简化起见，给出的数据都是【价值/重量】能够整除，避免计算结果中出现小数，增加心算难度
     */

    static class Item {
        int index;
        int weight;
        int value;

        public Item(int index, int weight, int value) {
            this.index = index;
            this.weight = weight;
            this.value = value;
        }

        public int unitValue() {
            return value / weight;
        }

        @Override
        public String toString() {
            return "Item(" + index + ")";
        }
    }

    public static void main(String[] args) {
        Item[] items = new Item[]{
                new Item(0, 4, 24),
                new Item(1, 8, 160),
                new Item(2, 2, 4000),
                new Item(3, 6, 108),
                new Item(4, 1, 4000),
        };
        select(items, 10);
    }

    private static void select(Item[] items, int total) {

    }


}
