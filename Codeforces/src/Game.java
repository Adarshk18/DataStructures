import java.util.*;

public class Game {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-->0){
            int n = in.nextInt();

            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
            }

            Arrays.sort(a);

            long[] b = new long[n];
            for (int i = 0; i < n; i++) {
                b[i] = in.nextLong();
            }

            for (int i = 1; i < n; i++) {
                b[i] += b[i-1];
            }

            int j = -1;
            long ans =0;

            for (int i = 0; i < n; i++) {
                long cnt = n-i;

                while (j<n-1 && b[j+1] <= cnt){
                    j++;
                }

                while (j>=0 && b[j] > cnt){
                    j--;
                }

                ans = Math.max(ans, a[i] * (j+1));
            }
            System.out.println(ans);
        }
    }
}
