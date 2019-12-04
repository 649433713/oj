package yinywf.oj.left;

import java.util.Scanner;

/**
 * @author yinywf
 * Created on 2019-12-04
 *
 * 有9个因数的数
 * Description
 * Find the count of numbers less than N having exactly 9 divisors
 *
 * 1<=T<=1000,1<=N<=10^12
 *
 *
 * Input
 * First Line of Input contains the number of testcases. Only Line of each testcase contains the number of members N in the rival gang.
 *
 *
 * Output
 * Print the desired output.
 *
 *
 * Sample Input 1
 * 2
 * 40
 * 5
 * Sample Output 1
 * 1
 * 0
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0;i<n;i++){
            long num = scanner.nextLong();
            System.out.println(countNum(num));
        }


    }
    public static int countNum(long n) {
        int c = 0;
        int maxInt = (int) Math.sqrt(n);
        int arrInt[] = new int[maxInt + 1];
        for (int i = 1; i <= maxInt; i++) {
            arrInt[i] = i;
        }

        for (int i = 2; i * i <= maxInt; i++) {
            if (arrInt[i] == i) {

                for (int j = i * i; j <= maxInt; j += i) {
                    if (arrInt[j] == j) {
                        arrInt[j] = i;
                    }
                }
            }
        }
        for (int i = 2; i <= maxInt; i++) {
            int p = arrInt[i];
            int q = arrInt[i / arrInt[i]];
            if (p * q == i && q != 1 && p != q) {
                c += 1;
            } else if (arrInt[i] == i) {
                if (Math.pow(i, 8) <= n) {
                    c += 1;
                }
            }
        }

        return c;
    }
}
