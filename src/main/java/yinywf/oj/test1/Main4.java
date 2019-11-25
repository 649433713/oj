package yinywf.oj.test1;

/**
 * @author yinywf
 * Created on 2019-11-25
 *
 * 字符串匹配问题
 * Description
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[]. You may assume that n > m.
 *
 *
 * Input
 * 输入第一行是用例个数，后面一行表示一个用例；用例包括两部分，第一部分为给定文本，第二部分为搜索串，两部分使用","隔开。
 *
 *
 * Output
 * 每一个用例输出一行，每行按照找到的位置先后顺序排列，使用空格隔开。
 *
 *
 * Sample Input 1
 * 2
 * THIS IS A TEST TEXT,TEST
 * AABAACAADAABAABA,AABA
 *
 * Sample Output 1
 * 10
 * 0 9 12
 */
import java.util.*;

public class Main4 {

    private static int[] cal_next(char[] cs) {
        int[] result = new int[cs.length];
        result[0] = -1;
        int k = -1;
        for (int i = 1; i < cs.length; i++) {
            while (k > -1 && cs[k + 1] != cs[i])//如果下一个不同，那么k就变成next[k]，注意next[k]是小于k的，无论k取任何值。
            {
                k = result[k];//往前回溯
            }
            if (cs[k + 1] == cs[i])//如果相同，k++
            {
                k = k + 1;
            }
            result[i] = k;//这个是把算的k的值（就是相同的最大前缀和最大后缀长）赋给next[i]
        }
        return result;
    }

    private static int KMP(char[] cs, char[] target) {
        int[] result = cal_next(target);
        int k = -1;
        for (int i = 0; i < cs.length; i++) {
            while (k > -1 && target[k + 1] != cs[i]) {
                k = result[k];
            }
            if (target[k + 1] == cs[i]) {
                k = k + 1;
            }
            if (k == target.length - 1) {
                return i - target.length + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        scanner.nextLine();
        for (int j = 0; j < times; j++) {
            String s = scanner.nextLine();
            String[] ss = s.split(",");
            char[] source = ss[0].toCharArray();
            int index = KMP(source, ss[1].toCharArray());
            StringBuilder stringBuilder = new StringBuilder();
            while (index > -1) {
                stringBuilder.append(" ").append(index);
                source[index] = '@';
                index = KMP(source, ss[1].toCharArray());
            }
            if (stringBuilder.length() == 0) {
                System.out.println();
                continue;
            }
            System.out.println(stringBuilder.deleteCharAt(0));
        }
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int times = scanner.nextInt();
//        scanner.nextLine();
//        for (int j = 0; j < times; j++) {
//            String s = scanner.nextLine();
//            String[] ss = s.split(",");
//            char[] source = ss[0].toCharArray();
//            int index = ss[0].indexOf(ss[1]);
//            StringBuilder stringBuilder = new StringBuilder();
//            while (index > -1) {
//                stringBuilder.append(" ").append(index);
//                source[index] = '@';
//                index = new String(source).indexOf(ss[1]);
//            }
//            System.out.println(stringBuilder.deleteCharAt(0));
//        }
//    }

}


