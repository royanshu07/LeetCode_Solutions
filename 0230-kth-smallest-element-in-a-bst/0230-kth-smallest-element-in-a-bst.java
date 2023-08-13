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
    static int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        //ArrayList<Integer>trav = new ArrayList<Integer>();
        count=0;
        return kthSmallest2(root,k);
    }
     public int kthSmallest2(TreeNode root, int k) {
         if(root==null){
             return Integer.MAX_VALUE;
         }
         int a = kthSmallest2( root.left, k);
         if(a!=Integer.MAX_VALUE){
             return a;
         }
         count++;
         if(count==k){
             return root.val;
         }
         a = kthSmallest2( root.right, k);
         //System.out.println(count+" "+root.val);
         return a;
      
    }
}