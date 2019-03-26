class Solution {
    public int mySqrt(int x) {
        double n = x;
		while (Math.abs(n*n - x)>0.9){
			n = n - (n*n - x) / (2 * n);
		}
		return (int)n;
    }
}