
class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int curr = 0;
        int max = 0;
        while(j<fruits.length){
            curr++;
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
            while(map.size()>2){
                curr--;
                int a = map.getOrDefault(fruits[i],0);
                if(a==1){
                    map.remove(fruits[i]);
                }
                else{
                    map.put(fruits[i],a-1);
                }
                i++;
            }
            
            max = Math.max(max,curr);
            j++;
        }
        return max;
        
        
    }
}