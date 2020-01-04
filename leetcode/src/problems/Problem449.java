package problems;

import java.util.Stack;

/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

        Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

        The encoded string should be as compact as possible.

        Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
*/

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
