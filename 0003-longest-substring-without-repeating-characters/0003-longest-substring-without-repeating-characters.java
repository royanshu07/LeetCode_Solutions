class Solution {
    public int lengthOfLongestSubstring(String s) {
       int i = 0;
       int j = 0;
       HashMap<Character,Integer> map = new HashMap<>();
       int size = 0;
       while(j<s.length()){
           int a = map.getOrDefault(s.charAt(j),0);
           map.put(s.charAt(j),a+1);
           a++;
           if(a==1){
               
               if(size<j-i+1){
                 size=j-i+1;  
               }j++;
           }
             if(a>1){
               
                  while((map.get(s.charAt(j)))>1){
                    int b = map.get(s.charAt(i)); 
                   if(b>1){
                       map.put(s.charAt(i),a-1); 
                   
                   }
                   else{
                       map.remove(s.charAt(i));
                   }
                   i++;
               }
               j++;
           }  
            
       }
        return size;
        
    }
}