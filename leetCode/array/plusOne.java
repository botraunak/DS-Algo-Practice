class Solution {
    public int[] plusOne(int[] digits) {
        
        int carry = 1;
        int i = digits.length - 1;
        do {
            int sum = digits[i] + carry;
            digits[i] = sum%10;
            carry = sum/10;
            i--;
        } while (carry != 0 && i >= 0);
        
        if (carry != 0) {
            int[] res = new int[digits.length + 1];
            res[0] = carry;
            return res;
        }
        
        return digits;
    }
}