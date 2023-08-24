
class Solution {
    public int characterReplacement(String s, int k) {
        int[]arr = new int[26];
        int i = 0;
        int j = 0;
        int currlen = 0;
        int maxlen = 0;
        while(j<s.length()){
            arr[s.charAt(j)-'A']++;
            currlen++;
            int maxfreqelem = max1(arr);
            int maxfreq = arr[maxfreqelem];
            int otherchar = currlen-maxfreq;
            while(otherchar>k){
                arr[s.charAt(i)-'A']--;
                maxfreqelem = max1(arr);
                maxfreq = arr[maxfreqelem];
                currlen--;
                otherchar = currlen-maxfreq;
                i++;
                
            }
            maxlen = Math.max(maxlen,currlen);
            j++;
        }
        return maxlen;
        
    }
    public int max1(int[]arr){
        int i = 0;
        int max =arr[i];
        for(int j = 0;j<arr.length;j++){
            if(arr[j]>max){
                max = arr[j];
                i = j;
            }
        }
        return i;
    }
}