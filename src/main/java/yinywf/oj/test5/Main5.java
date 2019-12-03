package yinywf.oj.test5;

import java.util.Scanner;

/**
 * @author yinywf
 * Created on 2019-11-28
 * 路上的球
 * Description
 *
 * There are two parallel roads, each containing N and M buckets, respectively. Each bucket may contain some balls. The buckets on both roads are kept in such a way that they are sorted according to the number of balls in them. Geek starts from the end of the road which has the bucket with a lower number of balls(i.e. if buckets are sorted in increasing order, then geek will start from the left side of the road). The geek can change the road only at the point of intersection(which means, buckets with the same number of balls on two roads). Now you need to help Geek to collect the maximum number of balls.
 *
 *
 * Input
 *
 * The first line of input contains T denoting the number of test cases. The first line of each test case contains two integers N and M, denoting the number of buckets on road1 and road2 respectively. 2nd line of each test case contains N integers, number of balls in buckets on the first road. 3rd line of each test case contains M integers, number of balls in buckets on the second road.
 *
 * Constraints:1<= T <= 1000，1<= N <= 10^3，1<= M <=10^3，0<= A[i],B[i]<=10^6
 *
 *
 * Output
 *
 * For each test case output a single line containing the maximum possible balls that Geek can collect.
 *
 *
 * Sample Input 1
 *
 * 1
 * 5 5
 * 1 4 5 6 8
 * 2 3 4 6 9
 * Sample Output 1
 *
 * 29
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int t = 0; t < times; t++) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[] ms = new int[m];
            int[] ns = new int[n];
            for (int i = 0; i < m; i++) {
                ms[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                ns[i] = scanner.nextInt();
            }
            if (ms[0] > ns[0]) {
                int[] tmp = ms;
                ms = ns;
                ns = tmp;
            }
            int mi = 0;
            int ni = 0;
            System.out.println(deep(ms, ns, mi, ni));

        }
    }

    private static int deep(int[] ms, int[] ns, int mi, int ni) {
        int mSum = 0;
        int nSum = 0;
        while (mi < ms.length && ni < ns.length && ms[mi] != ns[ni]) {
            if (ms[mi] > ns[ni]) {
                nSum += ns[ni];
                ni++;
            } else {
                mSum += ms[mi];
                mi++;
            }
        }
        if (!(mi < ms.length && ni < ns.length)) {
            if (mi == ms.length) {
                while (ni < ns.length) {
                    nSum += ns[ni];
                    ni++;
                }
            }
            if (ni == ns.length) {
                while (mi < ms.length) {
                    mSum += ms[mi];
                    mi++;
                }
            }
            return Math.max(mSum, nSum);
        } else {

            return Math.max(mSum, nSum) + ms[mi] + deep(ms, ns, mi + 1, ni + 1);
        }
    }
}
