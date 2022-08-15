package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author cpx
 * @Description 层序遍历
 * @date 2022/8/15
 */
public class CengTree {

    List<List<Integer>> res = new ArrayList<>();

    public void ceng(TreeNode root) {
        if (root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            for (int i = 0; i < queue.size(); i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
    }

    //使用递归进行层序遍历，这种解法是一列一列遍历的
    List<List<Integer>> levelTraverse(TreeNode root) {
        if (root == null) {
            return res;
        }
        traverse(root, 0);
        return res;
    }

    private void traverse(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        //在前序遍历这里将遍历到的节点放入对应的层数
/*  我想的解法是通过一层里面的List size,但是list对与不存在的数据会报数组越界异常，没法处理，在单个List里面 size和isEmpty都可以运行，但是在 list嵌套List里面是不能用的。
if (res.get(depth).size() == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            res.add(list);
        } else {
            res.get(depth).add(root.val);
        }*/
        //网友想的
        if (res.size() <= depth){
            res.add(new LinkedList<>());
        }
        res.get(depth).add(root.val);
        traverse(root.left, depth +1);
        traverse(root.right, depth + 1);
    }
    //使用递归，用一层一层的方法
    List<List<Integer>> resNew = new ArrayList<>();
    List<List<Integer>> levelTraverseNew(TreeNode root) {
        if (root == null) {
            return resNew;
        }
        List<TreeNode> rootNode = new LinkedList<>();
        traverseNew(rootNode);
        return resNew;
    }

    private void traverseNew(List<TreeNode> rootNode) {
        if (rootNode.isEmpty()) {
            return;
        }
        List<Integer> nodeValue = new LinkedList<>();
        List<TreeNode> nextNode = new LinkedList<>();
        for (TreeNode treeNode : rootNode) {
            //这里我原来想把它放在for循环外面直接添加进去，但是我只考虑了从根节点开始的情况，并没有考虑到向下遍历会产生名义上的多个节点。
            //其实这里的关键点我认为是要把一层的节点看成一个单链表。所以这里才去要循环遍历，才能想到85行的操作。
            nodeValue.add(treeNode.val);
            if (treeNode.left != null) {
                nextNode.add(treeNode.left);
            }
            if (treeNode.right != null) {
                nextNode.add(treeNode.right);
            }
            // 前序位置添加结果，可以得到自顶向下的层序遍历
            res.add(nodeValue);
            traverseNew(nextNode);
            // 后序位置添加结果，可以得到自底向上的层序遍历结果
            // res.add(nodeValues);
        }
    }
}
