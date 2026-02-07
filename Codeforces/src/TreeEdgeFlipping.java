import java.util.*;

public class TreeEdgeFlipping {

    static class Node {
        int id;
        List<Node> children = new ArrayList<>();
        int val;
    }

    static int M;
    static Node[] nodes;
    static int maxPaths;
    static int minCost;

    // Check if string 'path' contains 'query' as substring
    static boolean containsSubstring(String path, String query) {
        return path.contains(query);
    }

    // DFS to enumerate all root-to-leaf paths
    static void dfs(Node node, String currentPath, String query, int flips) {
        currentPath += node.val;

        if (node.children.isEmpty()) { // Leaf node
            if (containsSubstring(currentPath, query)) {
                int cost = flips * M;
                if (flips > maxPaths || (flips == maxPaths && cost < minCost)) {
                    maxPaths = flips;
                    minCost = cost;
                }
            }
            return;
        }

        for (Node child : node.children) {
            // Try without flipping
            dfs(child, currentPath, query, flips);

            // Try with flipping (toggle both node and child)
            int origNode = node.val;
            int origChild = child.val;
            node.val = 1 - node.val;
            child.val = 1 - child.val;

            dfs(child, currentPath.substring(0, currentPath.length() - 1) + node.val,
                    query, flips + 1);

            // Restore
            node.val = origNode;
            child.val = origChild;
        }
    }

    public static int get_ans(int N, int m, int[] Parent, int[] Val,
                              int Q, String[] queries) {
        M = m;
        nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node();
            nodes[i].id = i;
            nodes[i].val = Val[i];
        }

        // Build tree
        for (int i = 1; i < N; i++) {
            nodes[Parent[i]].children.add(nodes[i]);
        }

        int totalCost = 0;

        for (String query : queries) {
            maxPaths = 0;
            minCost = Integer.MAX_VALUE;
            dfs(nodes[0], "", query, 0);
            totalCost += minCost == Integer.MAX_VALUE ? 0 : minCost;
        }

        return totalCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] Parent = new int[N];
        int[] Val = new int[N];

        for (int i = 0; i < N; i++) Parent[i] = sc.nextInt();
        for (int i = 0; i < N; i++) Val[i] = sc.nextInt();

        int Q = sc.nextInt();
        sc.nextLine();
        String[] queries = new String[Q];
        for (int i = 0; i < Q; i++) {
            queries[i] = sc.nextLine().trim();
        }

        System.out.println(get_ans(N, M, Parent, Val, Q, queries));
    }
}