package yinywf.oj.practice3;

import java.util.Scanner;

/**
 * @author yinywf
 * Created on 2019-11-25
 *
 * 棋盘覆盖问题
 * Description
 *
 * 棋盘覆盖问题：给定一个大小为2^n2^n个小方格的棋盘，其中有一个位置已经被填充，现在要用一个L型（22个小方格组成的大方格中去掉其中一个小方格）形状去覆盖剩下的小方格。求出覆盖方案，即哪些坐标下的小方格使用同一个L型格子覆盖。注意：坐标从0开始。左上方的第一个格子坐标为(0,0)，第一行第二个坐标为(0,1)，第二行第一个为(1,0)，以此类推。
 *
 *
 * Input
 *
 * 输入第一行为测试用例个数，后面每一个用例有两行，第一行为n值和特殊的格子的坐标（用空格隔开），第二行为需要查找其属于同一个L型格子的格子坐标。
 *
 *
 * Output
 *
 * 输出每一行为一个用例的解，先按照行值从小到大、再按照列值从小到大的顺序输出每一个用例的两个坐标；用逗号隔开。
 *
 *
 * Sample Input 1
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int t = 0; t < times; t++) {
            int n = scanner.nextInt();
            int num = new Double(Math.pow(2, n)).intValue();
            int[][] nums = new int[num][num];
            int sourceX = scanner.nextInt();
            int sourceY = scanner.nextInt();
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();

            int baseX = 0;
            int baseY = 0;
            int tempN = num;
            while (tempN != 2) {
                int l1 = location(sourceX - baseX, sourceY - baseY, tempN);
                int l2 = location(targetX - baseX, targetY - baseY, tempN);
                boolean center = center(targetX - baseX, targetY - baseY, tempN);
                int half = tempN/2;
                if (l1 != l2 && center) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String[] result = new String[]{(baseX + half - 1) + " " + (baseY + half - 1), (baseX + half - 1)
                            + " " + (baseY + half), (baseX + half) + " " + (baseY + half - 1), (baseX + half) + " "
                            + (baseY + half)};
                    int except1 = l1;
                    int except2 = location(targetX - baseX, targetY - baseY, tempN);
                    for (int i = 0; i < result.length; i++) {
                        if (i != except1 && i != except2) {
                            stringBuilder.append(",").append(result[i]);
                        }
                    }
                    stringBuilder.deleteCharAt(0);
                    System.out.println(stringBuilder);
                    tempN = 0;
                    break;
                }
                tempN /= 2;
                switch (l2) {
                    case 0:
                        if (l1 != l2) {
                            sourceX = baseX + tempN - 1;
                            sourceY = baseY + tempN - 1;
                        }
                        break;
                    case 1:
                        baseY += tempN;
                        if (l1 != l2) {
                            sourceX = baseX + tempN - 1;
                            sourceY = baseY;
                        }
                        break;
                    case 2:
                        baseX += tempN;
                        if (l1 != l2) {
                            sourceX = baseX;
                            sourceY = baseY + tempN - 1;
                        }
                        break;
                    case 3:
                        baseX += tempN;
                        baseY += tempN;
                        if (l1 != l2) {
                            sourceX = baseX;
                            sourceY = baseY;
                        }
                        break;
                }
            }

            if (tempN == 2) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int x = 0; x < 2; x++) {
                    for (int y = 0; y < 2; y++) {
                        if ((baseX + x == sourceX && baseY + y == sourceY) || baseX + x == targetX && baseY + y == targetY) {
                            continue;
                        }
                        stringBuilder.append(",").append(baseX + x).append(" ").append(baseY + y);
                    }
                }
                stringBuilder.deleteCharAt(0);
                System.out.println(stringBuilder);
            }
        }
    }

    private static int location(int x, int y, int length) {
        int half = length / 2;
        if (x < half) {
            return y < half ? 0 : 1;
        } else {
            return y < half ? 2 : 3;
        }
    }

    private static boolean center(int x, int y, int length) {
        if (length == 2) {
            return false;
        }
        int half = length / 2;
        return x <= half && x >= half - 1 && y <= half && y >= half - 1;
    }
}
