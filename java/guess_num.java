/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        //binary search, O(log(n)) runtime
        int low = 1;
        int high = n;
        int mid = (low+high)/2;
        
        while(low<=high){
            mid = low + (high - low) / 2;

            //consider upper half
            if(guess(mid) == 1){
                low = mid+1; 
            }
            else if(guess(mid) == -1){
                high = mid-1;
            }
            else{
                return mid;
            }
        }
        return mid;
        
        
        //O(sqrt(n)) runtime, algorithm from ladder dropping problem
        
        // int interval = (int) Math.sqrt(n);
        // //System.out.println("interval" + interval);
        // //ex: 
        // //49 = n
        // //14
        // //13 = number picked
        // //7
        // for(int i = 1; i <= interval+1; i++){
        //     //System.out.println("interval*i" + interval*i);
        //     if(guess(interval * i) == 0){
        //         return i*interval;
        //     }
        //     else if(guess(interval*i) == 1){
        //         continue;
        //     }
            
        //     //if it's below interval*i, it must be between
        //     //intervali * (i-1) and interval * i,
        //     //so check by intervals of 1
        //     else{
        //         for(int j = interval*(i-1); j < (interval*i) ; j++){
        //             if(guess(j) == 0){
        //                 return j;
        //             }
        //         }
        //     }
        // }
        // return n;
    }
}