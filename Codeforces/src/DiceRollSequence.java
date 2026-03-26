import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DiceRollSequence {
    public static void solve(BufferedReader br, StringBuilder sb) throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (v[i] == v[i-1] || v[i] + v[i-1] ==7){
                v[i] = 10;
                ans++;
            }
        }

        sb.append(ans).append("\n");
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while(t-->0){
            solve(br,sb);
        }
        System.out.println(sb);
    }
}

