class Element implements Comparable<Element>{
    char a;
    int freq;
    
    public Element(char a , int freq){
        this.a = a;
        this.freq = freq;
    }
     @Override
    public int compareTo(Element e) {
        return this.freq - e.freq;
    }
}

class Solution {
    public String reorganizeString(String s) {
        int[]arr = new  int[26];
        int reqlen=0;
        for(int i = 0;i<s.length();i++){
            
            arr[s.charAt(i)-'a']++;
            if(arr[s.charAt(i)-'a']==1){
                reqlen++;
            }
        }
        
        Element[]pq = new Element[reqlen];
        int size2=0;
        for(int i = 0;i<arr.length;i++){
            int freq = arr[i];
            if(freq!=0){
                Element e = new Element(((char)('a'+i)),freq);
                pq[size2]=e;
                size2++;
            }
        }
        Arrays.sort(pq, Collections.reverseOrder());
        char[]out = new char[s.length()];
        int size = 0;
        int pointer = 0;
        int pos  =0;
        Element e = pq[0];
         int freq = e.freq;
        while(size<s.length()){
            if(freq<=0){
                pos++;
              e = pq[pos];
            freq = e.freq;}
            if(pointer>=s.length()){
                pointer = 1;
            }
            // while(out[pointer]!='\0'){
            //     pointer++;
            // }
            while(pointer<s.length()&&freq>0){
                out[pointer]=e.a;
                size++;
                freq--;
                if(pointer>0&&out[pointer]==out[pointer-1]){
                    return "";
                }
                pointer = pointer+2;
                
            }
        }
        
        String outs="";
        for(char c:out){
            outs+=c;
            
        }
        
        return outs;
        
       
    }
}