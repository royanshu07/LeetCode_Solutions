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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preStart]);

        if (preStart == preEnd) {
            return node;
        }

        int inIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                inIndex = i;
                break;
            }
        }

        int leftTreeSize = inIndex - inStart;

        node.left = buildTree(preorder, inorder, preStart + 1, preStart + leftTreeSize, inStart, inIndex - 1);
        node.right = buildTree(preorder, inorder, preStart + leftTreeSize + 1, preEnd, inIndex + 1, inEnd);

        return node;
    }
}
