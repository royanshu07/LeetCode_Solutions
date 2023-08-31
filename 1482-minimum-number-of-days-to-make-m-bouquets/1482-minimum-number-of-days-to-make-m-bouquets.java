

class Solution {
    public int minDays(int[] bloomDay, int m, int n) {
        int mod = 1000000007;
        long mn = (m*n)%mod;
       
        if(m>bloomDay.length||n>bloomDay.length||mn>bloomDay.length){
            return -1;
        }
        int i = Integer.MAX_VALUE;
        int j = Integer.MIN_VALUE;
        for(int k:bloomDay){
            if(i>k){
                i=k;
            }
            if(j<k){
                j = k;
            }
        }
        while(i<=j){
            int mid = (i+j)/2;
            int bq = calbq(mid,bloomDay,n);
            //System.out.println(mid+" "+bq);
            if(bq>=m){
                j = mid-1;
            }
            else{
                i = mid+1;
            }
        }
        return i;
        
    }
    
    public int calbq(int day,int[]arr,int size){
        int count = 0;
        int curr = 0;
        for(int i :arr){
            if(i<=day){
                curr++;
            }
            
            if(i>day){
                count+=curr/size;
                curr=0;
            }
        }
        count+=curr/size;
        return count;
    }
    
}