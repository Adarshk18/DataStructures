import java.util.*;


public class MaximumRectangle {

    public static int largest(int[] heights){

        Stack<Integer> st = new Stack<>();
        int maxArea =0;
        int[] newHeights = Arrays.copyOf(heights,heights.length+1);

        for (int i = 0; i < newHeights.length; i++) {
            while (!st.isEmpty() && newHeights[i] < newHeights[st.peek()]){
                int height = newHeights[st.pop()];
                int width = st.isEmpty() ? i : i-st.peek()-1;
                maxArea = Math.max(maxArea,height*width);
            }
            st.push(i);
        }
        return maxArea;
    }
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int m = matrix[0].length;

        int[] heights = new int[m];
        int maxArea =0;

        for(char[] row: matrix){
            for (int i = 0; i < m; i++) {
                if (row[i]=='1') heights[i]++;
                else heights[i] =0;
            }
            maxArea = Math.max(maxArea, largest(heights));
        }
        return maxArea;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int m = in.nextInt();

            char[][] matrix = new char[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = in.next().charAt(0);
                }
            }

            int ans = maximalRectangle(matrix);
            System.out.println(ans);
        }
    }
}
