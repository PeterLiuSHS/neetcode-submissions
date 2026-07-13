/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidate(root, -1005, 1005);
    }

    private boolean isValidate(TreeNode root, int min, int max) {
        while (root != null) {
            if (root.val > min && root.val < max) {
                return isValidate(root.left, min, root.val)
                    && isValidate(root.right, root.val, max);
            } else {
                return false;
            }
        }
        return true;
    }
}
