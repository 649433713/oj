package yinywf.oj.practice2;

import java.util.Scanner;

/**
 * Description
 * <p>
 * 汉诺塔问题中限制不能将一层塔直接从最左侧移动到最右侧，也不能直接从最右侧移动到最左侧，而是必须经过中间。求当有N层塔的时候移动步数。
 * <p>
 * <p>
 * Input
 * <p>
 * 输入第一行为用例个数， 每个测试用例输入的第一行为N。
 * <p>
 * <p>
 * Output
 * <p>
 * 移动步数。
 * <p>
 * <p>
 * Sample Input 1
 * <p>
 * 1
 * 2
 * Sample Output 1
 * <p>
 * 8
 */
class Main4 {
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        for(int i=0;i<n; i++){
            int count=0;
            int num=scanner.nextInt();
            for(int j=0;j<num; j++){
                count=count*3+2;
            }
            System.out.println(count);
            //System.out.println(transfer(scanner.nextInt()));
        }
    }

    private static int transfer(int i){
        if(i==1){
            return 2;
        }else{
            return 3*transfer(i-1)+2;
        }
    }

}