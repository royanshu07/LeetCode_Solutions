import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int min = 0;
        int max = position[position.length - 1];
        
        while (min <= max) {
            
            int mid = min + (max - min) / 2;
            int last = callast(mid, position, m);
           // System.out.println(mid+" "+last);
            if (last >=1) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        
        return min-1;
    }
    
    public int callast(int dis, int[] arr, int numb) {
        int prev = arr[0];
        int currindex = 1;
        numb--;
        while (numb > 0) {
            if (currindex >= arr.length) {
                return numb;
            }
            if (Math.abs(prev - arr[currindex]) >= dis) {
                numb--;
                prev = arr[currindex];
            }
            currindex++;
        }
        return numb;
    }
}
