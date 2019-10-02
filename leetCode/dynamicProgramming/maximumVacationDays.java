class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = days.length;
        int k = days[0].length;
        
        List<Integer>[] adj = new ArrayList[n];
        int[][] dp = new int[n][k];
        for(int i=0; i<n; i++){
            dp[i][k-1] = days[i][k-1];
        }
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
            for(int j=0; j<n; j++){
                if(flights[i][j]==1)
                    adj[i].add(j);
            }
            adj[i].add(i);
        }
        for(int i=k-2; i>=0; i--){
            for(int j=0; j<n; j++){
                int max = 0;
                for(int l: adj[j]){
                    if(max<dp[l][i+1])
                        max = dp[l][i+1];
                }
                dp[j][i] = max+days[j][i];
            }
        }
        int ans = 0;
        for(int i: adj[0]){
            ans = Math.max(dp[i][0], ans);
        }
        return ans;
    }
}