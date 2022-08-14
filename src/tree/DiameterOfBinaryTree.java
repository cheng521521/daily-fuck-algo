package tree;

/**
 * @author cpx
 * @Description 求二叉树的最长直径
 * @date 2022/8/14
 */
public class DiameterOfBinaryTree {
    int maxLength = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        travrse(root);
        return maxLength;
    }

    public int travrse(TreeNode root) {
        if (root == null){
            return 0;
        }
        int maxLeftLength = travrse(root.left);
        int maxRightLength = travrse(root.right);
        //后序位置顺便计算最大直径,走到这一步了没想出来
        int myDepth = maxLeftLength + maxRightLength;
        maxLength = Math.max(maxLength, myDepth);
        return 1 + Math.max(maxLeftLength, maxRightLength);
    }
}
