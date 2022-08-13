package tree;

/**
 * @author cpx
 * @Description 求二叉树的最大深度
 * @date 2022/8/13
 */
public class MaxDepth {
    //记录节点的运行深度
    private int depth;
    //记录到达叶子节点后树的最大深度
    private int res;


    //通过子树问题寻找最大深度
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    //通过遍历寻找最大深度
    public int maxDepthh(TreeNode root) {
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (root.left == null && root.right == null){
            res = Math.max(depth, res);
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}
