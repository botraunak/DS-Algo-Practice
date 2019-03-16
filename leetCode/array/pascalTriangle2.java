class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        if (rowIndex == 0) {
            row.add(1);
            return row;
        }
        
        long nCk = 1;
        for (int i = 0; i < rowIndex / 2; i++) {
            row.add((int) nCk);
            nCk *= rowIndex - i; 
            nCk /= i + 1;
        }
        row.add((int) nCk);
        for (int i = (rowIndex - 1) / 2; i >= 0; i--) {
            row.add(row.get(i));
        }
        
        return row;
    }
    
}