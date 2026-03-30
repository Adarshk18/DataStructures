import java.util.*;
import java.io.*;

public class etAnotherArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            String[] parts = br.readLine().split(" ");

            long g =0;
            for(int i=0; i<n; i++){
                long value = Long.parseLong(parts[i]);
                g = gcd(g,value);
            }

            for (int i = 2; i <=100 ; i++) {
                if (gcd(i,g)==1){
                    sb.append(i).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    static long gcd(long a, long b){
        while(b!=0){
           long tmp = a%b;
           a= b;
           b = tmp;
        }
        return a;
    }
}
