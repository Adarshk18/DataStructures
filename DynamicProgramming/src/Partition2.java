import java.util.*;

public class Partition2 {
    public static int minimumDifference(int[] nums) {
        int n = nums.length;
        int totalSum =0;
        for(int arr: nums){
            totalSum += arr;
        }

        boolean[] prev = new boolean[totalSum+1];

        prev[0] = true;

        if (nums[0]<=totalSum) prev[nums[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            boolean[] curr =new boolean[totalSum+1];
            curr[0] = true;
            for (int target = 1; target <= totalSum; target++) {
                boolean notTake = prev[target];
                boolean take = false;
                if (nums[ind]<=target) take = prev[target-nums[ind]];
                curr[target] = notTake || take;
            }
            prev = curr;
        }

        int mini = Integer.MAX_VALUE;
        for (int s1 = 1; s1 <= totalSum; s1++) {
            if (prev[s1]){
                mini = Math.min(mini, Math.abs((totalSum-s1)-s1));
            }

        }
        return mini;

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
           int ans = minimumDifference(arr);
            System.out.println(ans);
        }
    }
}
