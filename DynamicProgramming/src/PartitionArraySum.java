import java.util.*;

public class PartitionArraySum {

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[n] = 0;

        for (int i = n-1; i >= 0; i--) {
            int maxi = Integer.MIN_VALUE; int sum =0; int len=0; int maxAns=Integer.MIN_VALUE;
            for (int j = i; j < Math.min(i+k,n); j++) {
                len++;
                maxi = Math.max(maxi,arr[j]);
                sum =  len * maxi + dp[j+1];
                maxAns = Math.max(maxAns,sum);
            }
            dp[i] = maxAns;
        }
        return dp[0];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();
        while (t-->0){
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int k = in.nextInt();
            int ans = maxSumAfterPartitioning(arr,k);
            System.out.println(ans);
        }
    }
}
