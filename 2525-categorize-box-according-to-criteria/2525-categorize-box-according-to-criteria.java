class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        int a = 0;
        int b = 0;
        long  n = Math.abs(10*10*10*10);
        if(length>=n||width>=n||height>=n||mass>=n){
            a=1;
        }
        long c = Math.abs((length*width)); 
        c = Math.abs(c*height);
        int d =Math.abs(10*10*10*10*10*10*10*10*10);
        //System.out.println(c);
       //System.out.print(d);
        if( c>=d){
             a=1;
        }
        if(mass>=100){
           b=1;
        }
        if((a==0)&&(b==0)){
            return "Neither";
        }
        if((a==1)&&(b==1)){
            return "Both";
        }
        if((a==1)){
            return "Bulky";
        }
        
        return "Heavy";
        
    }
}