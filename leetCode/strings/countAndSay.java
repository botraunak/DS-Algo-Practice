class Solution {
    private int n;
    private StringBuilder sb;
    public String countAndSay(int n) {
        if(n==1) return "1";
		this.n = n-1;
        sb = new StringBuilder();
		return func("1", 1);
    }
    
    public String func(String input, int i) {
		int len = input.length();
		sb.setLength(0);
		int j = 0, k;
		while(j<len){
			k=j+1;
			while(k<len&&input.charAt(j)==input.charAt(k)) k++;
			sb.append(""+(k-j)+input.charAt(j));
			j = k;
		}
		if(i==n) return sb.toString();
		return func(sb.toString(), i+1);
	}
}