package yinywf.oj.practice2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description
 * <p>
 * 给定一个整型数组arr和一个大小为w的窗口，窗口从数组最左边滑动到最右边，每次向右滑动一个位置，求出每一次滑动时窗口内最大元素的和。
 * <p>
 * <p>
 * Input
 * <p>
 * 输入第一行为用例个数， 每个测试用例输入的第一行为数组，每一个元素使用空格隔开；第二行为窗口大小。
 * <p>
 * <p>
 * Output
 * <p>
 * 输出每个测试用例结果。
 * <p>
 * <p>
 * Sample Input 1
 * <p>
 * 1
 * 4 3 5 4 3 3 6 7
 * 3
 * Sample Output 1
 * <p>
 * 32
 *
 */
class Main3 {
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        int times=scanner.nextInt();
        for(int i=0;i<times; i++){
            scanner.nextLine();
            String s=scanner.nextLine();
            String[]ss=s.split(" ");
            int n=scanner.nextInt();
            int[]is=new int[ss.length];
            for(int j=0;j<ss.length;j++){
                is[j]=Integer.parseInt(ss[j]);
            }

            int sum=0;
            int max=0;
            int maxIndex=0;
            for(int index=0;index<n; index++){
                if(is[index]>max){
                    max=is[index];
                    maxIndex=index;
                }
            }
            sum+=max;
            for(int index=1;index<is.length-n+1;index++){
                if(maxIndex>=index&&is[index+n-1]>max){
                    max=is[index+n-1];
                    maxIndex=index+n-1;
                }else{
                    max=max(is,index,index+n);
                    maxIndex=index(is,max,index,index+n);
                }
                sum+=max;

            }
            System.out.println(sum);
        }
    }

    private static int max(int[]a){
        int max=0;
        for(int i:a){
            if(i>max){
                max=i;
            }
        }
        return max;
    }

    private static int max(int[]a,int begin,int end){
        return max(Arrays.copyOfRange(a,begin,end));
    }

    private static int index(int[]a,int i){
        for(int index=0;index<a.length;index++){
            if(a[index]==i){
                return index;
            }
        }
        return-1;
    }

    private static int index(int[]a,int i,int begin,int end){
        return index(Arrays.copyOfRange(a,begin,end),i)+begin;

    }
}
