
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

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root!=null){
            if(root.val < p.val && root.val < q.val) root = root.right;
            else if(root.val > p.val && root.val > q.val) root = root.left;
            else return root;
        }
        return null;
    }


    public static void main(String[] args) {
        Integer[] list = {6,2,8,0,4,7,9,null,null,3,5};
        TreeNode tree = createTree(list,0);
        LDR(tree);
        System.out.println(lowestCommonAncestor(tree,tree.left,tree.left.right));
    }
}