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
    static int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        sum = Integer.MIN_VALUE;
        maxPathSum2( root);
        return sum;
        
    }
    public int maxPathSum2(TreeNode root) {
        if(root.left==null&&root.right==null){
            sum = Math.max(sum,root.val);
            return root.val;
        }
        if(root.left==null){
            int a = maxPathSum2(root.right);
            sum= Math.max(Math.max(root.val,sum),Math.max(a,a+root.val));
            return Math.max(root.val,a+root.val);
        }
          if(root.right==null){
            int a = maxPathSum2(root.left);
            sum= Math.max(Math.max(root.val,sum),Math.max(a,a+root.val));
            return Math.max(root.val,a+root.val);
        }
        int a = maxPathSum2(root.left);
        int b = maxPathSum2(root.right);
        
        int c  = Math.max(Math.max(a,b),Math.max(a+root.val,b+root.val));
        int d = Math.max(root.val,a+b+root.val);
        sum = Math.max(Math.max(c,d),sum);
        return Math.max(root.val,Math.max(a+root.val,b+root.val));
        
    }
}