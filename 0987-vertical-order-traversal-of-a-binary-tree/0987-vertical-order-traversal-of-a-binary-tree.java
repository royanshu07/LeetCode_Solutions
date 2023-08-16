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
// class Pair{
//     TreeNode node;
//     int line;
// }
// class Solution {
//     public List<List<Integer>> verticalTraversal(TreeNode root) {
//         HashMap<Integer,List<Integer>> map = new HashMap<>();
//         Queue<Pair> q = new LinkedList<>();
//         Pair p = new Pair();
//         p.node = root;
//         p.line = 0;
//         q.add(p);
//         while(!q.isEmpty()){
//             Pair temp = q.poll();
//             List<Integer> temparr = new ArrayList<>();
//             temparr = map.getOrDefault(temp.line,temparr);
//             temparr.add(temp.node.val);
//             //Collections.sort(temparr);
//             map.put(temp.line,temparr);
//             if(temp.node.left!=null){
//                 Pair templeft = new Pair();
//                 templeft.node = temp.node.left;
//                 templeft.line =  temp.line -1;
//                 q.add(templeft);
                
                
//             }
//             if(temp.node.right!=null){
//                 Pair tempright = new Pair();
//                 tempright.node = temp.node.right;
//                 tempright.line =  temp.line+1;
//                 q.add(tempright);
                
                
//             }
            
//         }
//         Set<Integer> set = map.keySet();
//         ArrayList<Integer> sorted = new ArrayList<>(set);
//         Collections.sort(sorted);
//         List<List<Integer>> trav = new ArrayList<>();
//         for(int i:sorted){
//             trav.add(map.get(i));
//         }
//         return trav;
        
        
//     }
// }
class Solution {

    class Pair implements Comparable<Pair>{
        int data;
        int level;

        public Pair(int data,int level){
            this.data=data;
            this.level=level;
        }

        public int compareTo(Pair p2){
            if(this.level==p2.level)return this.data-p2.data;
            return this.level-p2.level;
        }
    }

    int min = 0;
    int max = Integer.MIN_VALUE;
    HashMap<Integer,PriorityQueue<Pair>>map = new HashMap<>();
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        helper(root,0,new Pair(root.val,0));

        for(int i=min;i<=max;i++){
            if(map.containsKey(i)){
                ArrayList<Integer>inList = new ArrayList<>();
                PriorityQueue<Pair>temp = map.get(i);
                while(!temp.isEmpty()){
                    inList.add(temp.remove().data);
                }
                list.add(inList);
            }
        }
        return list;
    }

    public void helper(TreeNode root,int dist,Pair p){
        if(root==null)return;

        if(map.containsKey(dist)){
            // map.put(dist,);
            map.get(dist).add(p);
        }
        else{
            PriorityQueue<Pair>pq = new PriorityQueue<Pair>();
            pq.add(p);
            map.put(dist,pq);
        }

        if(root.left!=null){
            min = Math.min(min,dist-1);
            helper(root.left,dist-1,new Pair(root.left.val,p.level+1));
        }
        if(root.right!=null){
            max = Math.max(max,dist+1);
            helper(root.right,dist+1,new Pair(root.right.val,p.level+1));
        }
    }
}