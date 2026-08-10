class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i <= n - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int sum = -nums[i];
            int l = i + 1, r = n - 1;

            while (l < r) {

                if (nums[l] + nums[r] > sum)
                    r--;

                else if (nums[l] + nums[r] < sum)
                    l++;

                else {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    l++;
                    r--;

                    while (l < r && nums[l] == nums[l - 1])
                        l++;

                    while (l < r && nums[r] == nums[r + 1])
                        r--;
                }
            }
        }

        return ans;
    }
}