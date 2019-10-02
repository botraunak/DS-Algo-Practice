class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        char[] state = new char[numCourses];
        Arrays.fill(state, 'w');
        List<Integer>[] g = new ArrayList[numCourses];
        for(int[] e: prerequisites){
            if(g[e[1]] == null)
                g[e[1]] = new ArrayList<>();
            g[e[1]].add(e[0]);
        }
        Stack<Integer> ts = new Stack<>();
        for(int i=0; i<numCourses; i++)
            if(state[i] == 'w')
                dfs(g, i, state, ts);
        if(ts.size() != numCourses)
            return new int[]{};
        int[] res = new int[numCourses];
        int k = 0;
        while(!ts.empty()){
            res[k++] = ts.pop();
        }
        return res;
    }
    
    public void dfs(List<Integer>[] g, int n, char[] state, Stack<Integer> ts){
        if(state[n] == 'b' || state[n] == 'g')
            return;
        state[n] = 'g';
        if(g[n] != null){
            for(int i: g[n]){
                if(state[i] == 'b')
                    continue;
                if(state[i] == 'g')
                    return;
                dfs(g, i, state, ts);
            }
        }
        ts.push(n);
        state[n] = 'b';
    }
}