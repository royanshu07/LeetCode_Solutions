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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        rightSideView2( root,0, arr);
        return arr;
    }
    public void rightSideView2(TreeNode root,int level,List<Integer> trav) {
        if(root==null){
            return;
        }
        if(trav.size()==level){
            trav.add(root.val);
        }
        rightSideView2( root.right, level+1, trav);
         rightSideView2( root.left, level+1, trav);
        
        return;
        
    }
}