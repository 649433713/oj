package yinywf.oj.practice3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author yinywf
 * Created on 2019-11-25
 * 深度优先遍历
 * Description
 *
 * 按照给定的起始顶点深度优先遍历给定的无向图，尝试所有可能的遍历方式，打印遍历过程中出现的最大深度。
 *
 *
 * Input
 *
 * 输入第一行是用例个数，后面每个用例使用多行表示，用例的第一行是图中节点的个数n和起始点，用空格隔开，后面n+1行为图的邻接矩阵，其中第一行为节点名称。值之间使用空格隔开。
 *
 *
 * Output
 *
 * 输出深度优先遍历中遇到的最大深度。
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int t = 0; t < times; t++) {
            int num = scanner.nextInt();
            char head = scanner.next().charAt(0);
            scanner.nextLine();
            String str = scanner.nextLine();
            char[] chars = new char[num];
            Node[] nodes = new Node[num];
            for (int i = 0; i < num; i++) {
                chars[i] = str.charAt(i * 2);
                nodes[i] = new Node(chars[i]);
            }
            for (int i = 0; i < num; i++) {
                str = scanner.nextLine().substring(2);
                String[] vals = str.split(" ");
                for (int j = 0; j < vals.length; j++) {
                    if (vals[j].equals("1")) {
                        nodes[i].add(nodes[j]);
                    }
                }
            }

            for (Node node : nodes) {
                if (node.val == head) {
                    System.out.println(node.findDeep(String.valueOf(node.val)));
                    break;
                }
            }
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
