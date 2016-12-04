# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        
        if root == None:
            return None
        #check if current root is equal to one of the values, if it is, return early because it must be an LCA
        if root.val == p.val or root.val == q.val:
            return root
        #LCA must lie in right subtree     
        if p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q)
        #LCA must lie in left subtree
        elif p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        #otherwise, it must be the root, because one value lies in left subtree and one value lies in right subtree, therefore, LCA will be current node
        return root