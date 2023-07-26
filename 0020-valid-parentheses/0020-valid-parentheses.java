class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        List<Character> left = new ArrayList<>();
        
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        left.add('(');
        left.add('{');
        left.add('[');
        int count = 0;
        for(int i = 0;i<s.length();i++){
            if(left.contains(s.charAt(i))){
                stk.add(s.charAt(i));
            }
            else if(!stk.isEmpty()&&map.get(s.charAt(i))==stk.peek()){
                stk.pop();
            }
            else{
                count++;
            }
            
        }
        
        if(stk.size()==0&&count==0){
            return true;
        }
        return false;
        
    }
}