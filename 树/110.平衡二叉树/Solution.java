
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

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
    private static boolean isBalanced(TreeNode root){
        return height(root)>=0;
    }
    
    private static int height(TreeNode root){
        if(root==null) return 0;
        int LHeight = height(root.left); 
        int RHeight = height(root.right);
        if(LHeight==-1||RHeight==-1||Math.abs(LHeight - RHeight)>1) return -1;
        else return Math.max(LHeight, RHeight) + 1;
    }

    public static void main(String[] args) {
        Integer[] list = {3,9,20,null,null,15,7};
        TreeNode tree = createTree(list,0);

        System.out.println(isBalanced(tree));
    }
}