package yinywf.oj.practice2; /**
 * Description
 * <p>
 * 有两个序列 a,b，大小都为 n,序列元素的值任意整数，无序； 要求：通过交换 a,b 中的元素，使[序列 a 元素的和]与[序列 b 元素的和]之间的差最小。
 * <p>
 * <p>
 * Input
 * <p>
 * 输入第一行为用例个数， 每个测试用例输入为两行，分别为两个数组，每个值用空格隔开。
 * <p>
 * <p>
 * Output
 * <p>
 * 输出变化之后的两个数组内元素和的差绝对值。
 * <p>
 * <p>
 * Sample Input 1
 * <p>
 * 1
 * 100 99 98 1 2 3
 * 1 2 3 4 5 40
 * Sample Output 1
 * <p>
 * 48
 */

import java.util.*;

class Main8 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int times = scanner.nextInt();

        scanner.nextLine();

        for (int i = 0; i < times; i++) {


            String s = scanner.nextLine();

            String[] ss = s.split(" ");

            int[] is = new int[ss.length * 2];

            for (int j = 0; j < ss.length; j++) {

                is[j] = Integer.parseInt(ss[j]);

            }

            s = scanner.nextLine();

            ss = s.split(" ");

            for (int j = ss.length; j < ss.length * 2; j++) {

                is[j] = Integer.parseInt(ss[j - ss.length]);

            }

            int sum = 0;

            for (int j : is) {

                sum += j;

            }

            double half = sum / 2.0;
            System.out.println(new Double(cap(half, is, 0, is.length / 2) * 2).intValue());
        }
    }


    private static Double cap(double sum, int[] is, int index, int count) {

        if (count == 0) {

            return sum;

        }

        if (index == is.length) {

            return Double.MAX_VALUE;

        }

        if (is[index] > sum) {

            return cap(sum, is, index + 1, count);

        } else {

            return Math.min(cap(sum - is[index], is, index + 1, count - 1), cap(sum, is, index + 1, count));

        }

    }
}
