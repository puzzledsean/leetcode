public class Solution {
    public int[] countBits(int num) {
        //curr(i) = numBits[closest_pow2(i)] + numBits[i - closest_pow2(i)]
        if(num == 0){
            return new int[]{0};
        }
        if(num == 1){
            return new int[]{0,1};
        }
        if(num == 2){
            return new int[]{0,1,1};
        }
        int[] numBits = new int[num+1];
        numBits[0] = 0;
        numBits[1] = 1;
        numBits[2] = 1;
        
        for(int i = 3; i < num+1; i++){
            //if currently a power of 2
            if((i & (i-1)) == 0){
                numBits[i] = numBits[i-closestPow2(i)];
            }
            else{
                numBits[i] = numBits[closestPow2(i)] + numBits[i-closestPow2(i)];
            }
        }
        return numBits;
    }
    
    //finds closest power 2 of given target (exclusive)
    //i.e. 16 would find 8, not 16
    public int closestPow2(int target){
        for(int i = 1; i < target; i++){
            if(Math.pow(2,i) >= target){
                return (int) Math.pow(2, i-1);
            } 
            else{
                continue;
            }
        }
        return 0;
    }
}