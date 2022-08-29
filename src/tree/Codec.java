package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Codec
 * @Author jackchen
 * @Date 2022/8/29 12:40
 * @Description 二叉树的序列化
 **/
public class Codec {
    List<String> result = new ArrayList<>();
    // 把一棵二叉树序列化成字符串,使用前序遍历
    public void serialize(TreeNode root) {
        if (root == null) {
            result.add("#");
            return ;
        }
        result.add(String.valueOf(root.val));
        serialize(root.left);
        serialize(root.right);
    }

    // 把字符串反序列化成二叉树
    public TreeNode deserialize(List<String> result) {

    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(2);
        TreeNode rootLeft = new TreeNode(1);
        TreeNode rootRight = new TreeNode(3);
        root.left = rootLeft;
        root.right = rootRight;
        TreeNode root1 = new TreeNode(6);
        root.left.right = root1;
        codec.serialize(root);
        for (String s : codec.result) {
            System.out.print(s);
        }
    }
}
