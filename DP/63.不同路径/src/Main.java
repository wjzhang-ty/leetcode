/**
 * 机器人在网格上移动，只能向下向右，问走到左下角共有多少种路径。
 * 1、数组元素含义：路径数
 * 2、递推关系：kn=kn👆+kn👈  if(👆>=0 && obstacleGrid[👆]==0)
 * 3、数组初始化： 当[0][0]无障碍时，因为kn=前两项相加，所以arr[0][0]为1才会递增。
 *              当[0][0]有障碍时，机器人无法出发所以置为0（个人感觉题目描述不严谨）
 * 4、遍历顺序：依赖前值，故 从前往后
 */
public class Main {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] arr = new int[m][n];
        arr[0][0]=obstacleGrid[0][0]==1?0:1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j]!=1){
                    if (i-1>=0&&obstacleGrid[i-1][j]!=1) arr[i][j] += arr[i-1][j];
                    if (j-1>=0&&obstacleGrid[i][j-1]!=1) arr[i][j] += arr[i][j-1];
                }
            }
        }
        return arr[m-1][n-1];
    }

    public static void main(String[] args) {
	    int[][] arr = {{1,0},{0,0}};
        System.out.println(uniquePathsWithObstacles(arr));
    }
}
