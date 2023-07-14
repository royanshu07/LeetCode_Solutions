class Solution {
    
    public boolean range(int i ,int j,int m , int n){
        if(i>=0&&j>=0&&i<m&&j<n){
            return true;
        }
        return false;
    }
    
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;        

        int count =  m*n; 
        int[][]ans = new int[mat.length][mat[0].length];
        for(int i = 0;i<mat.length;i++){
            Arrays.fill(ans[i],-1);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<mat.length;i++){
            for(int j = 0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    ans[i][j]=0;
                    q.add(i);
                    q.add(j);
                    count--;
                }
            }
        }
        while(!q.isEmpty()||count>0){
            int i = q.poll();
            int j = q.poll();
            int val = ans[i][j];
            if(range(i+1,j,m,n)&&ans[i+1][j]==-1){
                ans[i+1][j]=val+1;
                q.add(i+1);
                q.add(j);
                count--;
            }
            if(range(i,j+1,m,n)&&ans[i][j+1]==-1){
                ans[i][j+1]=val+1;
                q.add(i);
                q.add(j+1);
                count--;
                
            }
            if(range(i-1,j,m,n)&&ans[i-1][j]==-1){
                 ans[i-1][j]=val+1;
                q.add(i-1);
                q.add(j);
                count--;
                
            }
            if(range(i,j-1,m,n)&&ans[i][j-1]==-1){
               ans[i][j-1]=val+1;
                q.add(i);
                q.add(j-1);
                count--;
                 
            }
        }
        return ans;
        
    }
}