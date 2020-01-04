package problems;

import java.util.Stack;

public class Problem449 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        return sb.substring(0, sb.length()-1);
    }

    public void postOrder(TreeNode root, StringBuilder sb){
        if(root == null) return;
        postOrder(root.left, sb);
        postOrder(root.right, sb);
        sb.append(root.val);
        sb.append(" ");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty())
            return null;

        Stack<Integer> stack = new Stack<>();
        for(String s : data.split("\\s+")){
            stack.push(Integer.parseInt(s));
        }
        return deserialize(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
    }

    public TreeNode deserialize(int low, int high, Stack<Integer> stack) {
        if(stack.isEmpty()) return null;
        int val = stack.peek();
        if(val<low || val>high) return null;

        stack.pop();
        TreeNode node = new TreeNode(val);
        node.right = deserialize(val, high, stack);
        node.left = deserialize(low, val, stack);

        return node;
    }
}
