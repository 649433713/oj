package yinywf.oj.practice3;

import java.util.*;

/**
 * @author yinywf
 * Created on 2019-11-25
 * 按照数值个数排序
 * Description
 *
 * 对给定数组中的元素按照元素出现的次数排序，出现次数多的排在前面，如果出现次数相同，则按照数值大小排序。例如，给定数组为{2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12}，则排序后结果为{3, 3, 3, 3, 2, 2, 2, 12, 12, 4, 5}。
 *
 *
 * Input
 *
 * 输入的第一行为用例个数；后面每一个用例使用两行表示，第一行为数组长度，第二行为数组内容，数组元素间使用空格隔开。
 *
 *
 * Output
 *
 * 每一个用例的排序结果在一行中输出，元素之间使用空格隔开。
 *
 *
 * Sample Input 1
 *
 * 1
 * 4
 * 2 3 2 5
 * Sample Output 1
 *
 * 2 2 3 5
 */
public class Main8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int t = 0; t < times; t++) {
            int n = scanner.nextInt();
            Map<Integer, Integer> count = new HashMap<>();
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                count.merge(num, 1, (a, b) -> a + b);
            }
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                if (map.get(entry.getValue()) != null) {
                    map.get(entry.getValue()).add(entry.getKey());
                } else {
                    map.put(entry.getValue(), new ArrayList<>(Collections.singletonList(entry.getKey())));
                }
            }
            List<Integer> list = new ArrayList<>(count.values());
            Collections.sort(list);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = list.size() - 1; i >= 0; i--) {
                List<Integer> list2 = map.get(list.get(i));
                Collections.sort(list2);
                for (Integer integer : list2) {
                    for (int k = 0; k < i; k++) {
                        stringBuilder.append(integer).append(" ");
                    }
                }
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            System.out.println(stringBuilder.toString());
        }
    }
}
