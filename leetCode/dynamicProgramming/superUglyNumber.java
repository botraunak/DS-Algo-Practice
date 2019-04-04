class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int pl = primes.length;
        int[] idx = new int[pl];
        int[] nums = new int[pl];
        for(int i=0; i<pl; i++){
            nums[i] = primes[i];
        }
        for(int i=1; i<n; i++){
            int min = nums[0];
            for(int j=1; j<pl; j++){
                if(min>nums[j]) min = nums[j];
            }            
            ugly[i] = min;
            for(int j=0; j<pl; j++){
                if(min == nums[j]){
                    idx[j] += 1;
                    nums[j] = primes[j]*ugly[idx[j]];
                }
            }
            
        }
        return ugly[n-1];
    }
}