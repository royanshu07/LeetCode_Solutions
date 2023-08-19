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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
     public TreeNode buildTree(int[] inorder, int[] postorder,int instart,int inend , int postart , int poend) {
        
         
         if(instart>inend){
             return null;
         }TreeNode root = new TreeNode(postorder[poend]);
         if(instart==inend){
            return root;
        }
         int midin = -1;
         for(int i = instart;i<=inend;i++){
             if(postorder[poend]==inorder[i]){
                 midin = i;
                 break;
             }
         }
         int sizeleft = midin-instart;
         root.left = buildTree(inorder,postorder,instart,midin-1,postart,postart+sizeleft-1);
         root.right = buildTree(inorder,postorder,midin+1,inend,postart+sizeleft,poend-1);
         return root;
    }
}