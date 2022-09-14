package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author cpx
 * @Description 寻找重复的子树 Leetcode652
 * @date 2022/9/14
 */
public class FindDuplicateSubtrees {

    private Map<String,Integer> result = new HashMap<>();

    private LinkedList<TreeNode> list = new LinkedList<>();

    List<TreeNode> findDuplicateSubtrees(TreeNode root){
        traverse(root);
        return list;
    }

    String traverse(TreeNode root) {
        if (root == null) {
            return "*";
        }

        //前序遍历
        String left = traverse(root.left);//得到左子树
        //中序遍历
        String right = traverse(root.right);//得到右子树
        //后序遍历
        String subTree = left + "," + right+ "," + root.val;
        if (result.containsKey(subTree)) {
            if (result.get(subTree) == 1) {
                list.add(root);
            }
            result.put(subTree, result.get(subTree) +1);
        } else {
            result.put(subTree,1);
        }
        return subTree;
    }

}
