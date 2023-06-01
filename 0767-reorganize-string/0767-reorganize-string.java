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
        for(int i = 0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        
        PriorityQueue<Element> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<arr.length;i++){
            int freq = arr[i];
            if(freq!=0){
                Element e = new Element(((char)('a'+i)),freq);
                pq.add(e);
            }
        }
        char[]out = new char[s.length()];
        int size = 0;
        int pointer = 0;
        int skipmin = 0;
       
        Element e = pq.poll();
         int freq = e.freq;
        while(size<s.length()){
            if(freq<=0){
              e = pq.poll();
            freq = e.freq;}
            if(pointer>=s.length()){
                pointer = 0;
            }
            while(out[pointer]!='\0'){
                pointer++;
            }
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