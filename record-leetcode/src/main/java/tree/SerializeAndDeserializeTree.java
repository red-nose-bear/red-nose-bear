package tree;

import tree.base.TreeNode;

/**
 * 二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * -----------
 * 思路：根据前序遍历规则完成序列化与反序列化。所谓序列化指的是遍历二叉树为字符串；所谓反序列化指的是依据字符串重新构造成二叉树。依据前序遍历序列来序列化二叉树，
 * 因为前序遍历序列是从根结点开始的。当在遍历二叉树时碰到Null指针时，这些Null指针被序列化为一个特殊的字符“#”。另外，结点之间的数值用逗号隔开。
 * -----------
 */

public class SerializeAndDeserializeTree {

    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val).append(",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    int index = -1;
    TreeNode Deserialize(String str) {
        index++;
        String[] strArr = str.split(",");
        if (index >= strArr.length)
            return null;
        TreeNode node = null;
        if (!"#".equals(strArr[index])) {
            // 叶子节点
            node = new TreeNode(Integer.parseInt(strArr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeTree serializeAndDeserializeTree = new SerializeAndDeserializeTree();
        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(2);
        s.right = new TreeNode(3);
        s.left.left = new TreeNode(4);
        s.left.right = new TreeNode(5);
        s.right.left = new TreeNode(6);
        s.right.right = new TreeNode(7);
        String s1 = serializeAndDeserializeTree.Serialize(s);
        System.out.print("-------------");
        serializeAndDeserializeTree.Deserialize(s1);
        System.out.print("-------------");
    }

}
