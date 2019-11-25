package yinywf.oj.practice2;

import java.util.Scanner;
import java.util.Stack;

/**
 * Description
 * <p>
 * 给定一个矩形区域，每一个位置上都是1或0，求该矩阵中每一个位置上都是1的最大子矩形区域中的1的个数。
 * <p>
 * <p>
 * Input
 * <p>
 * 输入第一行为测试用例个数。每一个用例有若干行，第一行为矩阵行数n和列数m，下面的n行每一行是用空格隔开的0或1。
 * <p>
 * <p>
 * Output
 * <p>
 * 输出一个数值。
 * <p>
 * <p>
 * Sample Input 1
 * <p>
 * 1
 * 3 4
 * 1 0 1 1
 * 1 1 1 1
 * 1 1 1 0
 * Sample Output 1
 * <p>
 * 6
 */
class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int i = 0; i < times; i++) {
            int r = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] is = new int[r][n];
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < n; k++) {
                    is[j][k] = scanner.nextInt();
                }
            }
            System.out.println(maxRecSize(is));
        }

    }

    private static int maxRecSize(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return 0;
        }
        int res = 0;
        // 数组height保存 每一列1的个数
        int[] height = new int[arr[0].length];
        for (int i = 0; i < arr.length; i++) { // 每一行
            for (int j = 0; j < arr[0].length; j++) { // 每一列
                height[j] = arr[i][j] == 0 ? 0 : (height[j] + 1);
            }
            res = Math.max(res, process(height));
        }
        return res;

    }

    // 变成求构成条形图的最大面积
    private static int process(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int res = 0;
        //栈存下标
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) { // 小于等于栈顶
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k - 1) * arr[j];
                res = Math.max(res, curArea);
            }
            stack.push(i);         //大于的时候入栈
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();       //弹出栈顶
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (arr.length - k - 1) * arr[j];
            res = Math.max(res, curArea);
        }
        return res;
    }
}
