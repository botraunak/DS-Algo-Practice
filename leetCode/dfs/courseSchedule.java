class Solution {
    List<Integer>[]  graph;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];
        
        for(int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] req: prerequisites){
            graph[req[1]].add(req[0]);
        }
        
        return !hasCycle(numCourses);
    }
    
    public boolean hasCycle(int vertices) {
        int[] w = new int[vertices];
        int[] b = new int[vertices];
        int[] g = new int[vertices];
        
        Arrays.fill(w, 1);
        
        for(int i=0; i<vertices; i++){
            if(w[i] == 1)
                if(dfs(i, w, g, b))
                    return true;
        }
        
        return false;
    }
    
    public boolean dfs(int node, int[] w, int[] g, int[] b){
        w[node] = 0;
        g[node] = 1;
        
        for(Integer n: graph[node]){
            if(b[n] == 1) continue;
            if(g[n] == 1) return true;
            if(dfs(n, w, g, b)) return true;
        }
        
        g[node] = 0;
        b[node] = 1;
        return false;
    }
}