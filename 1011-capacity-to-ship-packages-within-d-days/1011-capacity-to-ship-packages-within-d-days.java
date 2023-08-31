class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();

        int sum = 0;
        for(int i:weights){
            sum+=i;
        }
        int heigh = sum;
        while(low<=heigh){
            int mid = (low+heigh)/2;
            int daytem = calday(weights,mid);
            if(daytem>days){
                low = mid+1;
            }
            else{
                heigh = mid-1;
            }
        }
        return low;
        
    }
    
    public int calday(int[]weights,int bar){
        int day = 1;
        int sum = 0;
        for(int i :weights){
            if(i>bar){
                return Integer.MAX_VALUE;
            }
            if(sum+i>bar){
                sum = i;
                day++;
            }
            else{
                sum = sum+i;
            }
            
        }
        return day;
    }
}