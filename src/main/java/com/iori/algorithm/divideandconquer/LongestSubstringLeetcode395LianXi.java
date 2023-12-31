package com.iori.algorithm.divideandconquer;

import java.util.Arrays;

/**
 * <h3>至少k个字符的最长子串</h3>
 */
public class LongestSubstringLeetcode395LianXi {


    public static void main(String[] args) {
        //                                         i j
        System.out.println(longestSubstring("ababb", 2)); // ababb
        //System.out.println(longestSubstring("dddxaabaaabaacciiiiefbff", 3));
        //System.out.println(longestSubstring("ababbc", 3)); // ababb
        //System.out.println(longestSubstring("ababbc", 2)); // ababb
        //System.out.println(longestSubstring("aaabb", 3)); // ababb
        /*
            ddd aabaaabaa iiii fbff
                aa aaa aa      f1 ff

            统计字符串中每个字符的出现次数，移除哪些出现次数 < k 的字符
            剩余的子串，递归做此处理，直至
                 - 整个子串长度 < k (排除)
                 - 子串中没有出现次数 < k 的字符
         */
    }


    //视频解法  递归
    public static int longestSubstring1(String s, int k) {
        // s.length() < k
        //字串落选情况
        if (s.length() < k) {
            return 0;
        }

        int[] counts = new int[26]; // 索引对应字符  值用来存储该字符出现几次
        char[] chars = s.toCharArray();
        for (char c : chars) {
            counts[c - 'a']++;
        }

        //System.out.println(Arrays.toString(counts));

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int count = counts[c - 'a'];  //字符出现次数
            if (count > 0 && count < k) {
                int j = i + 1;
                while (j < s.length() && counts[chars[j] - 'a'] < k) {
                    j++;
                }
                //System.out.println(s.substring(0, i) + "\t" + s.substring(j));
                return Integer.max(longestSubstring1(s.substring(0, i), k),
                        longestSubstring1(s.substring(j), k));


            }
        }
        //入选了
        return s.length();

    }


    //抄的题解 已经理解了
    public static int longestSubstring(String s, int k) {

        return 0;
    }


}
