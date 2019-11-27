package yinywf.oj.test2;

/**
 * @author yinywf
 * Created on 2019-11-25
 *
 * 书本分发
 * Description
 * You are given N number of books. Every ith book has Pi number of pages. You have to allocate books to M number of students. There can be many ways or permutations to do so. In each permutation one of the M students will be allocated the maximum number of pages. Out of all these permutations, the task is to find that particular permutation in which the maximum number of pages allocated to a student is minimum of those in all the other permutations, and print this minimum value. Each book will be allocated to exactly one student. Each student has to be allocated atleast one book.
 *
 *
 * Input
 * The first line contains 'T' denoting the number of testcases. Then follows description of T testcases:Each case begins with a single positive integer N denoting the number of books.The second line contains N space separated positive integers denoting the pages of each book.And the third line contains another integer M, denoting the number of studentsConstraints:1<= T <=70，1<= N <=50，1<= A [ i ] <=250，1<= M <=50，Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see explanation for better understanding)
 *
 *
 * Output
 * For each test case, output a single line containing minimum number of pages each student has to read for corresponding test case.
 *
 *
 * Sample Input 1
 * 1
 * 4
 * 12 34 67 90
 * 2
 * Sample Output 1
 * 113

漆狗屋

又名:数组分段和最大值最小问题 ,画匠问题,()书本分发看最后面)

题目描述

Description

Dilpreet wants to paint his dog- Buzo’s home that has n boards with different lengths[A1, A2,…, An]. He hired k painters for this work and each painter takes 1 unit time to paint 1 unit of the board.The problem is to find the minimum time to get this job done under the constraints that any painter will only paint continuous sections of boards, say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.

Constraints:1<=T<=100,1<=k<=30,1<=n<=50,1<=A[i]<=500

Input

The first line consists of a single integer T, the number of test cases. For each test case, the first line contains an integer k denoting the number of painters and integer n denoting the number of boards. Next line contains n- space separated integers denoting the size of boards.

Output

For each test case, the output is an integer displaying the minimum time for painting that house.

Sample Input 1

2
2 4
10 10 10 10
2 4
10 20 30 40
1
2
3
4
5
Sample Output 1

20
60
1
2
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long times = scanner.nextLong();
        for (int i = 0; i < times; i++) {
            int bookNum = scanner.nextInt();
            int[] books = new int[bookNum];
            for (int j = 0; j < bookNum; j++) {
                books[j] = scanner.nextInt();
            }
            int head = scanner.nextInt();
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
