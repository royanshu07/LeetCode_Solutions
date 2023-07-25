class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            graph.add(temp);
        }
        for(int i = 0;i<prerequisites.length;i++){
             ArrayList<Integer> temp = graph.get(prerequisites[i][1]);
            temp.add(prerequisites[i][0]);
        }
        return notCyclic(graph);
    }
     public boolean notCyclic( ArrayList<ArrayList<Integer>> adj) {
       int count = 0;
       int[]indegree = new int[adj.size()];
       for(int i= 0;i<adj.size();i++){
           ArrayList<Integer> temp = adj.get(i);
           for(int j : temp){
               indegree[j]++;
           }
       }
       Queue<Integer> q = new LinkedList<>();
       for(int i = 0;i<indegree.length;i++){
           if(indegree[i]==0){
               q.add(i);
           }
       }
       
       while(!q.isEmpty()){
           int curr = q.poll();
           count++;
           ArrayList<Integer> temp = adj.get(curr);
           for(int i:temp){
               indegree[i]--;
               if(indegree[i]==0){
                   q.add(i);
               }
           }
       }
       if(count==adj.size()){
           return true;
       }
       return false;
    }
}