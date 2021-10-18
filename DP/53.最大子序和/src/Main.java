public class Main {

    public static int maxSubArray(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0]=nums[0];
        int max = arr[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i]+nums[i-1], nums[i]);
            if (nums[i]>max) max=nums[i];
        }
        return max;
    }

    public static void main(String[] args) {
	    int[] num = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(num));
    }
}
