class Solution {
    public boolean winnerOfGame(String colors) {
        int A = 0;
        int B = 0;
        int i = 1;
        //int curr = 1;
        
       while(i<colors.length()-1){
            if(colors.charAt(i)==colors.charAt(i-1)&&colors.charAt(i)==colors.charAt(i+1)){
             if(colors.charAt(i)=='A'){
                 A++;
             }
             else{
                 B++;
             }
                i++;
            }
            else{
                i++;
            }
        }
        if(A>B){
            return true;
        }
        return false;
        
    }
}