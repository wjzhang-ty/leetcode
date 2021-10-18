import common.CommonUtils;
import common.TreeNode;

public class Main {

    public static void main(String[] args) {
        CommonUtils tree = new CommonUtils();
        Integer[] arr = {1,2,3,4,null,5,6};
        TreeNode head = tree.CreateTree(arr);
        tree.DLR(head);
    }
}
