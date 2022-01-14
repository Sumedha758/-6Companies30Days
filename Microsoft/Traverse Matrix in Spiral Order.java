class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        ArrayList<Integer> ans=new ArrayList<>();
        boolean vis[][]=new boolean[m][n];
        int i=0;
        int j=0;
        while(true){
            int f=0;
            while(i <m && j <n && vis[i][j] == false){
                ans.add(matrix[i][j]);
                vis[i][j]=true;
                j++;
                f=1;
            }
            j--;
            i++;
            while(i < m && j < n && vis[i][j] == false){
                ans.add(matrix[i][j]);
                vis[i][j]=true;
                i++;
                f=1;
            }
            i--;
            j--;
            while(i <m && j >= 0 && vis[i][j] == false){
                ans.add(matrix[i][j]);
                vis[i][j]=true;
                j--;
                f=1;
            }
            i--;
            j++;
            while(i >= 0 && j < n && vis[i][j] == false){
                ans.add(matrix[i][j]);
                vis[i][j]=true;
                i--;
                f=1;
            }
            i++;
            j++;
            if(f == 0){
                break;
            }
        }
        return ans;
    }
}
