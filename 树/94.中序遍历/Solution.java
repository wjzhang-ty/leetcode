
import java.util.Stack;

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
    public static TreeNode createTree(int[] list, int i) {
        if(i>=list.length) return null;
        TreeNode tree = new TreeNode(list[i],createTree(list, 2*i+1),createTree(list, 2*i+2));
        return tree;
    }

    // 递归遍历二叉树
    public static void inorderTraversal(TreeNode root) {
        if(root==null) return;
        System.out.println(root.val);
        inorderTraversal(root.left);
        inorderTraversal(root.right);
    }

    // 中序遍历二叉树
    public static void inorderTraversal2(TreeNode root) {
        Stack <TreeNode> stack = new Stack <TreeNode>();
        do{
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root = stack.peek();
            list.add(root.val);
            if(!stack.empty())stack.pop();
            root=root.right;
        }
        while(!(root==null&&stack.empty()));
        
    }

    public static void main(String[] args) {
        int[] list = {1,3,2,3};
        TreeNode tree =  createTree(list,0);
        inorderTraversal2(tree);
    }
}