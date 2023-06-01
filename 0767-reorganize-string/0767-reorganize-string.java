class Solution {
    public String reorganizeString(String s) {
        int m[]=new int[26];//Hashmap to store the frequency of each character
        int n=s.length();
        for(int i=0;i<n;i++)
            m[s.charAt(i)-'a']++;
        
        StringBuilder ans=new StringBuilder();
        int i=0;
        char prev='*';//Keep track of previous character
        while(i<n){
            int maxi=0,ind=0;
            //We traverse the entire hashmap to find the character with maximum count and not equal to previous character
            for(int j=0;j<26;j++){                
                if(m[j]>maxi&&prev!=(j+'a')&&m[j]>0){
                    maxi=m[j];
                    ind=j;
                }
            }
            if(maxi==0) return "";//If maxi is 0 then no solution can be made as suitable element not found
            prev=(char)(ind+'a');//Updating previous
            ans.append(prev);
            m[ind]--;  //Decreasing count from map since the character is done
            i++;
        }        
        return ans.toString();
    }
}
