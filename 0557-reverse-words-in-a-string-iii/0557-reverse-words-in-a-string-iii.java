class Solution {
    public String reverseWords(String s) {
        int i = 0;
        int j = 0;
        String ans = ""; 
        for(int m = 0;m<s.length();m++){
           
            if(s.charAt(m)==' '){
                ans+=rev(s.substring(i,j));
                ans+=" ";
                i = m+1;
                
                    
            } j++;
        }
         ans+=rev(s.substring(i,j));
        return ans;
        
        
    }
    
    public String rev(String b){
        String ans = "";
        for(int i = 0;i<b.length();i++){
            ans=b.charAt(i)+ans;
        }
        return ans;
    }
}