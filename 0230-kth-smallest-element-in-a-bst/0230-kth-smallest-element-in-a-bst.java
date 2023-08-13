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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer>trav = new ArrayList<Integer>();
        return kthSmallest(root,k,trav);
    }
     public int kthSmallest(TreeNode root, int k,ArrayList<Integer>trav) {
         if(root==null){
             return Integer.MAX_VALUE;
         }
         int a = kthSmallest( root.left, k,trav);
         if(a!=Integer.MAX_VALUE){
             return a;
         }
         trav.add(root.val);
         if(trav.size()==k){
             return root.val;
         }
         a = kthSmallest( root.right, k,trav);
         return a;
      
    }
}