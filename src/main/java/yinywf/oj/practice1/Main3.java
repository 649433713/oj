package yinywf.oj.practice1;

/**
 * @author yinywf
 * Created on 2019-11-25
 * 链表区间逆序
 * Description
 * 将单个链表的每K个节点之间逆序，打印出新链表；最后不足K的节点数不需要逆序；要求时间复杂度为O(n)，额外空间复杂度为O(1)。
 *
 *
 * Input
 * 输入第一行为用例个数， 每个测试用例输入的每一行的值用空格隔开，第一个表示链表长度，中间为节点值，最后代表K。
 *
 *
 * Output
 * 输出的每一行为新的链表，节点值用空格隔开，末尾不要空格。
 *
 *
 * Sample Input 1
 * 2
 * 8 1 2 3 4 5 6 7 8 3
 * 8 a b c d e f g h 4
 * Sample Output 1
 * 3 2 1 6 5 4 7 8
 * d c b a h g f e
 */
import java.util.Scanner;
import java.util.Stack;

public class Main3 {

    static class Node{
        Object o;
        Node next;
    }

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
            int k = scanner.nextInt();
            temp = head;
            Node cur = head;
            int count = 0;
            Stack<Node> stack = new Stack<>();
            while (cur.next != null) {
                count++;
                cur = cur.next;
                stack.push(cur);
                if (count == k) {
                    cur = cur.next;
                    while (count != 0) {
                        temp.next = stack.pop();
                        count--;
                        temp = temp.next;
                    }
                    temp.next = cur;
                    cur = temp;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (head.next != null) {
                head = head.next;
                stringBuilder.append(head.o).append(' ');
            }
            System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1));
        }
    }
}
