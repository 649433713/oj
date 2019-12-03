package yinywf.oj.test5;

import java.util.*;

/**
 * @author yinywf
 * Created on 2019/11/28
 * 管道网络
 * Description
 *
 * Every house in the colony has at most one pipe going into it and at most one pipe going out of it. Tanks and taps are to be installed in a manner such that every house with one outgoing pipe but no incoming pipe gets a tank installed on its roof and every house with only an incoming pipe and no outgoing pipe gets a tap. Find the efficient way for the construction of the network of pipes.
 *
 *
 * Input
 *
 * The first line contains an integer T denoting the number of test cases. For each test case, the first line contains two integer n & p denoting the number of houses and number of pipes respectively. Next, p lines contain 3 integer inputs a, b & d, d denoting the diameter of the pipe from the house a to house b.Constraints:1<=T<=50，1<=n<=20，1<=p<=50，1<=a, b<=20，1<=d<=100
 *
 *
 * Output
 *
 * For each test case, the output is the number of pairs of tanks and taps installed i.e n followed by n lines that contain three integers: house number of tank, house number of tap and the minimum diameter of pipe between them.
 *
 *
 * Sample Input 1
 *
 * 1
 * 9 6
 * 7 4 98
 * 5 9 72
 * 4 6 10
 * 2 8 22
 * 9 7 17
 * 3 1 66
 * Sample Output 1
 *
 * 3
 * 2 8 22
 * 3 1 66
 * 5 6 10
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int t = 0; t < times; t++) {
            int house = scanner.nextInt();
            int line = scanner.nextInt();
            Map<Integer, Node> map = new HashMap<>();
            for (int l = 0; l < line; l++) {
                int value = scanner.nextInt();
                int next = scanner.nextInt();
                int price = scanner.nextInt();

                Node source = map.get(value) == null ? new Node(value) : map.get(value);
                Node target = map.get(next) == null ? new Node(next) : map.get(next);
                source.next = target;
                source.price = price;
                target.pre = source;
                if (source.pre != null) {
                    map.remove(source.value);
                }else {
                    map.put(source.value, source);
                }

                if (target.next != null) {
                    map.remove(target.value);
                }else {
                    map.put(target.value, target);
                }
            }


            List<Integer> keys = new ArrayList<>(map.keySet());
            for (Integer integer : keys) {
                if (map.get(integer).pre != null) {
                    map.remove(integer);
                }
            }
            keys.sort(Integer::compareTo);

            System.out.println(map.size());
            for (Integer i : keys) {
                if (map.get(i) != null) {
                    map.get(i).print();
                }
            }

        }
    }
}
class Node{
    int value;
    Node next;
    int price;
    Node pre;

    Node(int value) {
        this.value = value;
    }

    void print() {
        if (pre != null) {
            return;
        }
        int min = price;
        while (next.price != 0) {
            if (next.price < min) {
                min = next.price;
            }
            next = next.next;
        }
        System.out.println(value + " " + next.value + " " + min);
    }
}
