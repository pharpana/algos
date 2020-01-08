package problems;

import java.util.*;

public class Problem103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        List<List<Integer>> result = new ArrayList<>();
        if(root == null )
            return result;

        stack1.push(root);

        while(!stack1.isEmpty() || !stack2.isEmpty()){

            List<Integer> levelList = new ArrayList<>();
            while(!stack1.isEmpty()){
                TreeNode node = stack1.pop();

                if(node.left!=null) stack2.push(node.left);
                if(node.right != null) stack2.push(node.right);
                levelList.add(node.val);
            }

            if(levelList.size() > 0) result.add(levelList);
            levelList = new ArrayList<>();
            while(!stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                if(node.right!=null) stack1.push(node.right);
                if(node.left != null) stack1.push(node.left);
                levelList.add(node.val);
            }
            if(levelList.size() > 0) result.add(levelList);
        }

        return result;
    }

}
