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
     static int diameter = 0;
     public int diameterOfBinaryTree(TreeNode root) {
         diameter = 0;
         diameterOfBinaryTree2(root);
         return diameter;
     }
         
    public int diameterOfBinaryTree2(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = diameterOfBinaryTree2(root.left);
        int right = diameterOfBinaryTree2(root.right);
        diameter = Math.max(diameter,left+right);
        return Math.max(left+1,right+1);
        
        
        
    }
}