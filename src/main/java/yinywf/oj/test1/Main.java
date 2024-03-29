package yinywf.oj.test1;

import java.util.Scanner;

/**
 * @author yinywf
 * Created on 2019-11-25
 *
 * 序号乘方
 * Description
 * There are Infinite People Standing in a row, indexed from 1.A person having index 'i' has strength of (i*i).You have Strength 'P'. You need to tell what is the maximum number of People You can Kill With your Strength P.You can only Kill a person with strength 'X' if P >= 'X' and after killing him, Your Strength decreases by 'X'.
 *
 *
 * Input
 * First line contains an integer 'T' - the number of testcases,Each of the next 'T' lines contains an integer 'P'- Your Power.Constraints:1<=T<=100001<=P<=1000000000000000
 *
 *
 * Output
 * For each testcase Output The maximum Number of People You can kill.
 *
 *
 * Sample Input 1
 * 1
 * 14
 * Sample Output 1
 * 3
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long times = scanner.nextLong();
        for (int i = 0; i < times; i++) {
            long num = scanner.nextLong();
            long count = 1;
            long temp = 0;
            while (temp <= num) {
                temp = count * (count + 1) * (count * 2 + 1) / 6;
                count++;
            }
            System.out.println(count - 2);
        }
    }
}
