class Solution {
    public int removeDuplicates(int[] arr) {
       int l = arr.length;
       int org = 0;
    int b = l;
    
      
       for(int i=0;i<l-1;i++){
           int j = i+1; //variable to check if next element is duplicate
           
           while((arr[i] ==arr[j])&&(j<l)){
               org++;
               for(int k =j;k<l-1;k++){
                   arr[k]=arr[k+1];
               }
              l--;
           }
       }
    
    
           
       
      
        return b-org;
        
        
    
    }
}