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
      
        List<Integer> trav = new LinkedList<>();
          if(root==null){
            return trav;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        que.add(null);
        while(que.size()!=0){
            TreeNode temp = que.poll();
            if(temp==null){
                if(que.size()!=0){
                que.add(null);}
                continue;
            }
            if(que.peek()==null){
                trav.add(temp.val);
            }
            
           
            if(temp.left!=null){
                que.add(temp.left);
            }
            if(temp.right!=null){
                que.add(temp.right);
            }
        }
        
        return trav;
    }
}