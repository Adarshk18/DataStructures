import java.io.*;

public class placeSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String[] first = br.readLine().split(" ");
            int n = Integer.parseInt(first[0]);
            int q = Integer.parseInt(first[1]);

            int[] a = new int[n+1];
            int[] b = new int[n+1];

            String[] ain = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(ain[i-1]);
            }

            String[] bin = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                b[i] = Integer.parseInt(bin[i-1]);
            }

            long[] best = new long[n+2];
            best[n] = Math.max(a[n],b[n]);
            for (int i = n-1; i >= 1; i--) {
                best[i] = Math.max(Math.max(a[i],b[i]), best[i+1]);
            }

            long[] pref = new long[n+1];
            for (int i = 1; i <= n; i++) {
                pref[i] = pref[i-1] + best[i];
            }

            for (int i = 0; i < q; i++) {
                String[] lr = br.readLine().split(" ");
                int l = Integer.parseInt(lr[0]);
                int r = Integer.parseInt(lr[1]);

                long ans = pref[r] - pref[l-1];
                sb.append(ans).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
