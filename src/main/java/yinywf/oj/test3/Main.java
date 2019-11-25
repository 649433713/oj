package yinywf.oj.test3;

/**
 * @author yinywf
 * Created on 2019-11-25
 *
 * 数字重组整除问题
 * Description
 * Babul’s favourite number is 17. He likes the numbers which are divisible by 17. This time what he does is that he takes a number N and tries to find the largest number which is divisible by 17, by rearranging the digits. As the number increases he gets puzzled with his own task. So you as a programmer have to help him to accomplish his task.Note: If the number is not divisible by rearranging the digits, then print “Not Possible”. N may have leading zeros.
 *
 *
 * Input
 * The first line of input contains an integer T denoting the no of test cases. Each of the next T lines contains the number N.
 *
 *
 * Output
 * For each test case in a new line print the desired output.
 *
 *
 * Sample Input 1
 * 4
 * 17
 * 43
 * 15
 * 16
 * Sample Output 1
 * 17
 * 34
 * 51
 * Not Possible
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Main {
    private static int max=0;
    private static HashMap<Integer,Integer> hm;
    private static void rec(String s, String n){
        if(s.length()==n.length() && Integer.parseInt(s)%17==0){
            if(Integer.parseInt(s)>max){
                max=Integer.parseInt(s);
            }
            return ;
        }
        for(int i=0;i<n.length();i++){
            if(!hm.containsKey(i)){
                hm.put(i,1);
                rec(s+n.charAt(i),n);
                hm.remove(i);
            }
        }

    }
    public static void main (String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine().trim());
        while(t--!=0){
            max=0;
            String n=br.readLine().trim();

            hm=new HashMap<>();
            rec("",n);
            if(max==0){
                System.out.println("Not Possible");
            }else
                System.out.println(max);


        }
    }
}
