package yinywf.oj.left;

import java.util.Scanner;

/**
 * @author yinywf
 * Created on 2019-12-04
 *
 * 按照要求保留数组元素使得和最大
 * Description
 * Given an array of N numbers, we need to maximize the sum of selected numbers. At each step, you need to select a number Ai, delete one occurrence of Ai-1 (if exists) and Ai each from the array. Repeat these steps until the array gets empty. The problem is to maximize the sum of selected numbers.
 *
 *
 * Input
 * The first line of the input contains T denoting the number of the test cases. For each test case, the first line contains an integer n denoting the size of the array. Next line contains n space separated integers denoting the elements of the array.
 *
 * Constraints:1<=T<=100，1<=n<=50，1<=A[i]<=20
 *
 * Note: Numbers need to be selected from maximum to minimum.
 *
 *
 * Output
 * For each test case, the output is an integer displaying the maximum sum of selected numbers.
 *
 *
 * Sample Input 1
 * 2
 * 3
 * 1 2 3
 * 6
 * 1 2 2 2 3 4
 * Sample Output 1
 * 4
 * 10
 */
public class Main11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        for(int i=0;i<total;i++){
            int length = scanner.nextInt();
            int []arrNum=new int[length];
            for(int j=0;j<length;j++){
                arrNum[j]=scanner.nextInt();
            }
            System.out.println(maximize(arrNum,length));
        }
    }
    public static int maxNum(int [] arrNum){
        int max = arrNum[0];
        for(int i=0;i<arrNum.length;i++){
            if(arrNum[i]>=max){
                max=arrNum[i];
            }
        }
        return max;
    }
    public static int maximize(int []arrNum,int length){
        int sum = 0;
        int count = 0;
        boolean flag1 = true;
        boolean flag2 = true;
        while (true) {
            flag1=true;
            flag2=true;
            int maxNum = maxNum(arrNum);
            sum+=maxNum;
            if(maxNum==0){
                break;
            }
            for (int i = 0; i < length; i++) {
                if(flag1&&arrNum[i]==maxNum){
                    arrNum[i]=0;
                    flag1=false;
                    count++;
                    continue;
                }
                if(flag2&&arrNum[i]==maxNum-1){
                    arrNum[i]=0;
                    flag2=false;
                    count++;
                    continue;
                }
            }
        }
        return sum;

    }
}
