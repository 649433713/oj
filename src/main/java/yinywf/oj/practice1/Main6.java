package yinywf.oj.practice1;

/**
 * @author yinywf
 * Created on 2019-11-25
 * 计数排序
 * Description
 * 实现计数排序，通过多次遍历数组，统计比每一个元素小的其它元素个数，根据该统计量对数据进行排序。
 *
 *
 * Input
 * 输入的每一行表示一个元素为正整数的数组，所有值用空格隔开，第一个值为数值长度，其余为数组元素值。
 *
 *
 * Output
 * 输出的每一行为排序结果，用空格隔开，末尾不要空格。
 *
 *
 * Sample Input 1
 * 13 24 3 56 34 3 78 12 29 49 84 51 9 100
 * Sample Output 1
 * 3 3 9 12 24 29 34 49 51 56 78 84 100
 */
import java.util.Scanner;

public class Main6 {

    private static void print(int[] os) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : os) {
            stringBuilder.append(i).append(' ');
        }
        System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] is = new int[n];
            for (int j = 0; j < n; j++) {
                is[j] = scanner.nextInt();
            }
            countSort(is);
            print(is);

        }
    }

    private static void countSort(int[] is) {

        int[] result = new int[is.length];
        for (int item : is) {
            int count = 0;
            for (int value : is) {
                if (value < item) {
                    count++;
                }
            }
            result[count] = item;
        }

        for (int i = 0; i < result.length; i++) {
            is[i] = result[i] == 0 ? is[i - 1] : result[i];
        }
    }
}
