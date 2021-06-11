
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

    
    // DFS recursion
    public static boolean hasPathSum1(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return root.val == targetSum;
        }
        return hasPathSum1(root.left, targetSum - root.val) || hasPathSum1(root.right, targetSum - root.val);
    }

    // DFS iteration
    public static boolean hasPathSum2(TreeNode root, int targetSum) {
        if(root == null) return false;
        Stack <TreeNode> stack = new Stack <TreeNode>();
        Stack <Integer> sum = new Stack <Integer>();
        stack.push(root);
        sum.push(root.val);
        while(stack.size()>0){
            TreeNode tempTree = stack.pop();
            int tempSum = sum.pop();
            if(tempTree.left==null&&tempTree.right==null&&tempSum==targetSum) return true;
            if(tempTree.left!=null){
                stack.push(tempTree.left);
                sum.push(tempSum+tempTree.left.val);
            }
            if(tempTree.right!=null){
                stack.push(tempTree.right);
                sum.push(tempSum+tempTree.right.val);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] list = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode tree = createTree(list,0);
        System.out.println(hasPathSum2(tree,22));
    }
}