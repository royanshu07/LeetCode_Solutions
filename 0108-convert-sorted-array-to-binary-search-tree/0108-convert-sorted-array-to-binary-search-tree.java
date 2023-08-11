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
    public TreeNode sortedArrayToBST(int[] nums) {
       return sortedArrayToBST(nums,0,nums.length-1); 
        
    }
     public TreeNode sortedArrayToBST(int[] nums,int start,int end) {
        if(start>end){
            return null;
        }
        
        TreeNode root = new TreeNode();
        int mid = (start+end)/2;
        root.val = nums[mid];
        if(start==end){
            return root;
        }
        root.left = sortedArrayToBST(nums,start,mid-1);
        root.right = sortedArrayToBST(nums,mid+1,end);
        return root;
        
        
    }
        
        
    
}