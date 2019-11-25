package yinywf.oj.practice2;

import java.util.Scanner;

/**
 * @author yinywf
 * Created on 2019-09-26
 * <p>
 * Description
 * <p>
 * 给定数组arr和整数num，求arr的连续子数组中满足：其最大值减去最小值的结果大于num的个数。请实现一个时间复杂度为O(length(arr))的算法。
 * <p>
 * <p>
 * Input
 * <p>
 * 输入第一行为测试用例个数。每一个用例有若干行，第一行为数组，每一个数用空格隔开，第二行为num。
 * <p>
 * <p>
 * Output
 * <p>
 * 输出一个值。
 * <p>
 * <p>
 * Sample Input 1
 * <p>
 * 1
 * 3 6 4 3 2
 * 2
 * Sample Output 1
 * <p>
 * 6
 */
class Main1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int i = 0; i < times; i++) {
            scanner.nextLine();
            String s = scanner.nextLine();
            String[] ss = s.split(" ");
            int n = scanner.nextInt();
            int[] is = new int[ss.length];
            for (int j = 0; j < ss.length; j++) {
                is[j] = Integer.parseInt(ss[j]);
            }

            int count = 0;
            for (int index = 0; index < is.length; index++) {
                int min = is[index];
                int max = is[index];
                for (int index2 = index + 1; index2 < is.length; index2++) {
                    if (is[index2] < min) {
                        min = is[index2];
                    } else if (is[index2] > max) {
                        max = is[index2];
                    }
                    if (max - min > n) {
                        count += is.length - index2;
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
