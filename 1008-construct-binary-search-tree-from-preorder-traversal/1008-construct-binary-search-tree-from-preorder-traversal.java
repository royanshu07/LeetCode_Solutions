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
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder,0,preorder.length-1);
        
    }
    public TreeNode bstFromPreorder(int[] preorder,int i , int j) {
        if(i>j){
            return null;
        }
        System.out.println(preorder[i]+" "+i+" "+j);
        TreeNode root= new TreeNode();
        root.val = preorder[i];
        if(i==j){
            return root;
        }
        int leftend = i+1;
        while(leftend<=j){
            if(preorder[leftend]>preorder[i]){
                leftend--;
                break;
            }leftend++;
        }
        if(leftend>j){
            leftend=j;
        }
        root.left = bstFromPreorder(preorder,i+1,leftend);
        root.right = bstFromPreorder(preorder,leftend+1,j);
        return root;
    }
}