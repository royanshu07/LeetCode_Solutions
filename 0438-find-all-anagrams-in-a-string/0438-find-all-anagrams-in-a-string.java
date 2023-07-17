// class Solution {
//     public List<Integer> findAnagrams(String s, String p) {
//         int[]temp = new int[26];
//         int[]map = new int[26];
//         for(int i = 0 ;i<p.length();i++){
//             temp[p.charAt(i)-'a']++;
//             //System.out.println(p.charAt(i)-'a'+" "+  temp[p.charAt(i)-'a']);
//         }
//         List<Integer> ans = new ArrayList<>();
//         int i = 0;
//         int j = 0;
//         int k = p.length();
//         while(j<s.length()){
//             map[s.charAt(j)-'a']++;
//             //System.out.println(s.charAt(j)-'a'+" "+ map[s.charAt(j)-'a']);
//             if(i-j+1<k){
//                 j++;
//             }
//             else{
//                boolean isequal = true;
//                for(int x = 0;x<p.length();x++){
//                    char c = p.charAt(x);
//                    if(temp[c-'a']!=map[c-'a']){
//                        isequal = false;
//                        break;
//                    }
                   
//                }
//                if(isequal){
//                    ans.add(i);
//                }
                   
//                 map[s.charAt(i)-'a']--;
//                 i++;
//                 j++;
//             }
//         }
//         return ans;
        
//     }
// }



class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] temp = new int[26];
        int[] map = new int[26];
        for (int i = 0; i < p.length(); i++) {
            temp[p.charAt(i) - 'a']++;
        }
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = p.length();
        while (j < s.length()) {
            map[s.charAt(j) - 'a']++;
            if (j - i + 1 < k) {
                j++;
            } else {
                // boolean isAnagram = true;
                // for (int x = 0; x < 26; x++) {
                //     if (temp[x] != map[x]) {
                //         isAnagram = false;
                //         break;
                //     }
                // }
                if (Arrays.equals(map,temp)) {
                    ans.add(i);
                }
                map[s.charAt(i) - 'a']--;
                i++;
                j++;
            }
        }
        return ans;
    }
}
