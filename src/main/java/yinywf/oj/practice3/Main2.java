package yinywf.oj.practice3;

import java.util.*;
import java.util.stream.Collectors;


/**
 * KD树构造和查找
 * Description
 *
 * 对给定的点集合构造KD树，要求如下：将方差最大的维度作为当前的分割维度，将数据集在分割维度上排序后的中位数作为分割点。程序要检索给定点对应的最近的K个点的坐标。
 *
 *
 * Input
 *
 * 输入第一行为测试用例个数，后面为测试用例，每一个用例包含三行，第一行为点集合（点之间用逗号隔开，两个坐标用空格隔开），第二行为检索的点，第三行为K值。
 *
 *
 * Output
 */

/**
 * @author yinywf
 * Created on 2019-11-25
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        scanner.nextLine();
        for (int t = 0; t < times; t++) {
            String str = scanner.nextLine();
            List<kdNode> kdNodes = new ArrayList<>();
            for (String s : str.split(",")) {
                kdNodes.add(new kdNode(s.charAt(0) - '0', s.charAt(2) - '0'));
            }
            double x = variance(kdNodes.stream().map(kdNode -> kdNode.x).collect(Collectors.toList()));
            double y = variance(kdNodes.stream().map(kdNode -> kdNode.y).collect(Collectors.toList()));
            kdNode kdNode = construct(kdNodes, x > y ? 0 : 1);
            kdNode target = new kdNode(scanner.nextDouble(), scanner.nextDouble());
            int k = scanner.nextInt();
            Map<Double, kdNode> distance = new HashMap<>();
            List<Double> minK = distance(kdNode, target, distance, k);
            StringBuilder stringBuilder = new StringBuilder();
            for (Double d : minK) {
                kdNode temp = distance.get(d);
                stringBuilder.append(",").append(temp.x.intValue()).append(" ").append(temp.y.intValue());
            }
            System.out.println(stringBuilder.deleteCharAt(0));

        }
    }

    private static double variance(List<Double> x) {
        int m=x.size();
        double sum=0;
        for (double aX : x) {//求和
            sum += aX;
        }
        double dAve=sum/m;//求平均值
        double dVar=0;
        for (double aX : x) {//求方差
            dVar += (aX - dAve) * (aX - dAve);
        }
        return dVar/m;
    }

    private static List<Double> distance(kdNode kdNode, kdNode target, Map<Double, kdNode> distance, int k) {
        List<Double> minK = new ArrayList<>();

        Stack<kdNode> stack = new Stack<>();
        stack.push(kdNode);
        while (!stack.empty()) {
            kdNode temp = stack.pop();
            if (temp == null) {
                continue;
            }
            double d = distance(temp, target, minK, distance, k);
            if (temp.dimension == 0) {
                stack.push(temp.x < target.x ? temp.right : temp.left);
            } else {
                stack.push(temp.y < target.y ? temp.right : temp.left);
            }
            if (temp.father != null) {
                if (temp.father.dimension == 0) {
                    if (temp.father.x < target.x && target.x - minK.get(minK.size() - 1) < temp.father.x && temp.father.left != temp) {
                        stack.push(temp.father.left);
                    } else if (temp.father.x > target.x && target.x + minK.get(minK.size() - 1) > temp.father.x && temp.father.right != temp) {
                        stack.push(temp.father.right);
                    }
                } else {
                    if (temp.father.y < target.y && target.y - minK.get(minK.size() - 1) < temp.father.y && temp.father.left != temp) {
                        stack.push(temp.father.left);
                    } else if (temp.father.y > target.y && target.y + minK.get(minK.size() - 1) > temp.father.y && temp.father.right != temp) {
                        stack.push(temp.father.right);
                    }
                }
            }
        }
        return minK;
    }

    private static double distance(kdNode kdNode, kdNode target, List<Double> minK, Map<Double, kdNode> distance, int k) {
        double d = kdNode.distance(target);
        if (minK.size() < k) {
            minK.add(d);
            distance.put(d, kdNode);
            minK.sort(Double::compareTo);
        } else {
            if (minK.get(k - 1) > d) {
                minK.remove(k-1);
                distance.remove(d);
                minK.add(d);
                distance.put(d, kdNode);
                minK.sort(Double::compareTo);
            }
        }
        return d;
    }

    private static kdNode construct(List<kdNode> kdNodes, int dimension) {
        if (kdNodes.size() == 0) {
            return null;
        }
        List<kdNode> left = new ArrayList<>();
        List<kdNode> right = new ArrayList<>();
        if (dimension == 0) {
            kdNodes.sort(Comparator.comparingDouble(o -> o.x));
        } else {
            kdNodes.sort(Comparator.comparingDouble(o -> o.y));
        }
        int mid = kdNodes.size() / 2;
        kdNode kdNode = kdNodes.get(mid);
        for (int i = 0; i < mid; i++) {
            left.add(kdNodes.get(i));
        }
        for (int i = mid + 1; i < kdNodes.size(); i++) {
            right.add(kdNodes.get(i));
        }
        kdNode.left = construct(left, dimension ^ 1);
        kdNode.right = construct(right, dimension ^ 1);
        if (kdNode.left != null) {
            kdNode.left.father = kdNode;
        }
        if (kdNode.right != null) {
            kdNode.right.father = kdNode;
        }
        kdNode.dimension = dimension;
        return kdNode;
    }

    static class kdNode{
        Double x;
        Double y;
        int dimension;
        kdNode left;
        kdNode right;
        kdNode father;

        kdNode(double x, double y) {
            this.x = x;
            this.y = y;
        }

        double distance(kdNode target) {
            return Math.sqrt(Math.pow(x - target.x, 2) + Math.pow(y - target.y, 2));
        }
    }
}
