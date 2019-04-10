/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    final int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    private void helper(Robot robot, Set<String> visited, int curDirection, int row, int col){
        StringBuilder sb= new StringBuilder();
        sb.append(row);
        sb.append(":");
        sb.append(col);
        visited.add(sb.toString());
        robot.clean();
        for(int i=0; i<4;++i){
            int nextRow= row+dir[(curDirection+i)%4][0];
            int nextCol = col+dir[(curDirection+i)%4][1];
            sb = new StringBuilder();
            sb.append(nextRow);
            sb.append(":");
            sb.append(nextCol);
            if(!visited.contains(sb.toString()) && robot.move()){
                helper(robot, visited, (curDirection+i)%4, nextRow, nextCol);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
        }
    }
    
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        helper(robot,visited,0,0,0);
    }
}