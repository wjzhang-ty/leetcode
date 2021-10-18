package common;

import java.util.*;

public class CommonUtils {
    /**
     * 创建二叉树
     * @param arr 节点数组
     * @return 头节点
     */
    public TreeNode CreateTree(Integer[] arr){
        if (arr[0]==null){
            System.out.println("头节点为空非法");
            return null;
        }

        TreeNode head = new TreeNode(arr[0]); // 存放头节点
        Queue<TreeNode> queue=new LinkedList<>(); // 借助队列
        queue.offer(head);

        // 每次出队父节点，添加左右节点。i跨度为2
        for (int i = 1; i < arr.length; i++) {
            TreeNode fNode = queue.poll();
            if (arr[i]!=null){
                TreeNode lNode = new TreeNode(arr[i]);
                fNode.lchild=lNode;
                queue.offer(lNode);
            }
            i++;
            if (i<arr.length && arr[i]!=null) {
                TreeNode rNode = new TreeNode(arr[i]);
                fNode.rchild = rNode;
                queue.offer(rNode);
            }
        }
        return head;
    }


    /**
     * 层遍历
     * @param head 头节点
     */
    public void LayerTraver(TreeNode head){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(head);
        while (queue.size()>0){
            TreeNode first = queue.poll();
            if (first==null||first.data==null){
                continue;
            }
            if (first.lchild!=null){
                queue.add(first.lchild);
            }
            if (first.rchild!=null){
                queue.add(first.rchild);
            }
            System.out.print(first.data+" ");
        }
    }


    public void DLR(TreeNode head){
        if (head==null){
            System.out.println("空节点");
            return;
        }
        Stack <TreeNode> stack = new Stack<TreeNode>();

        do {
            while (head!=null){
                stack.push(head);
                System.out.println(head.data);
                head=head.lchild;
            }
            head = stack.peek();
            stack.pop();
            head = head.rchild;
        } while (!stack.empty()||head!=null);
    }




}
