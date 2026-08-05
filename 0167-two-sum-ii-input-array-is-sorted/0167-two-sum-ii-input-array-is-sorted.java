class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=0,r=numbers.length-1;
        while(l<r){
            if (numbers[l]+numbers[r]==target)
            break;
            else if (numbers[l]+numbers[r]>target)
            r--;
            else l++;
        }
        int[] res={++l,++r};
        return(res);
    }
}