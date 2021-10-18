/**
 * cost[第一级台阶需要的体力值、第二级台阶需要的体力值...] 扣除体力值可往上走1|2级。问走到顶楼做少开销？
 * 1、数组元素含义：站在当前台阶时已用的体力值（站上来不扣体力，往上走时才扣）
 * 2、递推公式：kn = min{kn-1,kn-2} + Cn  前两阶最小的+当前开销
 * 3、数组初始化：arr[第一阶]需要arr[0]、arr[-1]的数据，所以前端额外开辟两个开销为0的空元素，避免前端溢出。
 *             arr[楼顶]还需要一个额外空间，开销为0。
 * 4、遍历顺序：如上所诉，需求前置，由前往后遍历
 */
public class Main {
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] arr = new int[n+3];

        for (int i = 2; i <= n+2; i++) {
            arr[i] = Math.min(arr[i-1],arr[i-2])+(i-2>=cost.length?0:cost[i-2]);
        }
        
        return arr[n+2];
    }

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
