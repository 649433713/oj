package yinywf.oj.left;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yinywf
 * Created on 2019-12-04
 * 点的凸包
 * Description
 * Convex Hull of a set of points, in 2D plane, is a convex polygon with minimum area such that each point lies either on the boundary of polygon or inside it. Now given a set of points the task is to find the convex hull of points.
 *
 *
 * Input
 * The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer N denoting the no of points. Then in the next line are N*2 space separated values denoting the points ie x and y.Constraints:1<=T<=100,1<=N<=100,1<=x,y<=1000
 *
 *
 * Output
 * For each test case in a new line print the points x and y of the convex hull separated by a space in sorted order (increasing by x) where every pair is separated from the other by a ','. If no convex hull is possible print -1.
 *
 *
 * Sample Input 1
 * 2
 * 3
 * 1 2 3 1 5 6
 * 3
 * 1 2 4 4 5 1
 * Sample Output 1
 * 1 2, 3 1, 5 6
 * 1 2, 4 4, 5 1
 */
public class Main8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
            int n = sc.nextInt();
            Point[] points = new Point[n];
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                points[j] = new Point(x, y);
            }
            List<Point> res = calTrees(points);
            if (res.size() < 3) {
                System.out.println(-1);
            } else {
                String str = res.stream()
                        .map(p -> p.x + " " + p.y)
                        .collect(Collectors.joining(", "));
                System.out.println(str);
            }
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int calPoint(Point p, Point q, Point r) {
        return (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
    }

    public static List<Point> calTrees(Point[] points) {
        Arrays.sort(points, (p, q) -> q.x - p.x == 0 ? q.y - p.y : q.x - p.x);
        Stack<Point> stacks = new Stack<>();
        for (int i = 0; i < points.length; i++) {
            while (stacks.size() >= 2 && calPoint(stacks.get(stacks.size() - 2), stacks.get(stacks.size() - 1), points[i]) > 0)
                stacks.pop();
            stacks.push(points[i]);
        }
        stacks.pop();
        for (int i = points.length - 1; i >= 0; i--) {
            while (stacks.size() >= 2 && calPoint(stacks.get(stacks.size() - 2), stacks.get(stacks.size() - 1), points[i]) > 0)
                stacks.pop();
            stacks.push(points[i]);
        }
        List<Point> res = new ArrayList<>(new HashSet<>(stacks));
        res.sort((p1, p2) -> {
            if (p1.x == p2.x) {
                return p1.y - p2.y;
            }
            return p1.x - p2.x;
        });
        return res;
    }
}
