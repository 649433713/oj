/**
 * Description
 * <p>
 * 找到给定数组的给定区间内的第K小的数值。
 * <p>
 * <p>
 * Input
 * <p>
 * 输入第一行为用例个数， 每个测试用例输入的第一行为数组，每一个数用空格隔开；第二行是区间（第几个数到第几个数，两头均包含），两个值用空格隔开；第三行为K值。
 * <p>
 * <p>
 * Output
 * <p>
 * 结果。
 * <p>
 * <p>
 * Sample Input 1
 * <p>
 * 1
 * 1 2 3 4 5 6 7
 * 3 5
 * 2
 * Sample Output 1
 * <p>
 * 4
 */
package yinywf.oj.practice2;

/**
 * @author yinywf
 * Created on 2019/10/16
 */

import java.util.*;

class Main5 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int times = scanner.nextInt();


        for (int i = 0; i < times; i++) {

            scanner.nextLine();

            String s = scanner.nextLine();

            String[] ss = s.split(" ");

            int[] is = new int[ss.length];

            for (int j = 0; j < ss.length; j++) {

                is[j] = Integer.parseInt(ss[j]);

            }

            int start = scanner.nextInt();

            int end = scanner.nextInt();

            int K = scanner.nextInt();

            is = Arrays.copyOfRange(is, start - 1, end);

            noK(is, 0, is.length - 1, K);

            System.out.println(is[K - 1]);

        }

    }


    private static void noK(int[] a, int start, int end, int K) {

        if (start != end) {

            int num = 0;

            if (start < end)

                num = checkKthNumber(a, start, end);

            if (num == K - 1) return;

            if (num > K - 1) {

                noK(a, start, num - 1, K);

            } else {

                noK(a, num + 1, end, K);

            }

        }

    }


    private static int checkKthNumber(int[] a, int start, int end) {

        int l = start;

        int r = end;

        int key = a[start];

        while (l < r) {

            while (l < r && a[r] >= key) r--;

            a[l] = a[r];

            while (l < r && a[l] < key) l++;

            a[r] = a[l];

        }

        a[l] = key;

        return l;

    }
}

