import java.util.*;

public class WildCardMatching {

    // Checks if pattern[0..i] contains only '*'
    public static boolean isAllStars(String p, int i) {
        for (int j = 0; j <= i; j++) {
            if (p.charAt(j) != '*') {
                return false;
            }
        }
        return true;
    }

    public static int isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        // Base case: empty string & empty pattern
        prev[0] = 1;

        // Pattern matches empty string only if all '*'
        for (int j = 1; j <= m; j++) {
            prev[j] = isAllStars(p, j - 1) ? 1 : 0;
        }

        for (int i = 1; i <= n; i++) {
            curr[0] = 0; // non-empty string can't match empty pattern

            for (int j = 1; j <= m; j++) {

                // Match or '?'
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    curr[j] = prev[j - 1];
                }
                // '*'
                else if (p.charAt(j - 1) == '*') {
                    curr[j] = (prev[j] == 1 || curr[j - 1] == 1) ? 1 : 0;
                }
                // No match
                else {
                    curr[j] = 0;
                }
            }

            // Move curr to prev
            prev = curr.clone();
        }

        return prev[m];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            String s = in.next();
            String p = in.next();

            System.out.println(isMatch(s, p) == 1 ? "true" : "false");
        }
    }
}
