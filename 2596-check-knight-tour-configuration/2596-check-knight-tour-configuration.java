class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0]!=0){
            return false;
        }
        return checkValidGrid( grid,0 , 0,0);
    }
    public boolean checkValidGrid(int[][] grid,int a , int b,int n) {
        if((n>=(grid.length*grid.length)-1)){
             
            return true;
        }
        if(a<0||b<0||a>=grid.length||b>=grid.length){
            
            return false;
        }
       
         if((check(grid,a-2, b-1,n+1))){
              
          return checkValidGrid( grid,a-2, b-1,n+1); 
        }
        if(check(grid,a+2, b-1,n+1)){
            
          return checkValidGrid( grid,a+2, b-1,n+1);  
        }
        if(check(grid,a-2, b+1,n+1)){
             // System.out.println(a+" "+b+"3");
             //  System.out.println(n);
            return checkValidGrid( grid,a-2, b+1,n+1);  
        }
        if(check(grid,a+2, b+1,n+1)){
             // System.out.println(a+" "+b+"4");
             //  System.out.println(n);
            return  checkValidGrid( grid,a+2, b+1,n+1); 
        }
        

         if(check(grid,a-1, b-2,n+1)){
              // System.out.println(a+" "+b+"5");
              // System.out.println(n);
            return checkValidGrid( grid,a-1, b-2,n+1); 
        }
         if(check(grid,a-1, b+2,n+1)){
              // System.out.println(a+" "+b+" 6");
              // System.out.println(n);
            return checkValidGrid( grid,a-1, b+2,n+1); 
        }
         if(check(grid,a+1, b-2,n+1)){
              // System.out.println(a+" "+b+"7");
              // System.out.println(n);
            return checkValidGrid( grid,a+1, b-2,n+1); 
        }
         if(check(grid,a+1, b+2,n+1)){
              // System.out.println(a+" "+b+"8");
              // System.out.println(n);
            return checkValidGrid( grid,a+1, b+2,n+1); 
        }
        
      
        return false;
    }
           
    public static boolean check(int[][]grid,int a , int b,int n){
       
        if(a<0||b<0||a>=grid.length||b>=grid.length){
           return false;}
         
        if(grid[a][b]==n){
           // System.out.println(a+" "+b);
           // System.out.println(n);
            return true;
        }
        return false;
       
    }
}