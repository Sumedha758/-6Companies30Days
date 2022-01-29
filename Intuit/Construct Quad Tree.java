class Solution {
    public Node construct(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return null;
        }
       return constructNodeInRange(grid, 0, grid.length - 1, 0, grid[0].length - 1);
    }
    
    private Node constructNodeInRange(int[][] grid, int rowStart, int rowEnd, int colStart, int colEnd) {
        if (rowStart == rowEnd) {
            return new  Node(grid[rowStart][colStart] == 1, true);
        }
        
        int len = rowEnd - rowStart + 1;
        int rowMid = rowStart + len / 2;
        int colMid = colStart + len / 2;
      
        Node topLeft = constructNodeInRange(grid, rowStart, rowMid - 1, colStart, colMid - 1);
        Node topRight = constructNodeInRange(grid,rowStart, rowMid - 1, colMid, colEnd);
        Node bottomLeft = constructNodeInRange(grid,  rowMid, rowEnd, colStart, colMid - 1);
        Node bottomRight = constructNodeInRange(grid,  rowMid, rowEnd,  colMid, colEnd);
        
        Node[] children = new Node[]{topLeft, topRight, bottomLeft, bottomRight};
        boolean val = topLeft.val;
        for (Node child: children) {
            if (!child.isLeaf || child.val != val) {
                return new Node(val, false, topLeft, topRight, bottomLeft, bottomRight);
            }
        }
        
        return new  Node(val, true);
    }
}
