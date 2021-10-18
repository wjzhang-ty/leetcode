/**
 * Q:需要 n 阶楼梯。每次可以爬 1、2 个台阶。有多少种不同的方法可以爬到楼顶？
 * 1、数组元素含义：当爬到n阶时，共有多少种方法
 * 2、递推公式：当前阶 kn= (kn-2) + (kn-1)
 * 3、数组初始化：数组从小标1开始生效，arr[0]记为1，保证arr[1、2]等数值正常
 * 4、遍历顺序：求kn需要知道kn-1、kn-2的数量，依赖前面所以从前往后
 */
public class Main {
    public static int climbStairs(int n) {
        int[] arr = new int[n+1];
        arr[0]=1;

        for (int i = 1; i <= n; i++) {
            if (i-1>=0) arr[i] += (arr[i-1]);
            if (i-2>=0) arr[i] += (arr[i-2]);
        }

        return arr[n];
    }

    public static void main(String[] args) {
	// write your code here
        System.out.println(climbStairs(4));
    }
}
