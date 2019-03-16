class Solution {
    public int[] plusOne(int[] digits) {
        int i;
        for(i = digits.length - 1; i > -1; i--){
            if(digits[i] != 9)
                break;
        }
        
        if(i == -1){
            int[] ans = new int[digits.length+1];
            ans[0] = 1;
            return ans;
        }
        
        int carry = 1;
        
        for(i = digits.length - 1; i >= 0 && carry != 0; i--){
            digits[i] += carry;
            carry = digits[i]/10;
            digits[i] %= 10;
        }
        
        return digits;
    }
}