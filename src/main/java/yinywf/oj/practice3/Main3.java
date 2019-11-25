package yinywf.oj.practice3;

/**
 * @author yinywf
 * Created on 2019-11-25
 */
import java.util.*;

/**
 * 实现Shell排序
 * Description
 *
 * 实现Shell排序，对给定的无序数组，按照给定的间隔变化（间隔大小即同组数字index的差），打印排序结果，注意不一定是最终排序结果！
 *
 *
 * Input
 *
 * 输入第一行表示测试用例个数，后面为测试用例，每一个用例有两行，第一行为给定数组，第二行为指定间隔，每一个间隔用空格隔开。
 *
 *
 * Output
 *
 * 输出的每一行为一个用例对应的指定排序结果。
 */
public class Main3 {

    private static void shellSort(int[] nums, int step) {
        for (int i = 0; i < step; i++) {
            List<Integer> list = new ArrayList<>();
            int j = i;
            while (j < nums.length) {
                list.add(nums[j]);
                j += step;
            }
            Collections.sort(list);
            j = i;
            int index = 0;
            while (j < nums.length) {
                nums[j] = list.get(index++);
                j += step;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        scanner.nextLine();
        for (int t = 0; t < times; t++) {
            String numStr = scanner.nextLine();
            String[] numsStr = numStr.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }
            String step = scanner.nextLine();
            for (String s : step.split(" ")) {
                shellSort(nums, Integer.parseInt(s));
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i : nums) {
                stringBuilder.append(" ").append(i);
            }
            stringBuilder.deleteCharAt(0);
            System.out.println(stringBuilder);
        }
    }
}
