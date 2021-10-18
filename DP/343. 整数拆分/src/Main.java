/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，求这些整数的最大乘积。
 * 1、数组元素含义：当前值得最大乘机
 * 2、递推关系：  max{ arr[i], (i-j)*j, arr[i-j]*j}
 *              前方局部最大*(i-j) 或者 (i-j)*j 例如6
 * 3、数组初始化： i、j会参与运算，为了方便，arr[0]占位，不参与运算
 *              因为有(i-j)*j的存在，后续值不会被0影响，所以不用任何初始化
 * 4、遍历方向：向前依赖，故 由前往后
 * 5、附加：arr[i-j]*j局部最优解可以省略部分运算，但是与(i-j)*j依旧会有重复运算，动态规划似乎并不完美
 */
public class Main {

    public static int integerBreak(int n) {
        int[] arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                arr[i] = Math.max(arr[i],Math.max((i-j)*j, j*arr[i-j]));
            }
        }

        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(6));
    }
}
