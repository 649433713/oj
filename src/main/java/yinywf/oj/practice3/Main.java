package yinywf.oj.practice3;

/**
 * @author yinywf
 * Created on 2019-11-25
 *
 * 分配问题
 * Description
 *
 * 对给定的n个任务与n个人之间的成本矩阵完成成本最低的任务分配策略。
 *
 *
 * Input
 *
 * 输入：第一行为用例个数，之后为每一个用例；用例的第一行为任务个数，即n；用例的第二行为使用逗号隔开的人员完成任务的成本；每一个成本描述包括人员序号、任务序号和成本，使用空格隔开。人员序号和任务序号都是从1到n的整数，序号出现的次序没有固定规则。
 *
 *
 * Output
 *
 * 输出：每一个用例输出一行，从序号为1的人员开始，给出其分配的任务序号，使用空格隔开；使用逗号将多个解隔开。结果按照人员分配的任务序号大小排，第一个人员的任务序号大的放在前面，如果相同则看第二个人员的任务，以此类推。
 *
 *
 * Sample Input 1
 *
 * 1
 * 4
 * 2 1 6,1 2 2,1 3 7,1 4 8,1 1 9,2 2 4,2 3 3,2 4 7,3 1 5,3 2 8,3 3 1,3 4 8,4 1 7,4 2 6,4 3 9,4 4 4
 * Sample Output 1
 *
 * 2 1 3 4
 */
public class Main {
    /* Python
    def pri():
    for i in range(len(result)):
        for j in range(len(result[0])):
            if i == len(result)-1 and j == len(result[0])-1:
                print(result[i][j])
            elif i != len(result)-1 and j == len(result[0])-1:
                print(result[i][j],end=',')
            else:
                print(result[i][j] , end=' ')

def mysort(sortindex):
    keyset=""
    for i in range(sortindex):
        keyset+= "x["+str(i)+"],"
    keyset = keyset.rstrip(",")
    result.sort(key=lambda x:eval(keyset),reverse=True)

def work( i , count , res_temp):
    global cost
    res_temp_copy = res_temp.copy()
    if i > n :
        if count == cost:
            if res_temp_copy not in result:
                result.append(res_temp_copy)
        if count < cost:
            result.clear()
            result.append(res_temp_copy)
            cost = count
    if count <= cost:
        for j in range(1,n+1):
            if x[j] == 0 :
                res_temp.append(j)
                x[j] = 1
                work(  i + 1 , count+costMatrix[i][j] , res_temp)
                res_temp.pop()
                x[j] = 0



if __name__=='__main__':
    numOfExamples = int(input())
    x = [ 0 for i in range(1000)]
    for c in range(numOfExamples):
        n = int(input())
        costMatrix = [[0 for j in range(n + 1)] for i in range(n + 1)]
        strarray = input().split(',')
        for j in range(0, len(strarray)):
            temp_array = []
            tempArray = strarray[j].split(' ')
            costMatrix[int(tempArray[0])][int(tempArray[1])] = int(tempArray[2])
        cost = 0
        res_temp = []
        result = []
        for i in range( 1 , len(costMatrix)):
            cost += costMatrix[i][i]
            res_temp.append(i)
        result.append(res_temp)
        work(1,0, [])
        mysort(len(result[0]))
        pri()


     */
}
