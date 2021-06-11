
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

    

    public static int minDepth(TreeNode root) {
        if(root==null) return 0;
        Queue <TreeNode> queue = new LinkedList<TreeNode>();
        int depth = 1;
        queue.add(root);
        while(queue.size()>0){
            int len = queue.size();
            for(int i = 0; i < len; i++){
                TreeNode temp = queue.remove();
                if(temp.left==null&&temp.right==null) return depth;
                if(temp.left!=null)queue.add(temp.left);
                if(temp.right!=null)queue.add(temp.right);
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        Integer[] list = {1,2,3,4,5};
        TreeNode tree = createTree(list,0);

        System.out.println(minDepth(tree));
    }
}