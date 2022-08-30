package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    //从中序和后序遍历构造二叉树
    TreeNode buildTreee(int[] inorder, int[] postorder) {
        return travel(inorder,0,inorder.length-1,
                postorder,0,postorder.length-1);
    }

    TreeNode travel(int[] inorder, int start_in, int end_in,
                    int[] postorder, int start_po, int end_po) {
        //base case
        if (start_in > end_in)return null;
        int rootValue = postorder[end_po];
        int rootIndex = Integer.MIN_VALUE;
        for (int i = start_in; i < end_in; i++) {
            if (rootValue == inorder[i]) {
                rootIndex = i;
                break;
            }
        }
        //这里为什么要用leftSize？假如不用leftSize,我用的是rootIndex。因为rootIndex只是在中序中的rootIndex.后序是描述不出来的
        int leftSize = rootIndex - start_in;
        TreeNode root = new TreeNode(rootValue);
        //这里变量的意义在于你要构建左子树，那么就要要描述出来中序和后序的左子树
        root.left = travel(inorder, start_in, rootIndex -1,
                postorder, start_po, start_po + leftSize - 1);
        root.right = travel(inorder, rootIndex +1, end_in,
                postorder, start_po + leftSize, end_po-1);
        return root;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
    }
}
