/**
 * 机器人在网格上移动，只能向下向右，问走到左下角共有多少种路径。
 * 1、数组元素含义：路劲数
 * 2、递推关系：kn=kn👆+kn👈
 * 3、数组初始化：因为kn=前两项相加，所以arr[0][0]为1才会递增
 * 4、遍历顺序：依赖前值，故 从前往后
 */
public class Main {

    public static int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        arr[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i-1>=0) arr[i][j] += arr[i-1][j];
                if (j-1>=0) arr[i][j] += arr[i][j-1];
            }
        }
        return arr[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
    }
}
