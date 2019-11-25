package yinywf.oj.practice3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author yinywf
 * Created on 2019-11-25
 *
 * 广度优先遍历图
 * Description
 *
 * 按照给定的起始顶点广度优先遍历图，每一次通过字母顺序选择顶点查找下一层邻接点，打印遍历顺序。
 *
 *
 * Input
 *
 * 输入第一行为测试用例个数，后面每一个用例用多行表示，用例第一行是节点个数n和开始顶点，用空格隔开，后面n+1行为图的邻接矩阵，其中第一行为节点名称。值之间使用空格隔开。
 *
 *
 * Output
 *
 * 输出遍历顺序，用空格隔开
 */
public class Main6 {

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
                    StringBuilder stringBuilder = new StringBuilder(String.valueOf(head)).append(" ");
                    List<Node> deep = node.next;
                    List<Node> deepTemp;
                    while (deep.size() != 0) {
                        deepTemp = new ArrayList<>();
                        for (Node ne : deep) {
                            if (!stringBuilder.toString().contains(String.valueOf(ne.val))) {
                                stringBuilder.append(ne.val).append(" ");
                                deepTemp.addAll(ne.next);
                            }
                        }
                        deep = deepTemp;
                    }
                    System.out.println(stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString());
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
