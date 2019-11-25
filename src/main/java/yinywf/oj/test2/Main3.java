package yinywf.oj.test2;

/**
 * @author yinywf
 * Created on 2019-11-25
 *
 * Searching_4
 * Description
 * Given n Magnets which are placed linearly, with each magnet to be considered as of point object. Each magnet suffers force from its left sided magnets such that they repel it to the right and vice versa. All forces are repulsive. The force being equal to the distance (1/d , d being the distance). Now given the positions of the magnets, the task to find all the points along the linear line where net force is ZERO.
 *
 * Note: Distance have to be calculated with precision of 0.0000000000001.
 *
 * Constraints:1<=T<=100,1<=N<=100,1<=M[]<=1000
 *
 *
 * Input
 * The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. The second line of each test case contains an integer N. Then in the next line are N space separated values of the array M[], denoting the positions of the magnet.
 *
 *
 * Output
 * For each test case in a new line print the space separated points having net force zero till precised two decimal places.
 *
 *
 * Sample Input 1
 * 2
 * 2
 * 1 2
 * 4
 * 0 10 20 30
 * Sample Output 1
 * 1.50
 * 3.82 15.00 26.18
 */
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        DecimalFormat df = new DecimalFormat("#.00");
        for (int i = 0; i < times; i++) {
            int num = scanner.nextInt();
            int[] nums = new int[num];
            for (int k = 0; k < num; k++) {
                nums[k] = scanner.nextInt();
            }

            List<Double> result = new ArrayList<>();
            for (int j = 0; j < num - 1; j++) {
                double temp = nums[j];
                double tempL = nums[j];
                double tempR = nums[j + 1];
                double t = 0;
                double left, right;
                while (true) {

                    left = 0;
                    right = 0;
                    for (int index = 0; index <= j; index++) {
                        left += 1.0 / (temp - nums[index]);
                    }

                    for (int index = j + 1; index < num; index++) {
                        right += 1.0 / (nums[index] - temp);
                    }
                    if (left - right > 0.00000001) {
                        t = temp;
                        temp = (temp + tempR) / 2.0;
                        tempL = t;
                    } else if (right - left > 0.00000001) {
                        t = temp;
                        temp = (tempL + temp) / 2.0;
                        tempR = t;
                    } else {
                        break;

                    }
                }
                result.add(temp);
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (Double d : result) {
                stringBuilder.append(df.format(d)).append(" ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            System.out.println(stringBuilder.toString());
        }
    }


}
