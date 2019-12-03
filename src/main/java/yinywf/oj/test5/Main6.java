package yinywf.oj.test5;

import java.util.Scanner;

/**
 * @author yinywf
 * Created on 2019-11-28
 * 格子里的整数
 * Description
 *
 * Given a square grid of size n, each cell of which contains integer cost which represents a cost to traverse through that cell, we need to find a path from top left cell to bottom right cell by which total cost incurred is minimum.
 *
 * Note : It is assumed that negative cost cycles do not exist in input matrix.
 *
 *
 * Input
 *
 * The first line of input will contain number of test cases T. Then T test cases follow . Each test case contains 2 lines. The first line of each test case contains an integer n denoting the size of the grid. Next line of each test contains a single line containing N*N space separated integers depecting cost of respective cell from (0,0) to (n,n).
 *
 * Constraints:1<=T<=50，1<= n<= 50
 *
 *
 * Output
 *
 * For each test case output a single integer depecting the minimum cost to reach the destination.
 *
 *
 * Sample Input 1
 *
 * 2
 * 5
 * 31 100 65 12 18 10 13 47 157 6 100 113 174 11 33 88 124 41 20 140 99 32 111 41 20
 * 2
 * 42 93 7 14
 * Sample Output 1
 *
 * 327
 * 63
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int t = 0; t < times; t++) {
            int n = scanner.nextInt();
            int[][] price = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    price[i][j] = scanner.nextInt();
                }
            }
            System.out.println(deep(price, 0, 0));
            int[][] result = new int[n][n];
            result[n - 1][n - 1] = price[n - 1][n - 1];
            for (int i = n - 2; i >= 0; i--) {
                result[n - 1][i] = result[n - 1][i + 1] + price[n - 1][i];
            }
            for (int i = n - 2; i >= 0; i--) {
                result[i][n - 1] += result[i + 1][n - 1] + price[i][n - 1];
            }
            for (int i = n - 2; i >= 0; i--) {
                for (int j = n - 2; j >= 0; j--) {
                    result[i][j] = Math.min(result[i + 1][j], result[i][j + 1]) + price[i][j];
                }
            }

            //System.out.println(result[0][0]);

        }
    }

    private static int deep(int[][] price, int i, int j) {
        if (i == price.length - 1 && j < price.length - 1) {
            return price[i][j] + deep(price, i, j + 1);
        }
        if (j == price.length - 1 && i < price.length - 1) {
            return price[i][j] + deep(price, i + 1, j);
        }
        if (i == price.length - 1 && j == price.length - 1) {
            return price[i][j];
        }
        return price[i][j] + Math.min(deep(price, i, j + 1), deep(price, i + 1, j));
    }
}
