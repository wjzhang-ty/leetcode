
import sun.reflect.generics.tree.Tree;

import java.util.*;

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

    public static int sumOfLeftLeaves(TreeNode root) {
        if(root.right==null&&root.left==null) return 0;
        boolean isleft = true;
        int sum = 0;
        Stack <TreeNode> stack = new Stack<TreeNode>();
        while (root!=null || !stack.empty()){
            while (root!=null){
                stack.add(root);
                root = root.left;
                if(root!=null) isleft = true;
            }
            root= stack.pop();
            if(root.right==null && root.left==null && isleft) sum+= root.val;
            root=root.right;
            isleft = false;
        }
        return sum;
    }


    public static void main(String[] args) {
        Integer[] list = {1};
        TreeNode tree = createTree(list,0);
        System.out.println(sumOfLeftLeaves(tree));
    }
}