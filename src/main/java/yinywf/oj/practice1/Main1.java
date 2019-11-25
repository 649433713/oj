package yinywf.oj.practice1;

/**
 * @author yinywf
 * Created on 2019-11-25
 *
 * 最长公共子序列
 * Description
 * 给定两个字符串，返回两个字符串的最长公共子序列（不是最长公共子字符串），可能是多个。
 *
 *
 * Input
 * 输入第一行为用例个数， 每个测试用例输入为两行，一行一个字符串
 *
 *
 * Output
 * 如果没有公共子序列，不输出，如果有多个则分为多行，按字典序排序。
 *
 *
 * Sample Input 1
 * 1
 * 1A2BD3G4H56JK
 * 23EFG4I5J6K7
 * Sample Output 1
 * 23G456K
 * 23G45JK
 */

import java.util.*;

class Main1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < times; i++) {

            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();

            int[][] dp = new int[s1.length() + 1][s2.length() + 1];

            for (int j = 1; j <= s1.length(); j++) {
                for (int k = 1; k <= s2.length(); k++) {
                    if (s1.charAt(j - 1) == s2.charAt(k - 1)) {
                        dp[j][k] = dp[j - 1][k - 1] + 1;
                    } else {
                        dp[j][k] = Math.max(dp[j - 1][k], dp[j][k - 1]);
                    }
                }
            }


            Set<String> traces = new HashSet<>();
            traces.add("");
            int col = 0;
            for (int m = 1; m <= dp[s1.length()][s2.length()]; m++) {
                List<Integer> temp = findJ(dp, col, m);
                col = temp.get(0);
                Set<String> traces2 = new HashSet<>();
                for (int i1 : temp) {
                    for (String trace : traces) {
                        traces2.add(trace + s1.charAt(i1));
                    }
                }
                traces = traces2;
            }

            traces.removeIf(trace -> !isSub(s1, trace) || !isSub(s2, trace)|| trace.length() == 0);
            List<String> list = new ArrayList<>(traces);
            Collections.sort(list);
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    private static List<Integer> findJ(int[][] dp, int j, int target) {
        List<Integer> result = new ArrayList<>();
        for (int i = j; i < dp.length; i++) {
            for (int m = 1; m < dp[i].length; m++) {
                if (dp[i][m] == target) {
                    if (dp[i - 1][m] == dp[i][m - 1]) {
                        result.add(i - 1);
                    }
                    break;
                }
            }
        }
        return result;
    }

    private static boolean isSub(String a, String b) {
        for (char c : b.toCharArray()) {
            int i = a.indexOf(c);
            if (i < 0) {
                return false;
            }
            a = a.substring(i + 1);
        }
        return true;
    }

}