class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
       
        
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        
        
        for(int i = 0;i<s.length();i++){
           if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stk.add(s.charAt(i));
                continue;
            }
            else if(!stk.isEmpty()&&map.get(s.charAt(i))==stk.peek()){
                stk.pop();
            }
            else{
                return false;
            }
            
        }
        
        if(stk.size()==0){
            return true;
        }
        return false;
        
    }
}