package yinywf.oj.practice3;

import java.util.*;

/**
 * @author yinywf
 * Created on 2019-11-25
 *
 * 拓扑排序解的个数
 * Description
 *
 * 给定有向无环图中所有边，计算图的拓扑排序解的个数。
 *
 *
 * Input
 *
 * 输入第一行为用例个数，后面每一行表示一个图中的所有边，边的起点和终点用空格隔开，边之间使用逗号隔开。
 *
 *
 * Output
 *
 * 输出拓扑排序解的个数。
 *
 *
 * Sample Input 1
 *
 * 1
 * a c,b c,c d,d e,d f,e g,f g
 * Sample Output 1
 *
 * 4
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        scanner.nextLine();
        for (int t = 0; t < times; t++) {
            String str = scanner.nextLine();
            String[] edges = str.split(",");
            Map<Character, Node> map = new HashMap<>();
            for (String edge : edges) {
                Character source = edge.charAt(0);
                Character target = edge.charAt(2);
                map.putIfAbsent(target, new Node(target, false));
                //可能每次都要false
                if (map.get(source) != null) {
                    map.get(source).add(map.get(target));
                } else {
                    map.put(source, new Node(source).add(map.get(target)));
                }
            }
            Integer count = 0;
            for (Node node : map.values()) {
                if (node.head) {
                    count += node.findTrace();
                }
            }
            System.out.println(count);
        }
    }
    static class Node{
        Character val;
        List<Node> next;
        boolean head;

        Node(Character val) {
            this.val = val;
            next = new ArrayList<>();
            head = true;
        }

        Node(Character val, boolean head) {
            this.val = val;
            next = new ArrayList<>();
            this.head = head;
        }

        Node add(Node next) {
            this.next.add(next);
            return this;
        }

        Integer findTrace() {
            if (next.size() == 0) {
                return 1;
            }
            int count = 0;
            for (Node node : next) {
                count += node.findTrace();
            }
            return count;
        }

        Integer findDeep(String trace) {
            if (next.size() == 0) {
                return 1;
            }
            int count = 1;
            for (Node node : next) {
                if (!trace.contains(String.valueOf(node.val))) {
                    count = Math.max(node.findDeep(trace + node.val) + 1, count);
                }

            }
            return count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(val, node.val);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }
    }
}
