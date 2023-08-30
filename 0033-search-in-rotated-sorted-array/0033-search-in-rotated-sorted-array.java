class Solution {
    public int search(int[] arr, int target) {
        int i = 0;
        int j = arr.length-1;
        while(i<=j){
            int  mid = (i+j)/2;
            System.out.println(arr[mid]);
            if(arr[mid]==target){
                return mid;
            }
            if(arr[i]<=arr[mid]){
                if(target>=arr[i]&&target<=arr[mid]){
                   j= mid-1;
                }
                else{
                    i=mid+1;
                }
            }
            else{
               if(target>=arr[mid]&&target<=arr[j]){
                    i =mid+1;
                }
                else{
                    j = mid-1;
                } 
            }
        }
        return -1;
        
    }
}