class Solution {
    public int fib(int n) {
        if(n==0){
            return 0;
        }
        int a = 0;
        int b = 1;
        int sum = b;
        for(int i = 2;i<=n;i++){
            sum = a+b;
            a=b;
            b=sum;
        }
        return sum;
    }
}