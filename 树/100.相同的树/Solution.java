
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

    // check same tree
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        Stack <TreeNode> stack1 = new Stack <TreeNode>();
        stack1.push(p);
        Stack <TreeNode> stack2 = new Stack <TreeNode>();
        stack2.push(q);
        while(p!=null&&q!=null&&!stack1.empty()&&!stack2.empty()){
            p = stack1.peek();
            q = stack2.peek();
            stack1.pop();
            stack2.pop();
            if(p.val!=q.val) return false;

            if(p.left!=null) stack1.push(p.left);
            if(q.left!=null) stack2.push(q.left);
            if(stack1.size()!=stack2.size()) return false;

            if(p.right!=null) stack1.push(p.right);
            if(q.right!=null) stack2.push(q.right);
            if(stack1.size()!=stack2.size()) return false;
        }
        if(q==null && p==null) return true;
        return p != null && q != null && p.val == q.val;
    }


    public static void main(String[] args) {
        int[] list1 = {1};
        TreeNode tree1 = createTree(list1,0);
        
        int[] list2 = {};
        TreeNode tree2 = createTree(list2,0);

        // inorderTraversal2(tree1);

        System.out.println(isSameTree(tree1,tree2));
    }
}