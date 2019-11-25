package yinywf.oj.practice1;

/**
 * @author yinywf
 * Created on 2019-11-25
 * 非递归快排
 * Description
 * 快速排序的核心思想是使用元素的值对数组进行划分。实现其非递归方案。
 *
 *
 * Input
 * 输入的每一行表示一个元素为正整数的数组，所有值用空格隔开，第一个值为数值长度，其余为数组元素值。
 *
 *
 * Output
 * 输出的每一行为排序结果，用空格隔开，末尾不要空格。
 *
 *
 * Sample Input 1
 * 13 24 3 56 34 3 78 12 29 49 84 51 9 100
 * Sample Output 1
 * 3 3 9 12 24 29 34 49 51 56 78 84 100
 */

import java.util.Scanner;
import java.util.Stack;


public class Main7 {

    private static void print(int[] os) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : os) {
            stringBuilder.append(i).append(' ');
        }
        System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1));
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] is = new int[n];
            for (int j = 0; j < n; j++) {
                is[j] = scanner.nextInt();
            }
            quickSort(is, new Stack<>());
            print(is);

        }
    }

    private static void quickSort(int[] array, Stack<Record> stack) {
        int left = 0;
        int right = array.length - 1;
        if (left < right) {
            int pivot = PartSort(array, left, right);
            if (pivot - 1 >= left) {
                stack.push(new Record(left, pivot - 1));
            }
            if (pivot + 1 <= right) {
                stack.push(new Record(pivot + 1, right));
            }
            while (!stack.isEmpty()) {
                Record record = stack.pop();
                pivot = PartSort(array, record.left, record.right);
                if (pivot - 1 >= record.left) {
                    stack.push(new Record(record.left, pivot - 1));
                }
                if (pivot + 1 <= record.right) {
                    stack.push(new Record(pivot + 1, record.right));
                }
            }
        }
    }

    private static int PartSort(int[] arr, int low, int high) {
        int data = arr[low];
        /*
         * 一次遍历的方法：插空法 定义一个data将arr[low]存起来，并把这个位置挖空
         */
        while (low < high) {
            while (low < high && arr[high] >= data) {
                high--;
            }
            arr[low] = arr[high];
            /**
             * 从high，也就是后面往前遍历 找到比键值小的数据 插入到前面留下的空中 high位再次留下空来
             */

            while (low < high && arr[low] <= data) {
                low++;
            }
            arr[high] = arr[low];

        }
        arr[low] = data;
        /*
         * 循环退出后 low和high重合 将将键值赋给第low，并将low返回
         */
        return low;
    }


    private static class Record {
        int left;
        int right;

        private Record(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
