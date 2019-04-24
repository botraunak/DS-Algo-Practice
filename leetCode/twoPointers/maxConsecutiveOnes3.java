class Solution {
    public int longestOnes(int[] A, int K) {
        int max1 = 0, p=0;
        int zero = 0;
        for(int i=0; i<A.length; i++){
            if(A[i] == 0)
                zero++;
            while(zero>K){
                if(A[p++] == 0) zero--;
            }
            max1 = Math.max(max1, i-p+1);
        }
        
        return max1;
    }
}