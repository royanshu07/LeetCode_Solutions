
class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1)
                indegree[leftChild[i]]++;
            if (rightChild[i] != -1)
                indegree[rightChild[i]]++;
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                root = i;
        }
        if (root == -1)
            return false;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (visited[node])
                return false;
            visited[node] = true;
            if (leftChild[node] != -1)
                queue.add(leftChild[node]);
            if (rightChild[node] != -1)
                queue.add(rightChild[node]);
        }
        int trueCount = 0;
        for (boolean b : visited) {
            if (b)
                trueCount++;
        }
        return trueCount == n;
    }}
// class Solution {
//     public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
//         int[]visited = new int[n];
//         Queue<Integer> q = new LinkedList<>();
//         q.add(0);
//         while(!q.isEmpty()){
//             int a = q.poll();
//             if(visited[a]==1){
//                 return false;
//             }
            
//             visited[a]=1;
            
//             if(leftChild[a]!=-1&&visited[leftChild[a]]==1){
//                 return false;
//             }
//             if(rightChild[a]!=-1&&visited[rightChild[a]]==1){
//                 return false;
//             }
//             if(leftChild[a]!=-1){
//                 q.add(leftChild[a]);
//             }
//             if(rightChild[a]!=-1){
//                 q.add(rightChild[a]);
//             }
//         }
//         return true;
        
//     }
// }