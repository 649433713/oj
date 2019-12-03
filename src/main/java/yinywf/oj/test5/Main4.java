package yinywf.oj.test5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author yinywf
 * Created on 2019/11/28
 * 硬币最小数量
 * Description
 *
 * Given the list of coins of distinct denominations and total amount of money. Output the minimum number of coins required to make up that amount. Output -1 if that money cannot be made up using given coins. You may assume that there are infinite numbers of coins of each type.
 *
 *
 * Input
 *
 * The first line contains 'T' denoting the number of test cases. Then follows description of test cases. Each cases begins with the two space separated integers 'n' and 'amount' denoting the total number of distinct coins and total amount of money respectively. The second line contains N space-separated integers A1, A2, ..., AN denoting the values of coins.
 *
 * Constraints:1<=T<=30，1<=n<=100，1<=Ai<=1000，1<=amount<=100000
 *
 *
 * Output
 *
 * Print the minimum number of coins required to make up that amount or return -1 if it is impossible to make that amount using given coins.
 *
 *
 * Sample Input 1
 *
 * 2
 * 3 11
 * 1 2 5
 * 2 7
 * 2 6
 * Sample Output 1
 *
 * 3
 * -1
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int t = 0; t < times; t++) {
            int type = scanner.nextInt();
            int amount = scanner.nextInt();
            int[] coins = new int[type];
            for (int i = 0; i < type; i++) {
                coins[i] = scanner.nextInt();
            }
            System.out.println(deep(coins, amount,new HashMap<>()));
        }
    }

    private static int deep(int[] coins, int amount, Map<Integer, Integer> map) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int num = Integer.MAX_VALUE;
        for (int coin : coins) {
            int tmp = map.get(amount - coin) == null ? deep(coins, amount - coin, map) : map.get(amount - coin);
            if (tmp < 0) {
                continue;
            }
            num = tmp < num ? tmp : num;
        }

        map.put(amount, num == Integer.MAX_VALUE ? -1 : num + 1);
        return num == Integer.MAX_VALUE ? -1 : num + 1;
    }
}
