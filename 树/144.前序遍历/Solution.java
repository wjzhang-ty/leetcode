
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

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

    
    public static List<Integer> preorderTraversal(TreeNode root) {
        List <Integer> list = new ArrayList<>();
        if(root==null) return list;
        Stack <TreeNode> stack = new Stack <TreeNode>();
        while(!(root==null&&stack.empty())){
            while(root!=null){
                System.out.println(root.val);
                list.add(root.val);
                stack.push(root);
                root=root.left;
            }
            root = stack.peek();
            if(!stack.empty())stack.pop();
            root=root.right;
        }
        return list;
    }

    public static void main(String[] args) {
        Integer[] list = {1,null,2,3};
        TreeNode tree = createTree(list,0);
        // System.out.println();
        preorderTraversal(tree);
    }
}