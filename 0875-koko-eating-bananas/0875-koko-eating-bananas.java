class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int max=piles[0];
        for(int i=0;i<piles.length;i++){
            max=Math.max(max,piles[i]);
        }
        
        if(h==piles.length)
            return max;
        
        int low=1;
        int high=max;
        int speed=Integer.MIN_VALUE;;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if(isPossible(piles,h,mid)){
                speed=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return speed;
    }
    
    public boolean isPossible(int[] piles,int h,int sp){
        int totaltime=0;
        
        for(int i=0;i<piles.length;i++){
            totaltime+=Math.ceil((piles[i]*1.0)/sp);
        }
        
       return totaltime<=h;
        
        
    }
}