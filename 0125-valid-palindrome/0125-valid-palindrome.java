class Solution {
    public boolean isPalindrome(String s) {
        String check = "";
        int len = s.length();
        for(int i = 0;i<len;i++){
            if((s.charAt(i)>='a'&&s.charAt(i)<='z')||(s.charAt(i)>='A'&&s.charAt(i)<='Z')||(s.charAt(i)>='0'&& s.charAt(i)<='9')){      
                check = check +Character.toLowerCase(s.charAt(i));

            }
        }
        //System.out.print(check);
        int len2 = check.length();
        for(int i = 0;i<(len2/2);i++){
            if(check.charAt(i)!=check.charAt(len2-i-1)){
                return false;
            }
        }
        return true;
    }
}