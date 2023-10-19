class Solution {
    public boolean backspaceCompare(String s, String t) {
       Stack <Character> snew = new Stack<>();
        Stack<Character> tnew = new Stack<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='#'&&snew.size()>0){
                snew.pop();
            }
            else if(s.charAt(i)!='#'){
                snew.add(s.charAt(i));
            }
        }
        for(int i = 0;i<t.length();i++){
            if(t.charAt(i)=='#'&&tnew.size()>0){
                tnew.pop();
            }
            else if(t.charAt(i)!='#'){
                tnew.add(t.charAt(i));
            }
        }
        
        if(snew.equals(tnew)){
            return true;
        }
        
        return false;
        
        
    }
}