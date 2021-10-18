/**
 * 假设有n种硬币，面值在prices[]中。任取m枚硬币，刚好凑够27元，最少需要几个硬币？
 * 1、数组元素含义：硬币个数
 * 2、递推关系：kn = (kn-面值)+1
 * 3、初始化数组：arr[0]用来占位，全体初始化为0.
 * 4、遍历顺序：向前依赖，故 由前往后
 */
public class Main {
    public static int coinChange(int[] prices, int m){
        int n = prices.length;
        int[] arr = new int[m+1];
        arr[0]=0;

        for (int i = 1; i <= m; i++) {
            arr[i]=Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                int index = i-prices[j];
                if (index >= 0 && arr[index] != Integer.MAX_VALUE){
                    arr[i] = Math.min(arr[i],arr[index]+1);
                }
            }
        }

        if (arr[m]==Integer.MAX_VALUE) arr[m]=-1;
        return arr[m];
    }

    public static void main(String[] args) {
        int[] prices={2,5,7};
        System.out.println(coinChange(prices,27));

    }
}
