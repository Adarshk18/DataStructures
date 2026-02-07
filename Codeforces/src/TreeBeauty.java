import java.util.*;

public class TreeBeauty {

    static final int MOD = 1000000007;
    static List<Integer>[] tree;
    static int[] values;
    static long totalBeauty = 0;

    public static int getFreeSqPart(int n) {
        int res = 1;
        for (int i = 2; i * i <= n; i++) {
            int cnt = 0;
            while (n % i == 0) {
                cnt++;
                n /= i;
            }
            if (cnt % 2 == 1) {
                res *= i;
            }
        }
        if (n > 1) {
            res *= n;
        }
        return res;
    }

    static Map<Integer, Integer> dfs(int node) {
        Map<Integer, Integer> freq = new HashMap<>();
        int squareFree = getFreeSqPart(values[node]);
        freq.put(squareFree, 1);

        long localBeauty = 0;
        // Process all children
        for (int child : tree[node]) {
            Map<Integer, Integer> childFreq = dfs(child);

            // Count pairs between current subtree and child subtree
            for (Map.Entry<Integer, Integer> entry : childFreq.entrySet()) {
                int sf = entry.getKey();
                int childCount = entry.getValue();

                if (freq.containsKey(sf)) {
                    localBeauty += (long) freq.get(sf) * childCount;
                }
            }

            // Merge child frequencies into current
            for (Map.Entry<Integer, Integer> entry : childFreq.entrySet()) {
                freq.put(entry.getKey(), freq.getOrDefault(entry.getKey(), 0) + entry.getValue());
            }
        }

        // Add pairs within this node's subtree
        for (int count : freq.values()) {
            if (count > 1) {
                localBeauty += (long) count * (count - 1) / 2;
            }
        }

        totalBeauty = (totalBeauty + localBeauty) % MOD;
        return freq;
    }

    public static int get_ans(int n, int[] par, int[] a) {
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = a[i];
        }

        // Build tree from parent array
        for (int i = 1; i < n; i++) {
            tree[par[i]].add(i);
        }

        totalBeauty = 0;
        dfs(0);

        return (int) totalBeauty;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] par = new int[n];
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            par[i] = sc.nextInt();
            a[i] = sc.nextInt();
        }

        System.out.println(get_ans(n, par, a));
    }
}
