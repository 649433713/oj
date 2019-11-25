package yinywf.oj.test4;

import java.util.Scanner;

/**
 * @author yinywf
 * Created on 2019-11-21
 *
 * 最小化初始点
 * Description
 * Given a grid with each cell consisting of positive, negative or no points i.e, zero points. We can move across a cell only if we have positive points ( > 0 ). Whenever we pass through a cell, points in that cell are added to our overall points. We need to find minimum initial points to reach cell (m-1, n-1) from (0, 0) by following these certain set of rules :
 *
 * 1.From a cell (i, j) we can move to (i+1, j) or (i, j+1).
 *
 * 2.We cannot move from (i, j) if your overall points at (i, j) is <= 0.
 *
 * 3.We have to reach at (n-1, m-1) with minimum positive points i.e., > 0.
 *
 *
 * Input
 * The first line contains an integer 'T' denoting the total number of test cases.In each test cases, the first line contains two integer 'R' and 'C' denoting the number of rows and column of array.
 * The second line contains the value of the array i.e the grid, in a single line separated by spaces in row major order.
 *
 * Constraints:
 *
 * 1 ≤ T ≤ 30
 *
 * 1 ≤ R,C ≤ 10
 *
 * -30 ≤ A[R][C] ≤ 30
 *
 * Input: points[m][n] = { {-2, -3, 3},
 * {-5, -10, 1},
 * {10, 30, -5}
 * };
 *
 *
 * Output
 * Print the minimum initial points to reach the bottom right most cell in a separate line.
 *
 * 7
 *
 * Explanation:
 * 7 is the minimum value to reach destination with
 * positive throughout the path. Below is the path.
 *
 * (0,0) -> (0,1) -> (0,2) -> (1, 2) -> (2, 2)
 *
 * We start from (0, 0) with 7, we reach(0, 1)
 * with 5, (0, 2) with 2, (1, 2) with 5, (2, 2)with and finally we have 1 point (we needed
 * greater than 0 points at the end).
 *
 *
 * Sample Input 1
 * 1
 * 3 3
 * -2 -3 3 -5 -10 1 10 30 -5
 * Sample Output 1
 * 7
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int t = 0; t < times; t++) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] nums = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    nums[i][j] = scanner.nextInt();
                }
            }
            System.out.println(1 - deep(0, 0, nums, m - 1, n - 1, 0));

        }
    }

    private static int deep(int m1, int n1, int[][] nums, int m, int n, int min) {
        if (m1 == m && n1 == n) {
            return min + nums[m][n];
        } else if (m1 == m) {
            int temp = deep(m1, n1 + 1, nums, m, n, min);
            return Math.min(nums[m1][n1] + temp, min);
        } else if (n1 == n) {
            int temp = deep(m1 + 1, n1, nums, m, n, min);
            return Math.min(nums[m1][n1] + temp, min);
        } else {
            return nums[m1][n1] + Math.max(deep(m1 + 1, n1, nums, m, n, min), deep(m1, n1 + 1, nums, m, n, min));
        }
    }

}
