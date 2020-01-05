package problems;

/*

124. Binary Tree Maximum Path Sum

Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42

 */

public class Problem124 {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Output output = new Output();
        pathSum(root, output);

        return output.maxPathSum;
    }


    public int pathSum(TreeNode root, Output output) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(pathSum(root.left, output), 0);
        int right = Math.max(pathSum(root.right, output), 0);

        int pricePath = root.val + left + right;
        output.maxPathSum = Math.max(pricePath, output.maxPathSum);

        return root.val + Math.max(left, right);
    }

}

class Output {
    int maxPathSum = Integer.MIN_VALUE;
}