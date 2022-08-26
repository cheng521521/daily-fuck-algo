package tree;

import java.util.HashMap;

/**
 * @ClassName BuildTree
 * @Author jackchen
 * @Date 2022/8/26 18:36
 * @Description 从前序和中序遍历构造二叉树
 **/
public class BuildTree {
    HashMap<Integer, Integer> valToIndex = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildNode(preorder, 0, preorder.length-1,
                inorder,0, inorder.length-1);
    }


    TreeNode buildNode(int[] preorder, int preStart, int preEnd,
                       int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        //根节点的值
        int rootValue = preorder[preStart];
        //根节点在中序遍历中的值
        int index = 0;
        for (int i = inStart; i <= inEnd ; i++) {
            if (inorder[i] == rootValue) {
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootValue);
        // 递归构造左右子树
        root.left = buildNode(preorder, preStart +1, preStart + leftSize,
                inorder, inStart, index -1);

        root.right = buildNode(preorder, preStart + leftSize + 1, preEnd,
                inorder, index +1, inEnd);
        return root;
    }
}
