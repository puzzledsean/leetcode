public class Solution {
    public int rob(int[] nums) {
        //OPT(i) = Math.max(OPT(i-1), nums[i] + OPT(i-2))
        
        int[] OPT = new int[nums.length];
        
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        OPT[0] = nums[0];
        OPT[1] = Math.max(nums[0],nums[1]);
        
        for(int i = 2; i < nums.length; i++){
            OPT[i] = Math.max(OPT[i-1], nums[i] + OPT[i-2]);
        }
        
        return OPT[nums.length-1];
        
    }
}