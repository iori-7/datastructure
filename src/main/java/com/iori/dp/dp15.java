package com.iori.dp;

public class dp15 {

    /*
        题目一
        给定5个参数，N, M. row, col, k
        表示在N*M的区域上，醉汉Bob初始在(row,col)位置
        Bob一共要迈出k步，且每步都会等概率向上下左右四个方向走一个单位
        任何时候Bob只要离开N*M的区域，就直接死亡
        返回k步之后，Bob还在N*M的区域的概率
     */
    public static void main(String[] args) {
        System.out.println(livePossibility1(3, 2, 10, 7, 8));
        System.out.println(livePossibility2(3, 2, 10, 7, 8));
    }


    //动态规划
    public static double livePossibility2(int row, int col, int k, int n, int m) {
        long[][][] dp = new long[n][m][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j][0] = 1;
            }
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c < n; c++) {
                    dp[j][c][i] = pick(dp, n, m, j - 1, c, i - 1);
                    dp[j][c][i] += pick(dp, n, m, j + 1, c, i - 1);
                    dp[j][c][i] += pick(dp, n, m, j, c - 1, i - 1);
                    dp[j][c][i] += pick(dp, n, m, j, c + 1, i - 1);

                }
            }
        }
        return (double) dp[row][col][k] / Math.pow(4, k);
    }

    private static long pick(long[][][] dp, int n, int m, int i, int c, int j) {
        if (i < 0 || i == n || c < 0 || c == m) {
            return 0;
        }
        return dp[j][c][i];
    }



    //暴力递归
    public static double livePossibility1(int row, int col, int k, int n, int m) {
        return (double) process(row, col, k, n, m) / Math.pow(4, k);
    }


    //从 row,col 目标点开始 走k步 在n * m的区域 的存货概率
    private static long process(int row, int col, int k, int n, int m) {
        if (row < 0 || row == n || col < 0 || col == m) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        long up = process(row - 1, col, k - 1, n, m);
        long down = process(row + 1, col, k - 1, n, m);
        long left = process(row, col - 1, k - 1, n, m);
        long right = process(row, col + 1, k - 1, n, m);

        return up + down + left + right;
    }


}
