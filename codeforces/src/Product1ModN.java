import java.util.*;

public class Product1ModN {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        int n = in.nextInt();


        List<Integer> res = new ArrayList<>();
        long product = 1;

        for (int i = 1; i < n; i++) {
            if (gcd(i, n) == 1) {
                res.add(i);
                product = (product * i) % n;
            }
        }

        if (product != 1) {
            res.remove((Integer)(int) product);
        }

        System.out.println(res.size());
        for (int x : res) {
            System.out.print(x + " ");
        }

    }
}
