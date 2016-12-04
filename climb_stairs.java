public class Solution {
    public int climbStairs(int n) {
        /*
        OPT(n) = {
            0 if n == 0
            (OPT(n-1) + OPT(n-2))
        }
        */
        //1111 112 211 121 22 -> n=4
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }  
        if(n == 2){
            return 2;
        }
        
        int[] stairs = new int[n+1];
        stairs[0] = 0;
        stairs[1] = 1;
        stairs[2] = 2;
        
        for(int i = 3; i < n+1; i++){
            stairs[i] = stairs[i-1] + stairs[i-2];
        }
        
        return stairs[n];
    }
}