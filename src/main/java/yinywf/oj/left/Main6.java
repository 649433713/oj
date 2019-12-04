package yinywf.oj.left;

import java.util.Scanner;

/**
 * @author yinywf
 * Created on 2019-12-04
 *
 * 数学公式
 * Description
 * Implement pow(A, B) % C.In other words, given A, B and C, find (A^B)%C
 *
 *
 * Input
 * The first line of input consists number of the test cases. The following T lines consist of 3 numbers each separated by a space and in the following order:A B C'A' being the base number, 'B' the exponent (power to the base number) and 'C' the modular.Constraints:1 ≤ T ≤ 70,1 ≤ A ≤ 10^5,1 ≤ B ≤ 10^5,1 ≤ C ≤ 10^5
 *
 *
 * Output
 * In each separate line print the modular exponent of the given numbers in the test case.
 *
 *
 * Sample Input 1
 * 3
 * 3 2 4
 * 10 9 6
 * 450 768 517
 * Sample Output 1
 * 1
 * 4
 * 34
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        for(int i=0;i<total;i++){

            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            System.out.println(cal(a,b,c));
        }
    }
    static int cal(int x,int y,int p){
        int res = 1;

        // Update x if it is more
        // than or equal to p
        x = x % p;

        while (y > 0)
        {
            // If y is odd, multiply x
            // with result
            if((y & 1)==1)
                res = (res * x) % p;

            // y must be even now
            // y = y / 2
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }
}
