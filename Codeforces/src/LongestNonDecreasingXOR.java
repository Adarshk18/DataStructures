import java.util.*;

public class LongestNonDecreasingXOR {

    public static int get_ans(int N, int M, int[] A) {
        // dp[i] = Map<XOR, maxLength>
        Map<Integer, Integer>[] dp = new HashMap[N];
        for (int i = 0; i < N; i++) {
            dp[i] = new HashMap<>();
        }

        // Initialize: single elements
        for (int i = 0; i < N; i++) {
            dp[i].put(A[i], 1);
        }

        // DP transitions
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] <= A[i]) { // Non-decreasing
                    for (Map.Entry<Integer, Integer> entry : dp[j].entrySet()) {
                        int prevXOR = entry.getKey();
                        int prevLen = entry.getValue();
                        int newXOR = prevXOR ^ A[i];

                        dp[i].put(newXOR, Math.max(
                                dp[i].getOrDefault(newXOR, 0),
                                prevLen + 1
                        ));
                    }
                }
            }
        }

        // Find maximum length with XOR >= M
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            for (Map.Entry<Integer, Integer> entry : dp[i].entrySet()) {
                if (entry.getKey() >= M) {
                    maxLen = Math.max(maxLen, entry.getValue());
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        System.out.println(get_ans(N, M, A));
    }
}