
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

    // LDR recursion
    public static void inorderTraversal(TreeNode root) {
        if(root==null) return;
        System.out.println(root.val);
        inorderTraversal(root.left);
        inorderTraversal(root.right);
    }

    // LDR while
    public static void inorderTraversal2(TreeNode root) {
        Stack <TreeNode> stack = new Stack <TreeNode>();
        do{
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root = stack.peek();
            if(!stack.empty())stack.pop();
            root=root.right;
        }
        while(!(root==null&&stack.empty()));
    }

    // check depth tree
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return level;
    }


    public static void main(String[] args) {
        int[] list = {1};
        TreeNode tree = createTree(list,0);
    }
}