class Solution {
    
    int[] digitSqs = new int[]{0, 1, 4, 9, 16, 25, 36, 49, 64, 81};
    
    public int sumDigitSquare(int n){
        int sum = 0;
        while(n>0){
            sum += digitSqs[n%10];
            n /= 10;
        }
        return sum;
    }
    
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(true){
            n = sumDigitSquare(n);
            if(set.contains(n))
                return false;
            if(n == 1)
                return true;
            set.add(n);
        }
    }
}
