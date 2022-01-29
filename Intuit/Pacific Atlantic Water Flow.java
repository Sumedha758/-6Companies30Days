class Solution {
    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, Integer.MIN_VALUE, i, 0);
            dfs(heights, atlantic, Integer.MIN_VALUE, i, n-1);
        }
        
        for (int i = 0; i < n; i++) {
            dfs(heights, pacific, Integer.MIN_VALUE, 0, i);
            dfs(heights, atlantic, Integer.MIN_VALUE, m-1, i);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    
    private void dfs(int[][] heights, boolean[][] visited, int height, int x, int y) {
        int m = heights.length, n = heights[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || height > heights[x][y]) {
            return;
        }
        visited[x][y] = true;
        dfs(heights, visited, heights[x][y], x+1, y);
        dfs(heights, visited, heights[x][y], x-1, y);
        dfs(heights, visited, heights[x][y], x, y+1);
        dfs(heights, visited, heights[x][y], x, y-1);
    }
}
