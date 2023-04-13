// 1 2 3 4
// 1 2 3 4 5
// h e l l o
// len = 5; loop-(0, 2); 

class Solution {
    
    public void reverseString(char[] s) {
        int len = s.length;
        int i =0;
        int j = len-1;
        while(i<j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
            
        
        }
        
        
        
    }
