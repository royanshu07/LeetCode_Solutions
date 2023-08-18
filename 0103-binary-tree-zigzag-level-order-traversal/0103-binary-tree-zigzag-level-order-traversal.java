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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      
        List<List<Integer>> out = new ArrayList<>();
        if(root==null){
            return out; 
        }        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int flag = 0;
        while(!q.isEmpty()){
            List<Integer> temp =new ArrayList<>();
            int size = q.size();
            for(int i = 0;i<size;i++){
                temp.add(0);
            }
            
               for(int i = 0;i<size;i++){
                   TreeNode node = q.poll();
                   if(flag==1){
                       temp.set(size-i-1,node.val);
                   }
                   else{
                   temp.set(i,node.val);}
                   if(node.left!=null){
                       q.add(node.left);
                   }
                   if(node.right!=null){
                       q.add(node.right);
                   }
                   
               }
            flag = 1-flag;
            out.add(temp);
            
            
        }
        return out;
        
    }
}