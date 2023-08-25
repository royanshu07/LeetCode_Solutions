class Solution {
    // a b c a  b c 
    // 1 2 3 3  3 3        d =2 a b 
    // abc 
    // abca 
    // bca 
    // bcab
    // c a b 
    // ab ca b
    // ca bc 
    // abcab
    // bacb
    // a b c        
    public int numberOfSubstrings(String s) {
        int d = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        //int d= 0;
        int count = 0;
        while(j<s.length()){
              map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
              if(map.size()==3){
                  count++;
                  
              }
              count+=d;
              while(map.get(s.charAt(i))>1&&map.size()>=3){
                  map.put(s.charAt(i),map.get(s.charAt(i))-1);
                  i++;
                  d++;
                  count++;
              }
            j++;
        }
        return count;
        
    }
}