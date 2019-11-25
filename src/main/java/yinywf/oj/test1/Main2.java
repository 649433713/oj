package yinywf.oj.test1;

/**
 * @author yinywf
 * Created on 2019-11-25
 *
 * 按照另一个数组排序
 * Description
 * Given two array A1[] and A2[], sort A1 in such a way that the relative order among the elements will be same as those in A2. For the elements not present in A2. Append them at last in sorted order. It is also given that the number of elements in A2[] are smaller than or equal to number of elements in A1[] and A2[] has all distinct elements.
 *
 * Input:A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8} A2[] = {2, 1, 8, 3}Output: A1[] = {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}
 *
 * Since 2 is present first in A2[], all occurrences of 2s should appear first in A[], then all occurrences 1s as 1 comes after 2 in A[]. Next all occurrences of 8 and then all occurrences of 3. Finally we print all those elements of A1[] that are not present in A2[]
 *
 * Constraints:1 ≤ T ≤ 501 ≤ M ≤ 501 ≤ N ≤ 10 & N ≤ M1 ≤ A1[i], A2[i] ≤ 1000
 *
 *
 * Input
 * The first line of input contains an integer T denoting the number of test cases. The first line of each test case is M and N. M is the number of elements in A1 and N is the number of elements in A2.The second line of each test case contains M elements. The third line of each test case contains N elements.
 *
 *
 * Output
 * Print the sorted array according order defined by another array.
 *
 *
 * Sample Input 1
 * 1
 * 11 4
 * 2 1 2 5 7 1 9 3 6 8 8
 * 2 1 8 3
 * Sample Output 1
 * 2 2 1 1 8 8 3 5 6 7 9
 */
import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            int[] a1 = new int[n1];
            int[] a2 = new int[n2];
            for (int j = 0; j < n1; j++) {
                a1[j] = scanner.nextInt();
            }
            for (int j = 0; j < n2; j++) {
                a2[j] = scanner.nextInt();
            }

            HashMap<Integer, Integer> treeMap = new HashMap<>();
            for (int k : a1) {
                treeMap.merge(k, 1, Integer::sum);
            }

            List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(treeMap.entrySet());
            entries.sort((o1, o2) -> {
                int index1 = index(a2, o1.getKey());
                int index2 = index(a2, o2.getKey());
                if (index1 >= 0 && index2 >= 0) {
                    return index1 < index2 ? -1 : 1;
                } else if (index1 < 0 && index2 < 0) {
                    return o1.getKey() < o2.getKey() ? -1 : 1;
                } else {
                    return index1 < 0 ? 1 : -1;
                }
            });
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<Integer, Integer> entry : entries) {
                for (int j = 0; j < entry.getValue(); j++) {
                    stringBuilder.append(entry.getKey()).append(" ");
                }
            }
            System.out.println(stringBuilder.deleteCharAt(stringBuilder.length()-1));

        }
    }
    private static int index(int[] a, int i) {
        for (int index = 0; index < a.length; index++) {
            if (a[index] == i) {
                return index;
            }
        }
        return -1;
    }
}
