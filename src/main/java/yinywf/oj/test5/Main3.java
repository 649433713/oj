package yinywf.oj.test5;

import java.util.*;

/**
 * @author yinywf
 * Created on 2019/11/28
 * 时间与收益
 * Description
 *
 * Given a set of n jobs where each job i has a deadline and profit associated to it. Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit if and only if the job is completed by its deadline. The task is to find the maximum profit and the number of jobs done.
 *
 *
 * Input
 *
 * The first line of input contains an integer T denoting the number of test cases.Each test case consist of an integer N denoting the number of jobs and the next line consist of Job id, Deadline and the Profit associated to that Job.
 *
 * Constraints:1<=T<=100，1<=N<=100，1<=Deadline<=100，1<=Profit<=500
 *
 *
 * Output
 *
 * Output the number of jobs done and the maximum profit.
 *
 *
 * Sample Input 1
 *
 * 2
 * 4
 * 1 4 20 2 1 10 3 1 40 4 1 30
 * 5
 * 1 2 100 2 1 19 3 2 27 4 1 25 5 1 15
 * Sample Output 1
 *
 * 2 60
 * 2 127
 */
public class Main3 {

    /**
     * 贪婪
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int t = 0; t < times; t++) {
            int n = scanner.nextInt();
            List<Job> jobs = new ArrayList<>();
            int time = 0;
            for (int i = 0; i < n; i++) {
                scanner.nextInt();
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if (x > time) {
                    time = x;
                }
                jobs.add(new Job(x, y));
            }
            jobs.sort((o1, o2) -> Integer.compare(o2.profit, o1.profit));
            int profit = 0;
            int count = 0;
            while (time != 0) {
                Iterator<Job> iterator = jobs.iterator();
                while (iterator.hasNext()) {
                    Job job = iterator.next();
                    if (job.hold(time)) {
                        iterator.remove();
                        profit += job.profit;
                        count++;
                        break;
                    }
                }
                time--;
            }
            System.out.println(count + " " + profit);
        }
    }
}

class Job {
    int ddl;
    int profit;

    Job(int ddl, int profit) {
        this.ddl = ddl;
        this.profit = profit;
    }

    boolean hold(int time) {
        return time <= ddl;
    }

}

/**
 * ==========回溯法=========
 *
 *  public static void main0(String[] args) {
 *         Scanner scanner = new Scanner(System.in);
 *         int times = scanner.nextInt();
 *         for (int t = 0; t < times; t++) {
 *             int n = scanner.nextInt();
 *             List<Job> jobs = new ArrayList<>();
 *             int time = 0;
 *             for (int i = 0; i < n; i++) {
 *                 scanner.nextInt();
 *                 int x = scanner.nextInt();
 *                 int y = scanner.nextInt();
 *                 if (x > time) {
 *                     time = x;
 *                 }
 *                 jobs.add(new Job(x, y));
 *             }
 *             jobs.sort((o1, o2) -> {
 *                 if (o1.ddl == o2.ddl) {
 *                     return Integer.compare(o2.profit, o1.profit);
 *                 } else {
 *                     return Integer.compare(o2.ddl, o1.ddl);
 *                 }
 *             });
 *             int profit = assign(jobs, time);
 *             int count = (int) jobs.stream().filter(Objects::isNull).count();
 *
 *             System.out.println(count + " " + profit);
 *
 *         }
 *     }
 *
 *     private static int assign(List<Job> jobs, int time) {
 *         if (time == 0) {
 *             return 0;
 *         }
 *         int profit = 0;
 *         int index = -1;
 *         for (int i = 0; i < jobs.size(); i++) {
 *             Job job = jobs.get(i);
 *             if (job != null && job.hold(time)) {
 *                 jobs.set(i, null);
 *                 int tmp = job.profit + assign(jobs, time - 1);
 *                 if (profit < tmp) {
 *                     profit = tmp;
 *                     index = i;
 *                 }
 *                 jobs.set(i, job);
 *             }
 *         }
 *         if (index > -1) {
 *             jobs.set(index, null);
 *         } else {
 *             return assign(jobs, time - 1);
 *         }
 *         return profit;
 *     }
 */
