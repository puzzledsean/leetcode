public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //BST solution
        if(root.val > p.val && root.val < q.val){
            return root;
        }
        else if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        else{
            return lowestCommonAncestor(root.right, p,q);
        }
        //binary tree solution
        // if(root == null){
        //     return null;
        // }
        // if(root.val == p.val || root.val == q.val){
        //     return root;
        // }
        
        // TreeNode left = lowestCommonAncestor(root.left, p, q);
        // TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // if(left == null && right == null){
        //     return null;
        // }
        // if(left != null && right != null){
        //     return root;
        // }
        // if(left == null && right != null){
        //     return right;
        // }
        // if(left != null && right == null){
        //     return left;
        // }
        
        // return null;
    }