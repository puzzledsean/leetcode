import java.util.*;

public class Solution {
    int[] memoizedArray;
    public int coinChange(int[] coins, int amount) {
        memoizedArray = new int[amount+1];
        
        return dpCoinChange(coins, amount, memoizedArray);
    }
    
    public int dpCoinChange(int[] coins, int amount, int[] memoized){
        if(amount == 0){
            return 0;
        }
        
        //test out array of all possibilities of coin sums
        for(int i = 1; i <= amount; i++){
            memoized[i] = Integer.MAX_VALUE;
            
            //test out all values of coin array
            for(int j = 0; j < coins.length; j++){
                // System.out.println("i = " + i);
                // System.out.println("j = " + j);
                // System.out.println("coin[j] " + coins[j]);
                //System.out.println("printing memoized" + Arrays.toString(memoized));

                //Each value j of coin array must be <= i, the current coin sum
                //make sure memoized[i-coins[j]] + 1 is actually a better minimum
                //make sure memoized[i-coins[j]] != -1, because if it's -1 (used to indicate it was previously unreachable)
                    //then we certainly can't get i, the current sum
                if(coins[j] <= i && memoized[i-coins[j]] + 1 < memoized[i] && memoized[i-coins[j]] != -1){
                    memoized[i] = 1+memoized[i-coins[j]];
                }
            }

            //if memoized[i] never got changed, then it means it's impossible to reach
            if(memoized[i] == Integer.MAX_VALUE){
                memoized[i] = -1;
            }
        }
        
        return memoized[memoized.length-1];
    }
}