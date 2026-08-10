class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int armax=0;
        int l=0,r=n-1;
        while(l<r){
            int ar=(r-l)*Math.min(height[l],height[r]);
            if(ar>armax)
            armax=ar;
            if(height[l]<=height[r])
            l++;
            else r--;
        }
        return armax;
}}