import java.util.*;

public class RottenOranges {
    public static int orangesRotting(int[][] grid) {
        //base case
        if(grid.length == 0) return 0;

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh=0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                }else if (grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int tm=0;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        while (!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int t = curr[2];

            tm = Math.min(tm,t);

            for (int i = 0; i < 4; i++) {
                int nrow = r+delRow[i];
                int ncol = c+ delCol[i];

                if (nrow>=0 && nrow<n && ncol>=0 && ncol<m &&  grid[nrow][ncol]==1){
                    grid[nrow][ncol] = 2;
                    fresh--;
                    q.add(new int[]{nrow,ncol,t+1});
                }
            }
        }

        return fresh==0 ? tm:-1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->0){
            int n = in.nextInt();
            int m = in.nextInt();

            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j]  = in.nextInt();
                }
            }

            int time = orangesRotting(grid);
            System.out.println(time);
        }
    }
}
