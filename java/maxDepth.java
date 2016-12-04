public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null & root.right == null){
            return 1;
        }
        if(root.left != null && root.right == null){
            int leftSum = 1 + maxDepth(root.left);
            return leftSum;
        }
        if(root.left == null && root.right != null){
            int rightSum = 1 + maxDepth(root.right);
            return rightSum;
        }
        else{
            int leftSum = 1+maxDepth(root.left);
            int rightSum = 1+maxDepth(root.right);
            return Math.max(leftSum,rightSum);
        }
    }
}