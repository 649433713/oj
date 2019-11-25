package yinywf.oj.practice1;

/**
 * @author yinywf
 * Created on 2019-11-25
 * 插入排序
 * Description
 * 实现插入排序。
 *
 *
 * Input
 * 输入第一行为用例个数， 每个测试用例输入的每一行代表一个数组，其中的值用空格隔开，第一个值表示数组的长度。
 *
 *
 * Output
 * 输出排序的数组，用空格隔开，末尾不要空格。
 *
 *
 * Sample Input 1
 * 1
 * 13 24 3 56 34 3 78 12 29 49 84 51 9 100
 * Sample Output 1
 * 3 3 9 12 24 29 34 49 51 56 78 84 100
 */
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int i = 0; i < times; i++) {
            int n = scanner.nextInt();
            int[] is = new int[n];
            for (int j = 0; j < n; j++) {
                is[j] = scanner.nextInt();
            }
            insertionSort(is);
            print(is);

        }
    }
    private static void insertionSort(int[] ins){

        for(int i=1; i<ins.length; i++){
            int temp = ins[i];//保存每次需要插入的那个数
            int j;
            for(j=i; j>0&&ins[j-1]>temp; j--){//这个较上面有一定的优化
                ins[j] = ins[j-1];//吧大于需要插入的数往后移动。最后不大于temp的数就空出来j
            }
            ins[j] = temp;//将需要插入的数放入这个位置
        }
    }

    private static void print(int[] os) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : os) {
            stringBuilder.append(i).append(' ');
        }
        System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1));
    }
}
