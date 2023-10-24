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

    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            while (size -- > 0) {
                TreeNode rem = q.remove();
                max = Math.max(max, rem.val);

                if (rem.left != null) q.add(rem.left);
                if (rem.right != null) q.add(rem.right);
            }
            res.add(max);
        }
        return res;
    }
}