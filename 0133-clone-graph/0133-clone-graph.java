/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        HashMap<Node,Node> map = new HashMap<>();
        Node copynode = new Node();
        copynode.val = node.val;
        copynode.neighbors = new ArrayList<>();
        map.put(node,copynode);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            for(Node temp:curr.neighbors){
                if(!map.containsKey(temp)){
                    Node copytemp = new Node();
                    copytemp.val=temp.val;
                    copytemp.neighbors = new ArrayList<>();
                   // map.get(curr).neighbors.add(copytemp);
                    //copytemp.neighbors.add(map.get(curr));
                    queue.add(temp);
                    map.put(temp,copytemp);
                }
                map.get(curr).neighbors.add(map.get(temp));
            }
        }
        
        return copynode;
        
        
    }
}