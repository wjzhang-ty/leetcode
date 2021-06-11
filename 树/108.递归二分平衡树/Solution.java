
import java.util.Stack;
import java.util.Queue;
import java.util.ArrayList;

//   Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 
class Solution {
    // chreate tree
    public static TreeNode createTree(Integer[] list, int i) {
        if(i>=list.length || list[i]==null) return null;
        TreeNode tree = new TreeNode(list[i],createTree(list, 2*i+1),createTree(list, 2*i+2));
        return tree;
    }

    // LDR while
    public static void LDR(TreeNode root) {
        Stack <TreeNode> stack = new Stack <TreeNode>();
        do{
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root = stack.peek();
            System.out.println(root.val);
            if(!stack.empty())stack.pop();
            root=root.right;
        }
        while(!(root==null&&stack.empty()));
    }

    // balance tree
    public static TreeNode sortedArrayToBST(int[] nums) {
        return core(nums,0,nums.length - 1);
    }

    private static TreeNode core(int[] nums,int left,int right){
        if(left>right) return null;
        int mid = left+(right-left)/2;
        return new TreeNode(nums[mid],core(nums,left,mid-1),core(nums,mid+1,right));
    }
    

    public static void main(String[] args) {
        // Integer[] list = {3,9,20,null,null,15,7};
        // TreeNode tree = createTree(list,0);

        int[] bstList = {-10,-3,0,5,9};
        TreeNode BST = sortedArrayToBST(bstList);
        LDR(BST);
    }
}