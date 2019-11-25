package yinywf.oj.practice2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Description
 * <p>
 * 输入一个数组和一个数字，在数组中查找两个数，使得它们的和正好是输入的那个数字，统计这样两个数的对数。
 * <p>
 * <p>
 * Input
 * <p>
 * 输入第一行为用例个数， 每个测试用例输入第一行是数组，每一个数用空格隔开；第二行是数字和。
 * <p>
 * <p>
 * Output
 * <p>
 * 输出这样两个数有几对。
 * <p>
 * <p>
 * Sample Input 1
 * <p>
 * 1
 * 1 2 4 7 11 0 9 15
 * 11
 * Sample Output 1
 * <p>
 * 3
 */
class Main6 {
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        int times=scanner.nextInt();
        for(int i=0;i<times; i++){
            scanner.nextLine();
            String s=scanner.nextLine();
            String[]ss=s.split(" ");
            int[]is=new int[ss.length];
            for(int j=0;j<ss.length;j++){
                is[j]=Integer.parseInt(ss[j]);
            }
            int sum=scanner.nextInt();

            Map<Integer, Integer> map=new HashMap<>();
            int count=0;
            for(int k=0;k<is.length;k++){
                if(map.get(sum-is[k])!=null){
                    count++;
                }
                map.put(is[k],k);
            }
            System.out.println(count);
//
//            Arrays.sort(is);
//            System.out.println(countSum(is, 0, is.length - 1, sum));

        }
    }

    private static int countSum(int[]is,int l,int r,int sum){
        if(l>=r){
            return 0;
        }
        int s=is[l]+is[r];
        if(s==sum){
            return 1+countSum(is,l+1,r-1,sum);
        }else{
            return Math.max(countSum(is,l,r-1,sum),countSum(is,l+1,r,sum));
        }
    }

}