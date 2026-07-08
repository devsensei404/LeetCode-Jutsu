class Solution {
    public String largestOddNumber(String num) {
       
        int k=0;int i=num.length()-1;
        for (;i>=0;i--)
        {
            if((int)num.charAt(i)%2!=0)
            break;
        }
       if(i==0&&(int)num.charAt(0)%2==0)
       return ("");
       return (num.substring(0,i+1));
       
    }
}