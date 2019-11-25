package yinywf.oj.practice2; /**
 * 先升后降
 * Description
 * <p>
 * 从一列不重复的数中筛除尽可能少的数使得从左往右看，这些数是从小到大再从大到小的。
 * <p>
 * <p>
 * Input
 * <p>
 * 输入第一行为用例个数， 每个测试用例输入是一个数组，数值通过空格隔开。
 * <p>
 * <p>
 * Output
 * <p>
 * 输出筛选之后的数组，用空格隔开。如果有多种结果，则一行一种结果， 单个输入的所有结果按从小到大排序，排序的key的优先级随index递增而递减 例如 3 4 7 6； 1 3 7 5； 1 2 7 6； 1 3 7 6 排序成 1 2 7 6；1 3 7 5；1 3 7 6； 3 4 7 6；
 * <p>
 * <p>
 * Sample Input 1
 * <p>
 * 4
 * 1 2 4 7 11 10 9 15 3 5 8 6
 * 1 3 5 4 7 6 4 5 3
 * 1 2 3
 * 3 2 1
 * Sample Output 1
 * <p>
 * 1 2 4 7 11 10 9 8 6
 * 1 3 4 7 6 4 3
 * 1 3 4 7 6 5 3
 * 1 3 5 7 6 4 3
 * 1 3 5 7 6 5 3
 * 1 2 3
 * 3 2 1
 */

import java.util.*;

class Main7 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int times = scanner.nextInt();

        scanner.nextLine();

        for (int i = 0; i < times; i++) {

            String s = scanner.nextLine();

            String[] ss = s.split(" ");

            int[] is = new int[ss.length];

            for (int j = 0; j < ss.length; j++) {

                is[j] = Integer.parseInt(ss[j]);

            }


            is = duplicateRemoval(is);


            Set<String> result = new HashSet<>();

            int length = 0;

            for (int k = 0; k < is.length; k++) {

                List<String> leftTemp = sortSub(is, 0, k, true);

                List<String> rightTemp = sortSub(is, k, is.length, false);

                int lengthTemp = (leftTemp.size() == 0 ? 0 : leftTemp.get(0).split(" ").length)

                        + (rightTemp.size() == 0 ? 0 : rightTemp.get(0).split(" ").length);

                if (lengthTemp > length) {

                    length = lengthTemp;

                    result = new HashSet<>();

                    if (leftTemp.size() == 0) {

                        result.addAll(rightTemp);

                    }

                    for (String lStr : leftTemp) {

                        for (String rStr : rightTemp) {

                            result.add(lStr + " " + rStr);

                        }

                    }

                } else if (lengthTemp == length) {

                    if (leftTemp.size() == 0) {

                        result.addAll(rightTemp);

                    }

                    for (String lStr : leftTemp) {

                        for (String rStr : rightTemp) {

                            result.add(lStr + " " + rStr);

                        }

                    }

                }

            }


            Object[] strings = result.toArray();

            Arrays.sort(strings);

            for (Object o : strings) {

                System.out.println(o);

            }


        }


    }


    private static int[] duplicateRemoval(int[] is) {

        List<Integer> list = new ArrayList<>();

        list.add(is[0]);

        for (int i = 1; i < is.length; i++) {

            if (is[i] != is[i - 1]) {

                list.add(is[i]);

            }

        }


        return list.stream().mapToInt(Integer::valueOf).toArray();

    }


    private static List<String> sortSub(int[] is, int begin, int end, boolean up) {

        List<String>[] lisTrace = new List[end - begin];

        int[] lis = new int[end - begin];


        for (int i = 0; i < end - begin; i++) {

            lisTrace[i] = new ArrayList<>();

            lisTrace[i].add(String.valueOf(is[i + begin]));

            lis[i] = 1;

            for (int j = 0; j < i; j++) {

                if ((is[i + begin] > is[j + begin]) == up) {

                    if (lis[j] + 1 > lis[i]) {

                        lis[i] = lis[j] + 1;

                    }

                    if (lis[j] + 1 == lis[i]) {

                        for (String str : lisTrace[j]) {

                            lisTrace[i].add(str + " " + is[i + begin]);

                        }

                    }

                }

            }

            Iterator<String> it = lisTrace[i].iterator();


            while (it.hasNext()) {

                String[] str = it.next().split(" ");

                if (str.length < lis[i]) {

                    it.remove();

                }

            }

        }


        List<String> result = new ArrayList<>();

        int max = max(lis);

        int index = index(lis, max);

        while (index >= 0) {

            result.addAll(lisTrace[index]);

            lis[index] = 0;

            index = index(lis, max);

        }


        return result;

    }

    private static int max(int[] a) {
        int max = 0;
        for (int i : a) {
            if (i > max) {
                max = i;
            }
        }
        return max;
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
