package tree;

/**
 * @ClassName TreeFlatten
 * @Author jackchen
 * @Date 2022/8/22 19:09
 * @Description 将二叉树展开为链表
 **/
public class TreeFlatten {
    //为什么不能用前序遍历解决？因为前序遍历并不能原地拉平二叉树。
    //用分解思想，子树解决了，整体就解决了
    void flatten(TreeNode root){
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        //左右子树已经被拉平
        TreeNode left = root.left;
        TreeNode right = root.right;
        //将左子树设置为右子树
        root.left = null;
        root.right = left;
        //将原来的右子树接到现在的右子树下面,找末尾的端点接上去就可以
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
