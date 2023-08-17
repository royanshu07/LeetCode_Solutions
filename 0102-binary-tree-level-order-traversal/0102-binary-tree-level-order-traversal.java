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
    public List<List<Integer>> levelOrder(TreeNode root) {
         List<List<Integer>> out = new ArrayList<>();
         Queue<TreeNode> q = new LinkedList<>();
         if(root==null){
             return out;
         }
         q.add(root);
         q.add(null);
         List<Integer> temp = new ArrayList<>();
         while(!q.isEmpty()){
             TreeNode tempnode = q.poll();
             if(tempnode==null){
                 out.add(temp);
                 temp = new ArrayList<>();
                 if(q.size()!=0){
                     q.add(null);
                 }
                 continue;
             }
             temp.add(tempnode.val);
             if(tempnode.left!=null){
                 q.add(tempnode.left);
             }
             if(tempnode.right!=null){
                 q.add(tempnode.right);
             }
         }
        return out;
        
    }
}