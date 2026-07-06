class Solution {
    public int missingNumber(int[] nums) {
        int s=(nums.length*(nums.length+1))/2;
        for(int i=0;i<nums.length;i++)
        s=s-nums[i];
        return s;
    }
}