package common;

public class TreeNode {
    Integer data;
    TreeNode lchild;
    TreeNode rchild;

    /**
     * 构造方法，左右节点为null
     * @param d 节点值
     */
    TreeNode(){
        data = null;
        lchild = null;
        rchild = null;
    }
    TreeNode(Integer d){
        data = d;
        lchild = null;
        rchild = null;
    }

    /**
     * 构造方法，指定左右节点
     * @param d 节点值
     * @param l 左节点
     * @param r 右节点
     */
    TreeNode(Integer d,TreeNode l,TreeNode r){
        data = d;
        lchild = l;
        rchild = r;
    }

    public void setNode(int data, TreeNode l, TreeNode r){
        this.data = data;
        this.lchild = l;
        this.rchild = r;
    }

}
