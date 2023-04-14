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

 class ans1{
    boolean isbal;
    int height;
}
class Solution {
  
public ans1 isBalhelp(TreeNode root){
    ans1 a = new ans1();
    ans1 aleft = new ans1();
    ans1 aright = new ans1();
   
    if(root==null){
         a.isbal = true;
         a.height =0;
         return a;
    }
    aleft = isBalhelp(root.left);
    aright = isBalhelp(root.right);
    if((Math.abs(aleft.height-aright.height)<=1)&&(aleft.isbal)&&(aright.isbal)){
        a.isbal = true;
    }
    a.height = Math.max(aleft.height,aright.height)+1;
    return a;
        
    
    
}
    
    
    
    public boolean isBalanced(TreeNode root) {
        ans1 a = isBalhelp(root);
        return a.isbal;
        
        
    }
}