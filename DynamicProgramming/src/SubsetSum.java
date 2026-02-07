import java.util.*;

public class SubsetSum {
    public static boolean subsetSumToK(int n, int k, int[] arr) {
        boolean[] prev = new boolean[k + 1];
      prev[0] = true;
      if (arr[0] <= k) {
            prev[arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            boolean[] curr = new boolean[k+1];
            curr[0] = true;
            for (int target = 1; target <= k; target++) {
                boolean notTake = prev[target];
                boolean take = false;
                if (arr[ind] <= target) {
                    take = prev[target - arr[ind]];
                }

                curr[target] = notTake || take;
            }
            prev= curr;
        }
        return prev[k];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int target = in.nextInt();

            if (subsetSumToK(n, target, arr)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
