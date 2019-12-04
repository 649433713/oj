package yinywf.oj.left;

import java.util.Scanner;

/**
 * @author yinywf
 * Created on 2019-12-04
 *
 * 数组查询
 * Description
 * Given an array, the task is to complete the function which finds the maximum sum subarray, where you may remove at most one element to get the maximum sum.
 *
 *
 * Input
 * 第一行为测试用例个数T；后面每两行表示一个用例，第一行为用例中数组长度N，第二行为数组具体内容。
 *
 *
 * Output
 * 每一行表示对应用例的结果。
 *
 *
 * Sample Input 1
 * 1
 * 5
 * 1 2 3 -4 5
 * Sample Output 1
 * 11
 * Hint
 * 例如，对一个数组A[] = {1, 2, 3, -4, 5}，要移除-4得到最大和的子数组，和为11.
 */
public class Main9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        for(int i=0;i<total;i++){
            int length = scanner.nextInt();
            int numArr[]=new int[length];
            for(int j=0;j<length;j++){
                numArr[j]=scanner.nextInt();
            }
            System.out.println(maximumSum(numArr));
        }
    }
    public static int maximumSum(int[] arr) {
        int ans = arr[0];
        int len = arr.length;
        int[][] dp = new int[len][2];
        // 初始化状态
        // "尚未删除"，最大子数组和为本身
        dp[0][0] = arr[0];
        // "已经删除"，只能删除自身，最大子数组和为 0
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            // 如果前一个子数组和大于 0，则加上
            dp[i][0] = Math.max(arr[i], arr[i] + dp[i - 1][0]);
            // 删除的字符的两种情况：
            // 1. 当前数字被删除，为了满足至少一个元素，必须加上前面一个子数组 "尚未删除" 的最大值
            // 2. 当前数字不被删除，则由前面子数组删除，前面子数组 "已经删除" 的最大值加上当前数字
            dp[i][1] = Math.max(dp[i - 1][1] + arr[i], dp[i - 1][0]);
            // 两种状态都可能产生最大值
            ans = Math.max(ans, dp[i][0]);
            ans = Math.max(ans, dp[i][1]);
        }
        return ans;
    }
}
