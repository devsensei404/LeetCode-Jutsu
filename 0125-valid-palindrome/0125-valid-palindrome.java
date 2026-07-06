class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length()-1;
        while(l<r) {
            // Move left pointer until we find a letter or digit
            while(l<r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            // Move right pointer until we find a letter or digit
            while(l<r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            // Compare both chars (in lowercase)
            if(Character.toLowerCase(s.charAt(l++)) != Character.toLowerCase(s.charAt(r--))) return false;
        } 
        return true;
    }
}