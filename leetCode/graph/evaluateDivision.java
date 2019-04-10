class Solution {
    Map<String, Map<String, Double>> graph = new HashMap<>();
    
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        for(int i=0; i<equations.length; i++){
            String a = equations[i][0];
            String b = equations[i][1];
            if(!graph.containsKey(a))
                graph.put(a, new HashMap<>());
            if(!graph.containsKey(b))
                graph.put(b, new HashMap<>());
            graph.get(a).put(b, values[i]/1.0);
            graph.get(b).put(a, 1.0/values[i]);
        }
        double[] res = new double[queries.length];
        int i = 0;
        for(String[] q: queries){
            if(!graph.containsKey(q[0]))
                res[i++] = -1.0;
            else
                res[i++] = dfs(q[0],q[1], new HashSet<String>());
        }
        return res;
    }
    
    public double dfs(String num, String deno, Set<String> visited){
        if(graph.get(num).isEmpty()) return -1;
        if(graph.get(num).containsKey(deno)) return graph.get(num).get(deno);
        
        visited.add(num);        
        for(String p: graph.get(num).keySet()){
            if(visited.contains(p)) continue;
            
            double val = dfs(p,deno, visited);
            if(val!=-1)
                return graph.get(num).get(p)*val;
        }
        
        return -1;
    }
}