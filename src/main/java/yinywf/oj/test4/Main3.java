package yinywf.oj.test4;

/**
 * @author yinywf
 * Created on 2019-11-25
 *
 * 矩阵计算
 * Description
 * Let's define a Series Whose recurrence formula is as follows :
 *
 * C(n)= 3C(i-1) + 4C(i-2) + 5C(i-3) + 6C(i-4)
 *
 * C(0)= 2
 *
 * C(1)= 0
 *
 * C(2)= 1
 *
 * C(3)= 7
 *
 * Now based on this Series a Matrix Mi,j of size nn is to be formed.The top left cell is(1,1) and the bottom right corner is (n,n). Each cell (i,j) of the Matrix contains either 1 or 0. If C( (i*j)^3 ) is odd, Mi,j is 1, otherwise, it's 0.Count the total number of ones in the Matrix.
 *
 *
 * Input
 * First Line Of the input will contain an integer 'T'- the number of test cases . Each of the next 'T' lines consists of an integer 'n'.-denoting the size of the matrix.
 *
 * Constraints :
 *
 * 1 ≤ T ≤ 1000
 *
 * 1 ≤ n ≤ 1000
 *
 *
 * Output
 * For each test case, output a single Integer -the taste value fo the dish of size-n*n.
 *
 *
 * Sample Input 1
 * 1
 * 2
 * Sample Output 1
 * 0
 */


import java.util.Scanner;
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        int[] results = new int[]{0, 0, 1, 1, 1, 0, 1};
        for (int t = 0; t < times; t++) {
            int num = scanner.nextInt();
            int count = 0;
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    if (results[new Double(Math.pow((i + 1) * (j + 1), 3)).intValue() % 7] == 1) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
