class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int l = 0, mid = 0, r = n - 1;

        while (mid <= r) {
            if (nums[mid] == 0) {
                int t = nums[mid];
                nums[mid] = nums[l];
                nums[l] = t;

                mid++;
                l++;
            }
            else if (nums[mid] == 1) {
                mid++;
            }
            else {
                int t = nums[mid];
                nums[mid] = nums[r];
                nums[r] = t;

                r--;
            }
        }
    }
}