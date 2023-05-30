class Solution {
    public int minimumSum(int num) {
         ArrayList<Integer> arr = new ArrayList<Integer>();
         while(num>0){
             arr.add(num%10);
             num = num/10;
         }
        int a = 0;
        int b= 0;
        int i = 0;
        Collections.sort(arr);
        while(i<arr.size()-1){
            a= a*10+arr.get(i);
            i++;
            b= b*10+arr.get(i);
            i++;
            
        }
        
        return a+b;
         
        
    }
}