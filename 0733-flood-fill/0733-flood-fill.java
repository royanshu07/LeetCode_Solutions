class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initial = image[sr][sc];
        dfs(image,sr,sc,color,initial);
        return image;
        
    }
    
    public static void dfs(int[][] image,int sr,int sc,int color, int initial){
        if(sr<0||sr>=image.length||sc<0||sc>=image[0].length){
            return;
        }
        if(image[sr][sc]!=initial||image[sr][sc]==color){
            return;
        }
        image[sr][sc]=color;
        dfs(image,sr+1,sc,color,initial);
        dfs(image,sr,sc+1,color,initial);
        dfs(image,sr-1,sc,color,initial);
        dfs(image,sr,sc-1,color,initial);
        return;
        
        
    }
}