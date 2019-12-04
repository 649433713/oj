package yinywf.oj.left;

import java.util.Scanner;

/**
 * @author yinywf
 * Created on 2019-12-04
 * 整除查询
 * Description
 * Given an array of positive integers and many queries for divisibility. In every query Q[i], we are given an integer K , we need to count all elements in the array which are perfectly divisible by K.
 *
 * Constraints:1<=T<=1001<=N,M<=1051<=A[i],Q[i]<=105
 *
 *
 * Input
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of three lines. First line of each test case contains two integers N & M, second line contains N space separated array elements and third line contains M space separated queries.
 *
 *
 * Output
 * For each test case,In new line print the required count for each query Q[i].
 *
 *
 * Sample Input 1
 * 2
 * 6 3
 * 2 4 9 15 21 20
 * 2 3 5
 * 3 2
 * 3 4 6
 * 2 3
 * Sample Output 1
 * 3 3 2
 * 2 2
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        for(int i=0;i<total;i++){
            int l1 = scanner.nextInt();
            int l2 = scanner.nextInt();
            int a1[] = new int[l1];
            int a2[] = new int[l2];
            for(int j=0;j<l1;j++){
                a1[j] = scanner.nextInt();
            }
            for(int k=0;k<l2;k++){
                a2[k] = scanner.nextInt();
            }
            cal(a1,a2);
        }
    }
    static void cal(int []a1,int []a2){
        String ans = "";
        for(int i=0;i<a2.length;i++){
            int div = a2[i];
            int count = 0;
            for(int j=0;j<a1.length;j++){
                if(a1[j]%div==0){
                    count++;
                }
            }
            ans+=count+" ";

        }
        ans = ans.substring(0,ans.length()-1) ;
        System.out.println(ans);
    }
}
