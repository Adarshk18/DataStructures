import java.util.*;

public class BurstBalloons {

    public static int maxCoins(int[] nums) {
        int n = nums.length;
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        for (int c : nums) arr.add(c);

        arr.add(1);
        int[][] dp = new int[n + 2][n + 2];

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                int max = Integer.MIN_VALUE;
                for (int ind = i; ind <= j; ind++) {
                    int cost = nums[ind - 1] * nums[ind] * nums[ind + 1] + dp[i][ind - 1] + dp[ind + 1][j];
                    max = Math.max(max, cost);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-- > 0) {

            int n = in.nextInt();


            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = in.nextInt();

            int ans = maxCoins(arr);
            System.out.println(ans);
        }
    }
}
