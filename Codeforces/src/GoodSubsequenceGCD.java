import java.util.*;

public class GoodSubsequenceGCD {

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int gcdOfArray(List<Integer> arr) {
        int result = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            result = gcd(result, arr.get(i));
            if (result == 1) break; // Optimization
        }
        return result;
    }

    public static int get_ans(int n, int[] a, int p, int q, int[][] queries) {
        int yesCount = 0;

        for (int[] query : queries) {
            int idx = query[0] - 1; // Convert to 0-indexed
            int newVal = query[1];
            a[idx] = newVal;

            // Find all elements divisible by p
            List<Integer> divisible = new ArrayList<>();
            for (int num : a) {
                if (num % p == 0) {
                    divisible.add(num);
                }
            }

            // Check conditions for YES
            if (divisible.size() >= 2) {
                int arrayGCD = gcdOfArray(divisible);
                if (arrayGCD == p) {
                    yesCount++;
                }
            }
            // If size < 2, we can't form a proper subset, so NO
        }

        return yesCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int p = sc.nextInt();
        int q = sc.nextInt();
        int two = sc.nextInt(); // columns (always 2)

        int[][] queries = new int[q][2];
        for (int i = 0; i < q; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }

        System.out.println(get_ans(n, a, p, q, queries));
    }
}