package tree;

/**
 * @author cpx
 * @Description 翻转二叉树
 * @date 2022/8/16
 */
public class InvertTree {
    private TreeNode node;

    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    /**
     * 这是用遍历的方法解决的
     * @param root
     */
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        traverse(root.left);
        traverse(root.right);
    }

    //通过分解子树问题递归反转二叉树
    public TreeNode invertTreeNew(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode left = invertTreeNew(root.left);
        TreeNode right = invertTreeNew(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
