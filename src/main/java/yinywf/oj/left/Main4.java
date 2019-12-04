package yinywf.oj.left;

import java.util.Scanner;

/**
 * @author yinywf
 * Created on 2019-12-04
 * 漆狗屋
 * Description
 * Dilpreet wants to paint his dog- Buzo's home that has n boards with different lengths[A1, A2,..., An]. He hired k painters for this work and each painter takes 1 unit time to paint 1 unit of the board.The problem is to find the minimum time to get this job done under the constraints that any painter will only paint continuous sections of boards, say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.
 *
 * Constraints:1<=T<=100,1<=k<=30,1<=n<=50,1<=A[i]<=500
 *
 *
 * Input
 * The first line consists of a single integer T, the number of test cases. For each test case, the first line contains an integer k denoting the number of painters and integer n denoting the number of boards. Next line contains n- space separated integers denoting the size of boards.
 *
 *
 * Output
 * For each test case, the output is an integer displaying the minimum time for painting that house.
 *
 *
 * Sample Input 1
 * 2
 * 2 4
 * 10 10 10 10
 * 2 4
 * 10 20 30 40
 * Sample Output 1
 * 20
 * 60
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long times = scanner.nextLong();
        for (int i = 0; i < times; i++) {
            int head = scanner.nextInt();
            int bookNum = scanner.nextInt();
            int[] books = new int[bookNum];
            for (int j = 0; j < bookNum; j++) {
                books[j] = scanner.nextInt();
            }
            int[][] dp = new int[head + 1][bookNum + 1];
            for (int j = 0; j < bookNum + 1; j++) {
                dp[1][j] = sum(books, 0, j);
            }
            for (int j = 0; j < head + 1; j++) {
                dp[j][1] = books[0];
            }
            for (int j = 2; j < head + 1; j++) {
                for (int k = 2; k < bookNum + 1; k++) {
                    int best = Integer.MAX_VALUE;
                    for (int l = 1; l < k; l++) {
                        best = Math.min(best, Math.max(dp[j - 1][l], sum(books, l, k)));
                    }
                    dp[j][k] = best;
                }
            }
            System.out.println(dp[head][bookNum]);
        }
    }
    private static int sum(int[] is, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += is[i];
        }
        return sum;
    }
}
