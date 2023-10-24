class Solution {
    public boolean isPowerOfFour(int n) {
        int a = n;
        if(a==1){
            return true;
        }
        while(a>4){
         
            if(a%4!=0){
                return false;
            }
               a=a/4;
        }
        if(a==4){
            return true;
        }
        return false;
        
    }
}