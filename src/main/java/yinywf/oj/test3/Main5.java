package yinywf.oj.test3;

/**
 * @author yinywf
 * Created on 2019-11-25
 *
 * 能否成环
 * Description
 * Given an array of strings A[ ], determine if the strings can be chained together to form a circle. A string X can be chained together with another string Y if the last character of X is same as first character of Y. If every string of the array can be chained, it will form a circle. For example, for the array arr[] = {"for", "geek", "rig", "kaf"} the answer will be Yes as the given strings can be chained as "for", "rig", "geek" and "kaf".
 *
 *
 * Input
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow.
 *
 * The first line of each test case contains a positive integer N, denoting the size of the array.
 *
 * The second line of each test case contains a N space seprated strings, denoting the elements of the array A[ ].
 *
 * 1 <= T
 *
 * 0 < N
 *
 * 0 < A[i]
 *
 *
 * Output
 * If chain can be formed, then print 1, else print 0.
 *
 *
 * Sample Input 1
 * 2
 * 3
 * abc bcd cdf
 * 4
 * ab bc cd da
 * Sample Output 1
 * 0
 * 1
 */
import java.util.*;

public class Main5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int j = 0; j < times; j++) {
            int n = scanner.nextInt();
            Map<Character, List<Character>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String s = scanner.next();
                List<Character> list = map.get(s.charAt(0));

                if (list == null) {
                    list = new ArrayList<>();
                    list.add(s.charAt(s.length() - 1));
                    map.put(s.charAt(0), list);
                } else {
                    list.add(s.charAt(s.length() - 1));
                }
            }

            char c = 0;
            char temp = 0;
            for (Character character : map.keySet()) {
                c = map.get(character).get(0);
                break;
            }
            boolean b = findCircle(map, c);


            System.out.println(b ? 1 : 0);

        }

    }


    private static boolean findCircle(Map<Character, List<Character>> map, Character c) {
        if (map.size() == 0) {
            return true;
        }
        if (map.get(c) == null) {
            return false;
        } else {
            Character temp = c;
            for (int x = 0; x < map.get(c).size(); x++) {
                c = map.get(c).get(x);
                map.get(temp).remove(x);
                if (map.get(temp).size() == 0) {
                    map.remove(temp);
                }
                if (!findCircle(map, c)) {
                    List<Character> list = map.get(temp);

                    if (list == null) {
                        list = new ArrayList<>();
                        list.add(c);
                        map.put(temp, list);
                    } else {
                        list.add(x, c);
                    }
                    c = temp;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
