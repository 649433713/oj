package yinywf.oj.left;

import java.util.Scanner;

/**
 * @author yinywf
 * Created on 2019-12-04
 * 倒置个数
 * Description
 * 有一个由N个实数构成的数组，如果一对元素A[i]和A[j]是倒序的，即i<j但是A[i]>A[j]则称它们是一个倒置，设计一个计算该数组中所有倒置数量的算法。要求算法复杂度为O(nlogn)
 *
 *
 * Input
 * 输入有多行，第一行整数T表示为测试用例个数，后面是T个测试用例，每一个用例包括两行，第一行的一个整数是元素个数，第二行为用空格隔开的数组值。
 *
 *
 * Output
 * 输出每一个用例的倒置个数，一行表示一个用例。
 *
 *
 * Sample Input 1
 * 1
 * 8
 * 8 3 2 9 7 1 5 4
 * Sample Output 1
 * 17
 */
public class Main13 {
    private static int[] aux;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            System.out.println(sort(nums));
        }
    }

    public static int sort(int[] a) {
        aux = new int[a.length];
        return sort(a, 0, a.length - 1);
    }

    private static int sort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return 0;
        }
        int mid = lo + (hi - lo) / 2;
        int count = 0;
        count += sort(a, lo, mid);
        count += sort(a, mid + 1, hi);
        return count + merge(a, lo, mid, hi);
    }

    private static int merge(int[] a, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int count = 0;

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                count += mid - i + 1;
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
        return count;
    }
}
