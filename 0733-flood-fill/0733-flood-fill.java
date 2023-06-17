class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int no = image[sr][sc];
        color(image,color,sr, sc,no);
        return image;
    }
    public static void color(int[][]image,int color,int a , int b,int no){
        if(a<0||b<0||a>=image.length||b>=image[0].length){
            return;
        }
        if(image[a][b]!=no|| image[a][b]==color){
            return;
        }
        image[a][b]=color;
        color(image,color,a+1, b,no);
        color(image,color,a-1, b, no);
        color(image,color,a, b+1,no);
        color(image,color,a, b-1,no);

        return;
        
        
    }
}