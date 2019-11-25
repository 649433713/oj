package yinywf.oj.test3;

/**
 * @author yinywf
 * Created on 2019-11-25
 *
 * 素数和问题
 * Description
 * Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number. There are several combinations possible. Print only first such pair.
 *
 * NOTE: A solution will always exist, read Goldbach’s conjecture.Also, solve the problem in linear time complexity, i.e., O(n).
 *
 *
 * Input
 * The first line contains T, the number of test cases. The following T lines consist of a number each, for which we'll find two prime numbers.Note: The number would always be an even number.
 *
 *
 * Output
 * For every test case print two prime numbers space separated, such that the smaller number appears first. Answer for each test case must be in a new line.
 *
 *
 * Sample Input 1
 * 5
 * 74
 * 1024
 * 66
 * 8
 * 9990
 * Sample Output 1
 * 3 71
 * 3 1021
 * 5 61
 * 3 5
 * 17 9973
 */


import java.util.*;

/**
 * @author yinywf
 * Created on 2019-10-17
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int j = 0; j < times; j++) {
            int even = scanner.nextInt();
            for (int i = 2; i <= even / 2; i++) {
                if (prime(i) && prime(even - i)) {
                    System.out.println(i + " " + (even - i));
                    break;
                }
            }
        }
    }


    //	判断数字是否为质数方法
    private static boolean prime(int n) {
        boolean flag = true;
        if (n != 2 && n != 3) {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
