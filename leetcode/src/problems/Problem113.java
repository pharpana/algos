package problems;
/*

Path Sum II

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]

 */

import java.util.ArrayList;
import java.util.List;

public class Problem113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> nodes = new ArrayList<>();
        pathSum(root, sum, nodes, result);

        return result;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> nodes, List<List<Integer>> result) {
        if(root == null) return;

        if(sum == root.val && root.left==null && root.right==null) {
            //nodes.add(root.val);
            List<Integer> list = new ArrayList<>(nodes);
            list.add(root.val);
            result.add(list);
        } else {
            nodes.add(root.val);
            pathSum(root.left, sum-root.val, nodes, result);
            pathSum(root.right, sum-root.val, nodes, result);
            nodes.remove(nodes.size()-1);
        }
    }

}
