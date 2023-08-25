// class Solution {
//     public String minWindow(String s, String t) {
//         HashMap<Character,Integer> mapt = new HashMap<>();
//         HashMap<Character,Integer> maps= new HashMap<>();
//         for(int i = 0;i<t.length();i++){
//             mapt.put(t.charAt(i),mapt.getOrDefault(t.charAt(i),0)+1);
            
//         }
//         int i = 0;
//         int j = 0;
//         String str = "";
//         int minlen = (int)(1e9);
//         int n = 0;
//         while(j<s.length()){
//             char c = s.charAt(j);
//             if(mapt.containsKey(c)){
//                 maps.put(c,maps.getOrDefault(c,0)+1);
//                 if(mapt.get(c)==maps.get(c)){
//                     n++;
//                 }
//             }
//             if(n==mapt.size()){
//                 if(minlen>j-i+1){
//                     str= s.substring(i,j+1);
//                     minlen = j-i+1;
//                 }
//                 while(maps.size()==mapt.size()){
//                     if(!maps.containsKey(s.charAt(i))||maps.get(s.charAt(i))>mapt.getOrDefault(s.charAt(i),0)){
//                        if(maps.containsKey(s.charAt(i))){
//                         maps.put(s.charAt(i),maps.get(s.charAt(i))-1);}
//                         i++;
                       
//                     }
//                     else{
//                         break;
//                     }
//                      if(minlen>j-i+1){
//                     str= s.substring(i,j+1);
//                          minlen = j-i+1;
//                 }
//                 }
              
//             }  j++;
//         }
//         return str;
//     }
// }

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer>h1=new HashMap<>();
        int i=0;
        int j=0;
        int c=0;
        String ans="";
        for(int i1=0;i1<t.length();i1++){
            char a=t.charAt(i1);
            int p=h1.getOrDefault(a,0);
            h1.put(a,p+1);
        }
        int n=t.length();
        int cnt=0;
         HashMap<Character,Integer>h2=new HashMap<>();
        while(i<s.length()){
            char ch=s.charAt(i);
            h2.put(ch,h2.getOrDefault(ch,0)+1);
            if(h2.get(ch)<=h1.getOrDefault(ch,0))cnt++;
            if(cnt==n){
               while(j<=i&&cnt==n){
                   if(ans.equals("")||ans.length()>i-j+1)ans=( s.substring(j,i+1));
                   char p=s.charAt(j);
                   if(h2.get(p)==1)h2.remove(p);
                   else h2.put(p,h2.get(p)-1);
                   if(h2.getOrDefault(p,0)<h1.getOrDefault(p,0))cnt--;
                   j++;
               }
            }
            i++;
        }
        return ans;
    }
}