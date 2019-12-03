package yinywf.oj.test5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yinywf
 * Created on 2019/11/28
 * 时间分隔
 * Description
 *
 * Given arrival and departure times of all trains that reach a railway station. Your task is to find the minimum number of platforms required for the railway station so that no train waits.
 *
 * Note: Consider that all the trains arrive on the same day and leave on the same day. Also, arrival and departure times must not be same for a train.
 *
 *
 * Input
 *
 * The first line of input contains T, the number of test cases. For each test case, first line will contain an integer N, the number of trains. Next two lines will consist of N space separated time intervals denoting arrival and departure times respectively.
 *
 * Note: Time intervals are in the 24-hourformat(hhmm), preceding zeros are insignificant. 200 means 2:00.
 * Consider the example for better understanding of input.
 *
 * Constraints:1 <= T <= 100，1 <= N <= 1000，1 <= A[i] < D[i] <= 2359
 *
 *
 * Output
 *
 * For each test case, print the minimum number of platforms required for the trains to arrive and depart safely.
 *
 *
 * Sample Input 1
 *
 * 1
 * 6
 * 900  940 950  1100 1500 1800
 * 910 1200 1120 1130 1900 2000
 * Sample Output 1
 *
 * 3
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int t = 0; t < times; t++) {
            int n = scanner.nextInt();
            List<Integer> arrive = new ArrayList<>();
            List<Integer> leave = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arrive.add(scanner.nextInt());
            }
            for (int i = 0; i < n; i++) {
                leave.add(scanner.nextInt());
            }
            leave.sort(Integer::compareTo);
            int count = 0;
            int max = 0;
            int i1 = 0;
            int i2 = 0;
            while (i1 != n) {
                if (arrive.get(i1) < leave.get(i2)) {
                    count++;
                    if (count > max) {
                        max = count;
                    }
                    i1++;
                } else {
                    count--;
                    i2++;
                }
            }
            System.out.println(max);
        }
    }
}
