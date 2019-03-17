class Solution {
    
    public int getVal(Character s) {
        if (s == 'I') return 1;
        else if (s == 'V') return 5;
        else if (s == 'X') return 10;
        else if (s == 'L') return 50;
        else if (s == 'C') return 100;
        else if (s == 'D') return 500;
        else if (s == 'M') return 1000;
        return 0;
    }
    public int romanToInt(String s) {
        
        int num = 0;
        int i = 0;
        for (i=0; i < s.length(); i++) {
            int curr = getVal(s.charAt(i));
            int next = (i + 1 < s.length()) ? getVal(s.charAt(i + 1)) : 0;
            if (curr < next) {
                num += (next - curr);
                i = i + 1;
            } else {
                num += curr;
            }
        }
        
        return num;
    }
}