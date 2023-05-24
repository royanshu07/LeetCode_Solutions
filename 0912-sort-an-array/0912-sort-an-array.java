class Solution {
    
        
    
   public int[] sortArray(int[] nums) {
		int len = nums.length;
		for(int i = len/2;i>=0;i--){
			downheapify(nums,i,len);
		}

		int size = len;
	
			while(size>1){
			int temp = nums[size-1];
			nums[size-1]= nums[0];
			nums[0]=temp;
			size--;
			downheapify(nums,0,size);
			
		}
       return nums;
		
	}

	public static void downheapify(int[]arr,int start , int end){
		int parent = start;
		int leftchild = 2*parent+1;
		int rightchild = leftchild+1;
		int minindex = parent;
		while(leftchild<end){
            if(arr[leftchild]>arr[minindex]){
				minindex = leftchild;
			}
			if(rightchild<end&&(arr[rightchild]>arr[minindex])){
				minindex = rightchild;
			}
			if(minindex == parent){
				return;
			}
			int temp = arr[minindex];
			arr[minindex]= arr[parent];
			arr[parent ]= temp;
			parent = minindex;
			leftchild= parent*2+1;
			rightchild= leftchild+1;
		}

	}

}
 
