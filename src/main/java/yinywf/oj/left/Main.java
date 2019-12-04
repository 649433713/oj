package yinywf.oj.left;

import java.util.Scanner;

/**
 * @author yinywf
 * Created on 2019-12-04
 *对称子字符串
 * Description
 * Given a string ‘str’ of digits, find length of the longest substring of ‘str’, such that the length of the substring is 2k digits and sum of left k digits is equal to the sum of right k digits.
 *
 *
 * Input
 * 输入第一行是测试用例的个数，后面每一行表示一个数字组成的字符串，例如："123123"
 *
 *
 * Output
 * 输出找到的满足要求的最长子串的长度。例如，给定的例子长度应该是 6。每行对应一个用例的结果。
 *
 *
 * Sample Input 1
 * 1
 * 1538023
 * Sample Output 1
 * 4
 */
public class Main {

    public static void main(String[] args) {
        getEqualSubString(new Scanner(System.in));
    }

    public static void getEqualSubString(Scanner sc)
    {
        int testNum = Integer.parseInt(sc.nextLine());
        while (testNum-- > 0)
        {
            String[] input = sc.nextLine().split("");
            int left = 0, maxLen = 0;
            while (left < input.length)
            {
                int right = left + 1;
                while (right < input.length)
                {
                    int mid = (left + right) / 2;
                    int leftSum = 0, rightSum = 0;
                    for (int i = left; i <= mid; ++i)
                    {
                        leftSum += Integer.parseInt(input[i]);
                    }
                    for (int i = mid + 1; i <= right; ++i)
                    {
                        rightSum += Integer.parseInt(input[i]);
                    }
                    if (leftSum == rightSum && (right - left + 1) > maxLen)
                    {
                        maxLen = right - left + 1;
                    }
                    right += 2;
                }
                left++;
            }
            System.out.println(maxLen);
        }
    }
}
