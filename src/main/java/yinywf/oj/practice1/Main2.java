package yinywf.oj.practice1;

/**
 * @author yinywf
 * Created on 2019-11-25
 * 链表回文
 * Description
 * 判断一个单向链表是否为回文结构。自定义链表数据结构，要求时间复杂度为O(n)，额外空间复杂度为O(1)。
 *
 *
 * Input
 * 输入第一行为用例个数， 每个测试用例输入的每一行的值用空格隔开，第一个值为节点个数，后面为每一个节点值
 *
 *
 * Output
 * 是回文则输出true，不是则输出false，一行表示一个链表的结果。
 *
 *
 * Sample Input 1
 * 4
 * 3 1 2 1
 * 4 1 2 2 1
 * 3 3 5 3
 * 6 a b c d c a
 * Sample Output 1
 * true
 * true
 * true
 * false
 */
import java.util.Scanner;
import java.util.Stack;

/**
 * @author yinywf
 * Created on 2019-10-30
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int i = 0; i < times; i++) {
            int n = scanner.nextInt();
            Node head = new Node();
            Node temp = head;
            for (int j = 0; j < n; j++) {
                Node node = new Node();
                node.o = scanner.next();
                temp.next = node;
                temp = node;
            }

            Node first = head;
            Node second = head;
            while (second.next != null) {
                first = first.next;
                second = second.next;
                if (second.next != null) {
                    second = second.next;
                }
            }
            Stack<Object> stack = new Stack<>();
            while (first.next != null) {
                first = first.next;
                stack.push(first.o);
            }
            boolean result = true;
            while (!stack.empty()) {
                if (!head.next.o.equals(stack.pop())) {
                    result = false;
                    break;
                }
                head = head.next;
            }
            System.out.println(result);
        }

    }
    static class Node{
        Object o;
        Node next;
    }
}
