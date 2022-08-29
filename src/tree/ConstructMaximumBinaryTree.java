package tree;

import java.time.temporal.ValueRange;

/**
 * @author cpx
 * @Description
 * @date 2022/8/25
 * 构造最大二叉树
 */
public class ConstructMaximumBinaryTree {
    TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums,0,nums.length-1);
    }
    TreeNode build(int[] nums, int lo, int hi) {
        //Base case 数组不能为空
        if (lo > hi) {
            return null;
        }
        //先找见最大值并且构建根节点
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = build(nums,lo,index -1);
        root.right= build(nums,index+1,hi);
        return root;
    }
}
