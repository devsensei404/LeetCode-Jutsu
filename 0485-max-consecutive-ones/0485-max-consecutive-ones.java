class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
       int c=0,c1=0;
       for(int i=0;i<nums.length;i++){
       if(nums[i]==0)
       {
        if(c1>c)
        c=c1;
        c1=0;
       }
       else
       c1++;
    }
    if(c1>c)
    c=c1;
    return c;
    }
}