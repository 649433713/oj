package yinywf.oj.test4;

/**
 * @author yinywf
 * Created on 2019-11-25
 * 是否能通过考试
 * Description
 * 小张想要通过明天的考试。他知道考题的分值分布，也知道考试中要拿到每一个题目需要耗费的时间。假设考试时长为h，共n个题目，需要拿到p分才能通过考试。现在已知每个考题的得分与耗时，请你判断小张能否通过合理安排时间，而通过考试，并给出通过考试的最短时间。
 *
 *
 * Input
 * 输入第一行为测试用例个数.每一个用例有若干行，第一行为任务数量n、考试时常h、通过分数p，下面的n行是每一个题目的耗时和得分。所有数值用空格分开。
 *
 *
 * Output
 * 对每一个用例输出一行，如果能够通过考试，则输出“YES”和消耗最短时间，用空格隔开。 否则，输出“NO”。
 *
 *
 * Sample Input 1
 * 1
 * 5 40 21
 * 12 10
 * 16 10
 * 20 10
 * 24 10
 * 8 3
 * Sample Output 1
 * YES 36
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int t = 0; t < times; t++) {
            int num = scanner.nextInt();
            int mins = scanner.nextInt();
            int score = scanner.nextInt();
            int[] hours = new int[num];
            int[] scores = new int[num];
            for (int i = 0; i < num; i++) {
                hours[i] = scanner.nextInt();
                scores[i] = scanner.nextInt();
            }

            int h = fun(num, mins, score, hours, scores);
            if (h < 10000) {
                System.out.println("YES " + h);
            } else {
                System.out.println("NO");
            }
        }
    }

    private static int fun(int n, int h, int p, int[] hours, int[] scores) {
        if ((h < 0 || n < 0)) {
            return 100000;
        }
        if (p < 0) {
            return 0;
        }
        if (n == 0) {
            return 10000;
        }
        int left = fun(n - 1, h - hours[n - 1], p - scores[n - 1], hours, scores) + hours[n - 1];
        int right = fun(n - 1, h, p, hours, scores);
        return Math.min(left, right);
    }
}
