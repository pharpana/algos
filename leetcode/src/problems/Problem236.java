package problems;

public class Problem236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || root==p || root==q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right !=null) return root;
        if(left == null && right == null) return null;

        return left!=null ? left : right;
    }

    public static void main(String[] args){
        Problem236 problem = new Problem236();

        TreeNode root = new TreeNode();root.val = 5;
        TreeNode left = new TreeNode();left.val = 6;
        TreeNode right = new TreeNode();right.val = 9;
        root.left = left;
        root.right = right;

        System.out.println(problem.lowestCommonAncestor(root, left, right).val);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}

