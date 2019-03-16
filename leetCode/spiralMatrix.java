class Solution {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = 1;
        if(m != 0)
            n = matrix[0].length;
        
        int left = 0, up = 0, right = n-1, down = m-1;
        
        List<Integer> ans = new ArrayList<>(m*n);
        int prod = m*n;
        
        while(ans.size() < prod){
            for(int i=left; i<=right; i++)
                ans.add(matrix[up][i]);
            up++;
            if(ans.size() == prod)
                break;
            for(int i=up; i<=down; i++)
                ans.add(matrix[i][right]);
            right--;
            if(ans.size() == prod)
                break;
            for(int i=right; i>=left; i--)
                ans.add(matrix[down][i]);
            down--;
            if(ans.size() == prod)
                break;
            for(int i=down; i>=up; i--)
                ans.add(matrix[i][left]);
            left++;
        }
        
        return ans;
    }
}