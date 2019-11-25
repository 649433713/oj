package yinywf.oj.test1;

/**
 * @author yinywf
 * Created on 2019-11-25
 * 最小交换次数
 * Description
 * Given an array of N distinct elementsA[ ], find the minimum number of swaps required to sort the array.Your are required to complete the function which returns an integer denoting the minimum number of swaps, required to sort the array.
 *
 *
 * Input
 * The first line of input contains an integer T denoting the no of test cases . Then T test cases follow . Each test case contains an integer N denoting the no of element of the array A[ ]. In the next line are N space separated values of the array A[ ] .(1<=T<=100;1<=N<=100;1<=A[] <=1000)
 *
 *
 * Output
 * For each test case in a new line output will be an integer denoting minimum umber of swaps that are required to sort the array.
 *
 *
 * Sample Input 1
 * 2
 * 4
 * 4 3 2 1
 * 5
 * 1 5 4 3 2
 * Sample Output 1
 * 2
 * 2
 */
import java.util.*;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            int[] temp = Arrays.copyOf(a, a.length);
            Arrays.sort(temp);

            int count = 0;
            for (int j = 0; j < temp.length; j++) {
                int h = index(a, temp[j]);
                if (h != j) {
                    int v = a[j];
                    a[j] = temp[j];
                    a[h] = v;
                    count++;
                }
            }
            System.out.println(count);
        }

    }
    private static int index(int[] a, int i) {
        for (int index = 0; index < a.length; index++) {
            if (a[index] == i) {
                return index;
            }
        }
        return -1;
    }
}
