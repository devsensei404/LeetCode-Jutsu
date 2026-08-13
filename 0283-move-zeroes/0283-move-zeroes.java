class Solution {
    public void moveZeroes(int[] nums) {
        int l=0,r=0,n=nums.length;
        while(l<=r && r<n){
        if (nums[r]!=0){
            nums[l++]=nums[r];
        }
        r++;}
        for(int i=l;i<n;i++)
        nums[i]=0;
        
           }
}